package com.schnarbiesnmeowers.nmsmonolith.dtos.utility;

import java.time.LocalDate;
import java.util.List;

public class GraphWrapperDTO<T> {

    List<LocalDate> dateRange;

    List<T> data;

    public GraphWrapperDTO() {
    }

    public GraphWrapperDTO(List<LocalDate> dateRange, List<T> data) {
        this.dateRange = dateRange;
        this.data = data;
    }

    public List<LocalDate> getDateRange() {
        return dateRange;
    }

    public void setDateRange(List<LocalDate> dateRange) {
        this.dateRange = dateRange;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
