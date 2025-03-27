package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyJournalDTO;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "daily_journal")
public class DailyJournal implements Serializable {

    @Column(name = "daily_journal_id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer dailyJournalId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "calendar_date")
    private Date calendarDate;

    @Column(name = "note")
    private String note;

    @Column(name = "actv")
    private String actv;

    public DailyJournal() {
    }

    public DailyJournal(Integer dailyJournalId, Integer userId, Date calendarDate, String note, String actv) {
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
        return "DailyJournal{" +
                "dailyJournalId=" + dailyJournalId +
                ", userId=" + userId +
                ", calendarDate=" + calendarDate +
                ", note='" + note + '\'' +
                ", actv='" + actv + '\'' +
                '}';
    }

    public DailyJournalDTO toDTO() {
        return new DailyJournalDTO(this.dailyJournalId,this.userId,this.calendarDate,this.note,this.actv);
    }
}
