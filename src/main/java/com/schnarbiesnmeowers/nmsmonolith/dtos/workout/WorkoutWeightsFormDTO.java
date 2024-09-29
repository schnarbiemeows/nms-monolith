package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutWeightsFormDTO {

    private WorkoutsDTO workout;

    private Integer weightWorkoutType ;
    List<WorkoutLiftDTO> workoutLifts = new ArrayList();

    public WorkoutWeightsFormDTO() {
    }

    public WorkoutWeightsFormDTO(WorkoutsDTO workout, Integer weightWorkoutType,
                                 List<WorkoutLiftDTO> workoutLifts) {
        this.workout = workout;
        this.weightWorkoutType = weightWorkoutType;
        this.workoutLifts = workoutLifts;
    }

    public WorkoutsDTO getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutsDTO workout) {
        this.workout = workout;
    }

    public List<WorkoutLiftDTO> getWorkoutLifts() {
        return workoutLifts;
    }

    public void setWorkoutLifts(List<WorkoutLiftDTO> workoutLifts) {
        this.workoutLifts = workoutLifts;
    }

    public Integer getWeightWorkoutType() {
        return weightWorkoutType;
    }

    public void setWeightWorkoutType(Integer weightWorkoutType) {
        this.weightWorkoutType = weightWorkoutType;
    }

    @Override
    public String toString() {
        return "WorkoutWeightsFormDTO{" +
                "workout=" + workout +
                ", weightWorkoutType=" + weightWorkoutType +
                ", workoutLifts=" + workoutLifts +
                '}';
    }
}
