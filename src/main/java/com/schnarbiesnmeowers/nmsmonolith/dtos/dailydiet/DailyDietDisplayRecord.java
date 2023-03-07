package com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import java.io.Serializable;


public class DailyDietDisplayRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private IngredientsDTO data;
    private DailyDietDTO dailyInfo;

    public DailyDietDisplayRecord() {
    }

    public DailyDietDisplayRecord(IngredientsDTO data, DailyDietDTO dailyInfo) {
        this.data = data;
        this.dailyInfo = dailyInfo;
    }

    public IngredientsDTO getData() {
        return data;
    }

    public void setData(IngredientsDTO data) {
        this.data = data;
    }

    public DailyDietDTO getDailyInfo() {
        return dailyInfo;
    }

    public void setDailyInfo(DailyDietDTO dailyInfo) {
        this.dailyInfo = dailyInfo;
    }

    @Override
    public String toString() {
        return "DailyDietDisplayRecord{" +
                "data=" + data +
                ", dailyInfo=" + dailyInfo +
                '}';
    }
}