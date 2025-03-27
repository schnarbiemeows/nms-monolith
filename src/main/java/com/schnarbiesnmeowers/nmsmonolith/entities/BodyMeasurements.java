package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BodyMeasurementsDTO;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "body_measurements")
public class BodyMeasurements implements Serializable {

    @Column(name = "body_meas_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bodyMeasurementId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "calendar_date")
    private LocalDate calendarDate;
    @Column(name = "calf_l")
    private BigDecimal leftCalf;

    @Column(name = "calf_r")
    private BigDecimal rightCalf;

    @Column(name = "thigh_l")
    private BigDecimal leftThigh;

    @Column(name = "thigh_r")
    private BigDecimal rightThigh;

    @Column(name = "waist")
    private BigDecimal waist;

    @Column(name = "chest")
    private BigDecimal chest;

    @Column(name = "bicep_l")
    private BigDecimal leftBicep;

    @Column(name = "bicep_r")
    private BigDecimal rightBicep;

    @Column(name = "forearm_l")
    private BigDecimal leftForearm;

    @Column(name = "forearm_r")
    private BigDecimal rightForearm;

    @Column(name = "shoulders")
    private BigDecimal shoulders;

    @Column(name = "actv")
    private String actv;

    public BodyMeasurements() {
    }

    public BodyMeasurements(Integer bodyMeasurementId, Integer userId, LocalDate calendarDate,
                            BigDecimal leftCalf, BigDecimal rightCalf, BigDecimal leftThigh,
                            BigDecimal rightThigh, BigDecimal waist, BigDecimal chest,
                            BigDecimal leftBicep, BigDecimal rightBicep, BigDecimal leftForearm,
                            BigDecimal rightForearm, BigDecimal shoulders, String actv) {
        this.bodyMeasurementId = bodyMeasurementId;
        this.userId = userId;
        this.calendarDate = calendarDate;
        this.leftCalf = leftCalf;
        this.rightCalf = rightCalf;
        this.leftThigh = leftThigh;
        this.rightThigh = rightThigh;
        this.waist = waist;
        this.chest = chest;
        this.leftBicep = leftBicep;
        this.rightBicep = rightBicep;
        this.leftForearm = leftForearm;
        this.rightForearm = rightForearm;
        this.shoulders = shoulders;
        this.actv = actv;
    }

    public Integer getBodyMeasurementId() {
        return bodyMeasurementId;
    }

    public void setBodyMeasurementId(Integer bodyMeasurementId) {
        this.bodyMeasurementId = bodyMeasurementId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(LocalDate calendarDate) {
        this.calendarDate = calendarDate;
    }

    public BigDecimal getLeftCalf() {
        return leftCalf;
    }

    public void setLeftCalf(BigDecimal leftCalf) {
        this.leftCalf = leftCalf;
    }

    public BigDecimal getRightCalf() {
        return rightCalf;
    }

    public void setRightCalf(BigDecimal rightCalf) {
        this.rightCalf = rightCalf;
    }

    public BigDecimal getLeftThigh() {
        return leftThigh;
    }

    public void setLeftThigh(BigDecimal leftThigh) {
        this.leftThigh = leftThigh;
    }

    public BigDecimal getRightThigh() {
        return rightThigh;
    }

    public void setRightThigh(BigDecimal rightThigh) {
        this.rightThigh = rightThigh;
    }

    public BigDecimal getWaist() {
        return waist;
    }

    public void setWaist(BigDecimal waist) {
        this.waist = waist;
    }

    public BigDecimal getChest() {
        return chest;
    }

    public void setChest(BigDecimal chest) {
        this.chest = chest;
    }

    public BigDecimal getLeftBicep() {
        return leftBicep;
    }

    public void setLeftBicep(BigDecimal leftBicep) {
        this.leftBicep = leftBicep;
    }

    public BigDecimal getRightBicep() {
        return rightBicep;
    }

    public void setRightBicep(BigDecimal rightBicep) {
        this.rightBicep = rightBicep;
    }

    public BigDecimal getLeftForearm() {
        return leftForearm;
    }

    public void setLeftForearm(BigDecimal leftForearm) {
        this.leftForearm = leftForearm;
    }

    public BigDecimal getRightForearm() {
        return rightForearm;
    }

    public void setRightForearm(BigDecimal rightForearm) {
        this.rightForearm = rightForearm;
    }

    public BigDecimal getShoulders() {
        return shoulders;
    }

    public void setShoulders(BigDecimal shoulders) {
        this.shoulders = shoulders;
    }

    public String getActv() {
        return actv;
    }

    public void setActv(String actv) {
        this.actv = actv;
    }

    @Override
    public String toString() {
        return "BodyMeasurements{" +
                "bodyMeasurementId=" + bodyMeasurementId +
                ", userId=" + userId +
                ", calendarDate=" + calendarDate +
                ", leftCalf=" + leftCalf +
                ", rightCalf=" + rightCalf +
                ", leftThigh=" + leftThigh +
                ", rightThigh=" + rightThigh +
                ", waist=" + waist +
                ", chest=" + chest +
                ", leftBicep=" + leftBicep +
                ", rightBicep=" + rightBicep +
                ", leftForearm=" + leftForearm +
                ", rightForearm=" + rightForearm +
                ", shoulders=" + shoulders +
                ", actv='" + actv + '\'' +
                '}';
    }

    public BodyMeasurementsDTO toDTO() {
        return new BodyMeasurementsDTO(this.bodyMeasurementId,this.userId,this.calendarDate,this.leftCalf,
                this.rightCalf,this.leftThigh,this.rightThigh,this.waist,this.chest,this.leftBicep,
                this.rightBicep,this.leftForearm,this.rightForearm,this.shoulders,this.actv);
    }
}
