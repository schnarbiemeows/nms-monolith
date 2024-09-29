package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.BodyMeasurements;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BodyMeasurementsDTO {

    private Integer bodyMeasurementId;
    private Integer userId;
    private LocalDate calendarDate;
    private BigDecimal leftCalf;

    private BigDecimal rightCalf;

    private BigDecimal leftThigh;

    private BigDecimal rightThigh;

    private BigDecimal waist;

    private BigDecimal chest;

    private BigDecimal leftBicep;

    private BigDecimal rightBicep;

    private BigDecimal leftForearm;

    private BigDecimal rightForearm;

    private BigDecimal shoulders;

    private String actv;

    public BodyMeasurementsDTO() {
    }

    public BodyMeasurementsDTO(Integer bodyMeasurementId, Integer userId, LocalDate calendarDate,
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

    public BodyMeasurements toEntity() {
        return new BodyMeasurements(this.bodyMeasurementId,this.userId,this.calendarDate,this.leftCalf,
                this.rightCalf,this.leftThigh,this.rightThigh,this.waist,this.chest,this.leftBicep,
                this.rightBicep,this.leftForearm,this.rightForearm,this.shoulders,this.actv);
    }
}
