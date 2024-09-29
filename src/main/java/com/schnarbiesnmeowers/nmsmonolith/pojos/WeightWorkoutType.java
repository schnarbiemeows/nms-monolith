package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.WeightWorkoutTypeDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "weight_workout_type")
public class WeightWorkoutType implements Serializable {

    @Column(name = "weight_workout_type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer weightWorkoutTypeId;

    @Column(name = "workout_id")
    private Integer workoutId;

    @Column(name = "muscle_group_id")
    private Integer muscleGroupId;

    public WeightWorkoutType() {
    }

    public WeightWorkoutType(Integer weightWorkoutTypeId, Integer workoutId, Integer muscleGroupId) {
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
        return "WeightWorkoutType{" +
                "weightWorkoutTypeId=" + weightWorkoutTypeId +
                ", workoutId=" + workoutId +
                ", muscleGroupId=" + muscleGroupId +
                '}';
    }

    public WeightWorkoutTypeDTO toDTO() {
        return new WeightWorkoutTypeDTO(this.weightWorkoutTypeId,this.workoutId,this.muscleGroupId);
    }
}
