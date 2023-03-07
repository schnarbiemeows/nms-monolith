package com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet;

import java.io.Serializable;
import java.util.Date;

public class DailyDietRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private Date date;

    public DailyDietRequest() {
    }

    public DailyDietRequest(Integer userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DailyDietRequest{" +
                "userId=" + userId +
                ", date=" + date +
                '}';
    }
}
