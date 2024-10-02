package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutCardio;

public class WorkoutCardioDTO {

    private Integer workoutCardioId;

    private Integer workoutId;

    private Integer cardioTypeId;

    public WorkoutCardioDTO() {
    }

    public WorkoutCardioDTO(Integer workoutCardioId, Integer workoutId, Integer cardioTypeId) {
        this.workoutCardioId = workoutCardioId;
        this.workoutId = workoutId;
        this.cardioTypeId = cardioTypeId;
    }

    public Integer getWorkoutCardioId() {
        return workoutCardioId;
    }

    public void setWorkoutCardioId(Integer workoutCardioId) {
        this.workoutCardioId = workoutCardioId;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getCardioTypeId() {
        return cardioTypeId;
    }

    public void setCardioTypeId(Integer cardioTypeId) {
        this.cardioTypeId = cardioTypeId;
    }

    @Override
    public String toString() {
        return "WorkoutCardio{" +
                "workoutCardioId=" + workoutCardioId +
                ", workoutId=" + workoutId +
                ", cardioTypeId=" + cardioTypeId +
                '}';
    }

    public WorkoutCardio toEntity() {
        return new WorkoutCardio(this.workoutCardioId,this.workoutId,this.cardioTypeId);
    }
}
