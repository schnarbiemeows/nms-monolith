package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.WeightWorkoutType;

import javax.persistence.Column;

public class WeightWorkoutTypeDTO {

    private Integer weightWorkoutTypeId;

    private Integer workoutId;

    private Integer muscleGroupId;

    public WeightWorkoutTypeDTO() {
    }

    public WeightWorkoutTypeDTO(Integer weightWorkoutTypeId, Integer workoutId, Integer muscleGroupId) {
        this.weightWorkoutTypeId = weightWorkoutTypeId;
        this.workoutId = workoutId;
        this.muscleGroupId = muscleGroupId;
    }

    public Integer getWeightWorkoutTypeId() {
        return weightWorkoutTypeId;
    }

    public void setWeightWorkoutTypeId(Integer weightWorkoutTypeId) {
        this.weightWorkoutTypeId = weightWorkoutTypeId;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getMuscleGroupId() {
        return muscleGroupId;
    }

    public void setMuscleGroupId(Integer muscleGroupId) {
        this.muscleGroupId = muscleGroupId;
    }

    @Override
    public String toString() {
        return "WeightWorkoutTypeDTO{" +
                "weightWorkoutTypeId=" + weightWorkoutTypeId +
                ", workoutId=" + workoutId +
                ", muscleGroupId=" + muscleGroupId +
                '}';
    }

    public WeightWorkoutType toEntity() {
        return new WeightWorkoutType(this.weightWorkoutTypeId,this.workoutId,this.muscleGroupId);
    }
}
