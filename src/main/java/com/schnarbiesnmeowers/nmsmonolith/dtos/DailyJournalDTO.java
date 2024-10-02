package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyJournal;

import java.util.Date;

public class DailyJournalDTO {

    private Integer dailyJournalId;

    private Integer userId;

    private Date calendarDate;

    private String note;

    private String actv;

    public DailyJournalDTO() {
    }

    public DailyJournalDTO(Integer dailyJournalId, Integer userId, Date calendarDate, String note, String actv) {
        this.dailyJournalId = dailyJournalId;
        this.userId = userId;
        this.calendarDate = calendarDate;
        this.note = note;
        this.actv = actv;
    }

    public Integer getDailyJournalId() {
        return dailyJournalId;
    }

    public void setDailyJournalId(Integer dailyJournalId) {
        this.dailyJournalId = dailyJournalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Date calendarDate) {
        this.calendarDate = calendarDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getActv() {
        return actv;
    }

    public void setActv(String actv) {
        this.actv = actv;
    }

    @Override
    public String toString() {
        return "DailyJournalDTO{" +
                "dailyJournalId=" + dailyJournalId +
                ", userId=" + userId +
                ", calendarDate=" + calendarDate +
                ", note='" + note + '\'' +
                ", actv='" + actv + '\'' +
                '}';
    }

    public DailyJournal toEntity() {
        return new DailyJournal(this.dailyJournalId,this.userId,this.calendarDate,this.note,this.actv);
    }
}
