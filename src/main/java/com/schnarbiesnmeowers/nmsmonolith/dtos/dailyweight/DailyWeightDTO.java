package com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DailyWeightDTO implements Serializable {

    private List<DailyWeightDataPoint> data;

    private List<DailyWeightDataPoint> missingData;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal average;
    private Integer dayRange;
    private List<LocalDate> missingDates;

    public DailyWeightDTO() {
    }

    public DailyWeightDTO(List<DailyWeightDataPoint> data, List<DailyWeightDataPoint> missingData,
        BigDecimal min, BigDecimal max, BigDecimal average, Integer dayRange, List<LocalDate> missingDates) {
        this.data = data;
        this.missingData = missingData;
        this.min = min;
        this.max = max;
        this.average = average;
        this.dayRange = dayRange;
        this.missingDates = missingDates;
    }

    public List<DailyWeightDataPoint> getData() {
        return data;
    }

    public DailyWeightDTO data(List<DailyWeightDataPoint> data) {
        this.data = data;
        return this;
    }
    public void setData(List<DailyWeightDataPoint> data) {
        this.data = data;
    }

    public List<DailyWeightDataPoint> getMissingData() {
        return missingData;
    }
    public DailyWeightDTO missingData(List<DailyWeightDataPoint> missingData) {
        this.missingData = missingData;
        return this;
    }
    public void setMissingData(List<DailyWeightDataPoint> missingData) {
        this.missingData = missingData;
    }

    public BigDecimal getMin() {
        return min;
    }
    public DailyWeightDTO min(BigDecimal min) {
        this.min = min;
        return this;
    }
    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }
    public DailyWeightDTO max(BigDecimal max) {
        this.max = max;
        return this;
    }
    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getAverage() {
        return average;
    }
    public DailyWeightDTO average(BigDecimal average) {
        this.average = average;
        return this;
    }
    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public Integer getDayRange() {
        return dayRange;
    }
    public DailyWeightDTO dayRange(Integer dayRange) {
        this.dayRange = dayRange;
        return this;
    }
    public void setDayRange(Integer dayRange) {
        this.dayRange = dayRange;
    }

    public List<LocalDate> getMissingDates() {
        return missingDates;
    }
    public DailyWeightDTO missingDates(List<LocalDate> missingDates) {
        this.missingDates = missingDates;
        return this;
    }
    public void setMissingDates(List<LocalDate> missingDates) {
        this.missingDates = missingDates;
    }
}
