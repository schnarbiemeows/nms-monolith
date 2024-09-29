package com.schnarbiesnmeowers.nmsmonolith.utilities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateUtil {

    /**
     *
     *
     * @param firstDateInRange
     * @return
     */
    public static List<LocalDate> getDateList(LocalDate firstDateInRange) {
        LocalDate today = LocalDate.now();
        List<LocalDate> dates = new ArrayList();
        long dayRange = ChronoUnit.DAYS.between(firstDateInRange,today);
        for(int i=0;i<=dayRange;i++) {
            dates.add(firstDateInRange.plusDays(i));
        }
        return dates;
    }

    public static List<LocalDate> getDateList(int daysBack) {
        LocalDate today = LocalDate.now();
        LocalDate firstDateInRange = today.minusDays(daysBack-1);
        List<LocalDate> dates = new ArrayList();
        long dayRange = ChronoUnit.DAYS.between(firstDateInRange,today);
        for(int i=0;i<=dayRange;i++) {
            dates.add(firstDateInRange.plusDays(i));
        }
        return dates;
    }

    public static int getDaysBetween(LocalDate start, LocalDate end) {
        return Period.between(start,end).getDays();
    }
}
