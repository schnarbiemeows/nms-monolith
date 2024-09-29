package com.schnarbiesnmeowers.nmsmonolith.services.helpers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import com.schnarbiesnmeowers.nmsmonolith.pojos.tuples.Tuple3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
public class DailyWeightUtilTest {

    //@Test
    public void testGetDataMissingDataAndMissingDates() {
        LocalDate today = LocalDate.now();
        int daysBack = 7;
        List<DailyWeightDataPoint> records = new ArrayList();
        /**
         * TEST - 0 0 0 212 0 0 0
         * so, 7 days back, but there was only a weight record for 4 days ago
         * result should be:
         * valid date = 0.0 0.0 0.0 212.0 0.0 0.0 0.0
         * missing data = 212.0 212.0 212.0 0.0 212.0 212.0 212.0
         */
        LocalDate fourDaysAgo = today.minusDays(3);
        DailyWeightDataPoint dp = new DailyWeightDataPoint()
                .calendarDate(fourDaysAgo)
                .weight(BigDecimal.valueOf(212.0));
        records.add(dp);
        List<LocalDate> dateList = DailyWeightUtil.getDateList(records,daysBack);
        assertEquals(dateList.size(),7);
        Tuple3<List<DailyWeightDataPoint>,List<DailyWeightDataPoint>,List<LocalDate>> dataMissingDataAndMissingDates =
                DailyWeightUtil.getDataMissingDataAndMissingDates(records,dateList);
        List<DailyWeightDataPoint> validDataPoints = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getA();
        List<DailyWeightDataPoint> missingData = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getB();
        List<LocalDate> missingDates = (List<LocalDate>)dataMissingDataAndMissingDates.getC();
        System.out.println("here");
        records = new ArrayList();
        /**
         * TEST - 210 0 0 0 0 0 220
         * result should be
         * valid = 210.0 0 0 0 0 0 220.0
         * missing = 0 215.0 215.0 215.0 215.0 215.0 0
         */
        LocalDate sevenDaysAgo = today.minusDays(6);
        dp = new DailyWeightDataPoint()
                .calendarDate(sevenDaysAgo)
                .weight(BigDecimal.valueOf(210.0));
        records.add(dp);
        LocalDate zeroDaysAgo = today;
        dp = new DailyWeightDataPoint()
                .calendarDate(zeroDaysAgo)
                .weight(BigDecimal.valueOf(220.0));
        records.add(dp);
        dateList = DailyWeightUtil.getDateList(records,daysBack);
        dataMissingDataAndMissingDates =
                DailyWeightUtil.getDataMissingDataAndMissingDates(records,dateList);
        validDataPoints = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getA();
        missingData = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getB();
        missingDates = (List<LocalDate>)dataMissingDataAndMissingDates.getC();
        System.out.println("here");
        records = new ArrayList();
        /**
         * TEST - 0 0 210 0 220 0 0
         * result should be
         * valid = 0 0 210 0 220 0 0
         * missing = 210 210 0 215 0 220 220
         */
        sevenDaysAgo = today.minusDays(4);
        dp = new DailyWeightDataPoint()
                .calendarDate(sevenDaysAgo)
                .weight(BigDecimal.valueOf(210.0));
        records.add(dp);
        zeroDaysAgo = today.minusDays(2);
        dp = new DailyWeightDataPoint()
                .calendarDate(zeroDaysAgo)
                .weight(BigDecimal.valueOf(220.0));
        records.add(dp);
        dateList = DailyWeightUtil.getDateList(records,daysBack);
        dataMissingDataAndMissingDates =
                DailyWeightUtil.getDataMissingDataAndMissingDates(records,dateList);
        validDataPoints = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getA();
        missingData = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getB();
        missingDates = (List<LocalDate>)dataMissingDataAndMissingDates.getC();
        System.out.println("here");
    }

    //@Test
    public void testCalculateMissingData() {

    }


}
