package com.schnarbiesnmeowers.nmsmonolith.pojos.workout;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutCardioDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "workout_cardio")
public class WorkoutCardio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "workout_cardio_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer workoutCardioId;


    @Column(name = "workout_id")
    private Integer workoutId;

    @Column(name = "cardio_type_id")
    private Integer cardioTypeId;

    public WorkoutCardio() {
    }

    public WorkoutCardio(Integer workoutCardioId, Integer workoutId, Integer cardioTypeId) {
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

    public WorkoutCardioDTO toDTO() {
        return new WorkoutCardioDTO(this.workoutCardioId,this.workoutId,this.cardioTypeId);
    }
}
