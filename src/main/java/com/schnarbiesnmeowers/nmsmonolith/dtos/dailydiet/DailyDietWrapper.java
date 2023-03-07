package com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DailyDietWrapper implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<DailyDietDisplayRecord> ingredients;

    private List<DailyDietTotalsDTO> dailyTotals;
    private DailyDietaryNotesDTO notes;

    private Date daysDate;

    private boolean exclude;

    private boolean synced;
    private Integer userId;

    private String username;

    public DailyDietWrapper() {
    }

    public DailyDietWrapper(List<DailyDietDisplayRecord> ingredients, List<DailyDietTotalsDTO> dailyTotals,
        DailyDietaryNotesDTO notes, Date daysDate, boolean exclude, boolean synced, Integer userId, String username) {
        this.ingredients = ingredients;
        this.dailyTotals = dailyTotals;
        this.notes = notes;
        this.daysDate = daysDate;
        this.exclude = exclude;
        this.synced = synced;
        this.userId = userId;
        this.username = username;
    }

    public List<DailyDietDisplayRecord> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DailyDietDisplayRecord> ingredients) {
        this.ingredients = ingredients;
    }

    public DailyDietaryNotesDTO getNotes() {
        return notes;
    }

    public void setNotes(DailyDietaryNotesDTO notes) {
        this.notes = notes;
    }

    public Date getDaysDate() {
        return daysDate;
    }

    public void setDaysDate(Date daysDate) {
        this.daysDate = daysDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<DailyDietTotalsDTO> getDailyTotals() {
        return dailyTotals;
    }

    public void setDailyTotals(List<DailyDietTotalsDTO> dailyTotals) {
        this.dailyTotals = dailyTotals;
    }

    public boolean isExclude() {
        return exclude;
    }

    public void setExclude(boolean exclude) {
        this.exclude = exclude;
    }

    public boolean isSynced() {
        return synced;
    }

    public void setSynced(boolean synced) {
        this.synced = synced;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DailyDietWrapper{" +
                "ingredients=" + ingredients +
                ", dailyTotals=" + dailyTotals +
                ", notes=" + notes +
                ", daysDate=" + daysDate +
                ", exclude=" + exclude +
                ", synced=" + synced +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
