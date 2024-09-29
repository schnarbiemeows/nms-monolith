package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.LiftSet;

import java.math.BigDecimal;

public class LiftSetDTO {

    private Integer liftSetId;

    private Integer workoutLiftId;

    private BigDecimal weight;

    private Integer reps;

    public LiftSetDTO() {
    }

    public LiftSetDTO(Integer liftSetId, Integer workoutLiftId, BigDecimal weight, Integer reps) {
        this.liftSetId = liftSetId;
        this.workoutLiftId = workoutLiftId;
        this.weight = weight;
        this.reps = reps;
    }

    public Integer getLiftSetId() {
        return liftSetId;
    }

    public void setLiftSetId(Integer liftSetId) {
        this.liftSetId = liftSetId;
    }

    public Integer getWorkoutLiftId() {
        return workoutLiftId;
    }

    public void setWorkoutLiftId(Integer workoutLiftId) {
        this.workoutLiftId = workoutLiftId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "LiftSetDTO{" +
                "liftSetId=" + liftSetId +
                ", workoutLiftId=" + workoutLiftId +
                ", weight=" + weight +
                ", reps=" + reps +
                '}';
    }

    public LiftSet toEntity() {
        return new LiftSet(this.liftSetId,this.workoutLiftId,this.weight,this.reps);
    }
}
