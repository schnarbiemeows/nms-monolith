package com.schnarbiesnmeowers.nmsmonolith.entities.workout;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.LiftSetDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lift_set")
public class LiftSet {

    private static final long serialVersionUID = 1L;

    @Column(name = "lift_set_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer liftSetId;

    @Column(name = "workout_lift_id")
    private Integer workoutLiftId;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "reps")
    private Integer reps;

    public LiftSet() {
    }

    public LiftSet(Integer liftSetId, Integer workoutLiftId, BigDecimal weight, Integer reps) {
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
        return "LiftSet{" +
                "liftSetId=" + liftSetId +
                ", workoutLiftId=" + workoutLiftId +
                ", weight=" + weight +
                ", reps=" + reps +
                '}';
    }

    public LiftSetDTO toDTO() {
        return new LiftSetDTO(this.liftSetId,this.workoutLiftId,this.weight,this.reps);
    }

}
