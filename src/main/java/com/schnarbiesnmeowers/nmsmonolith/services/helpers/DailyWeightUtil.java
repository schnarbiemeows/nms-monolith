package com.schnarbiesnmeowers.nmsmonolith.services.helpers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import com.schnarbiesnmeowers.nmsmonolith.pojos.tuples.Tuple2;
import com.schnarbiesnmeowers.nmsmonolith.pojos.tuples.Tuple3;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DailyWeightUtil {

    public static final MathContext m = new MathContext(5); // XXX.XX --> BC nobody is gonna weight 1000 lbs!

    /**
     *
     * @param records
     * @param daysBack
     * @return
     */
    public static List<LocalDate> getDateList(List<DailyWeightDataPoint> records, int daysBack) {
        LocalDate today = LocalDate.now();
        LocalDate firstDateInRange = today.minusDays(daysBack-1);
        List<LocalDate> dates = new ArrayList();
        long dayRange = ChronoUnit.DAYS.between(firstDateInRange,today);
        if(null!=records&&!records.isEmpty()) {
            // 1. make the LocalDate list
            for(int i=0;i<=dayRange;i++) {
                dates.add(firstDateInRange.plusDays(i));
            }
        }
        return dates;
    }
    /**
     * this method will return a list of date strings(format = "YYYY-MM-dd") that are missing
     * from the array of records
     * the records should already be sorted chronologically
     * algorithm:
     *
     * @param records
     * @return
     */
    public static List<LocalDate> findMissingDates(List<DailyWeightDataPoint> records, List<LocalDate> dateList) {
        List<LocalDate> missingDates = new ArrayList();
        if(null!=records&&!records.isEmpty()) {
            // 2. map the records to a <LocalDate,datapoint> map
            Map<LocalDate,DailyWeightDataPoint> recordsMap = new HashMap();
            for(DailyWeightDataPoint record : records) {
                recordsMap.put(record.getCalendarDate(),record);
            }
            for(LocalDate date : dateList) {
                if(!recordsMap.containsKey(date)) {
                    missingDates.add(date);
                }
            }
        }
        return missingDates;
    }

    public static Tuple3<List<DailyWeightDataPoint>, List<DailyWeightDataPoint>, List<LocalDate>>
        getDataMissingDataAndMissingDates(List<DailyWeightDataPoint> records, List<LocalDate> dateList) {
        List<LocalDate> missingDates = new ArrayList();
        List<DailyWeightDataPoint> data = new ArrayList();
        List<DailyWeightDataPoint> missingData = new ArrayList();
        if(null!=records&&!records.isEmpty()) {
            Map<LocalDate,DailyWeightDataPoint> recordsMap = new HashMap();
            for(DailyWeightDataPoint record : records) {
                recordsMap.put(record.getCalendarDate(),record);
            }
            for(int i=0;i<dateList.size();i++) {
                /**
                 * if the recordsMap contains a data point for that date:
                 * - transfer it to the data list
                 * - make a zero value data point for the missingData list
                 */
                LocalDate tempDate = dateList.get(i);
                if(recordsMap.containsKey(tempDate)) {
                    data.add(recordsMap.get(tempDate));
                    DailyWeightDataPoint zeroValuePoint = new DailyWeightDataPoint()
                            .weight(BigDecimal.ZERO)
                            .calendarDate(tempDate);
                    missingData.add(zeroValuePoint);
                }
                else
                /**
                 * if it doesn't:
                 * - add a zero value data point to the data list
                 * - make an interpolated data point and add it to the missingData list
                 *      - you need the first data point to the left and/or right of that date
                 *      in order to calculate it
                 *      - if there is no weight to the left, its value = weight to the right
                 *      - if there is no weight to the right, its value is the weight to the left
                 *      - if both exist, it is the average of the two
                 */
                {
                    missingDates.add(tempDate);
                    DailyWeightDataPoint zeroValuePoint = new DailyWeightDataPoint()
                            .weight(BigDecimal.ZERO)
                            .calendarDate(tempDate);
                    data.add(zeroValuePoint);
                    LocalDate leftDate = null;
                    LocalDate rightDate = null;
                    int j = i-1;
                    int k = i+1;
                    while(j>=0&&leftDate==null) {
                        if(recordsMap.containsKey(dateList.get(j))) {
                            leftDate = dateList.get(j);
                        }
                        j--;
                    }
                    while(k<dateList.size()&&rightDate==null) {
                        if(recordsMap.containsKey(dateList.get(k))) {
                            rightDate = dateList.get(k);
                        }
                        k++;
                    }
                    // at this point one of them HAS to have a date
                    BigDecimal interpolatedWeight = calculateMissingWeight(recordsMap.get(leftDate),recordsMap.get(rightDate));
                    DailyWeightDataPoint missingDataPoint = new DailyWeightDataPoint()
                            .weight(interpolatedWeight)
                            .calendarDate(tempDate);
                    missingData.add(missingDataPoint);
                }
            }
        }
        return new Tuple3(data,missingData,missingDates);
    }

    private static BigDecimal calculateMissingWeight(DailyWeightDataPoint previous, DailyWeightDataPoint next) {
        if(previous==null) return next.getWeight();
        if(next==null) return previous.getWeight();
        double average = (previous.getWeight().doubleValue()+next.getWeight().doubleValue())/2.0;
        return new BigDecimal(average).round(m);
    }
    public static Tuple2<BigDecimal,BigDecimal> findMinAndMaxWeights(List<DailyWeightDataPoint> records) {
        double min = BigDecimal.valueOf(Double.MAX_VALUE).doubleValue();
        double max = BigDecimal.valueOf(Double.MIN_VALUE).doubleValue();
        for(DailyWeightDataPoint record: records) {
            min = Math.min(min,record.getWeight().doubleValue());
            max = Math.max(max,record.getWeight().doubleValue());
        }

        return new Tuple2<BigDecimal,BigDecimal>(new BigDecimal(min).round(m),new BigDecimal(max).round(m));
    }

    /**
     *
     * @param records
     * @return
     */
    public static BigDecimal findAverageWeight(List<DailyWeightDataPoint> records) {
        double total = BigDecimal.valueOf(0.00).doubleValue();
        int count = 0;
        for(DailyWeightDataPoint record: records) {
            total += record.getWeight().doubleValue();
            count++;
        }
        double average = total/count;
        return new BigDecimal(average).round(m);
    }

    /**
     *
     * @param resultsdto
     * @param startingDate
     * @return
     */
    public static List<DailyWeightDataPoint> calculateMissingData(List<DailyWeightDataPoint> resultsdto, LocalDate startingDate) {
        LocalDate today = LocalDate.now();
        long dayRange = ChronoUnit.DAYS.between(startingDate, today);
        /**
         * 1. get a list of dates
         * 2. if there is an entry in the original list, put a 0.0 entry in the new list
         * 3. if not, calculate the weight for this date and put in new list, and add this date to a date list
         * 4. return the new list and the date list
         */
        return resultsdto;
    }
}
