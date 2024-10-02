package com.schnarbiesnmeowers.nmsmonolith.entities.workout;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutLiftDTO;

import javax.persistence.*;

@Entity
@Table(name = "workout_lift")
public class WorkoutLift {

    private static final long serialVersionUID = 1L;

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     *
     */
    @Column(name = "workout_lift_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer workoutLiftId;

    /**
     * "fk to the workouts.workout_id field"
     */
    @Column(name = "workout_id")
    private Integer workoutId;

    /**
     * "fk to the lifts.lift_id field"
     */
    @Column(name = "lift_id")
    private Integer liftId;

    public WorkoutLift() {
    }

    public WorkoutLift(Integer workoutLiftId, Integer workoutId, Integer liftId) {
        this.workoutLiftId = workoutLiftId;
        this.workoutId = workoutId;
        this.liftId = liftId;
    }

    public Integer getWorkoutLiftId() {
        return workoutLiftId;
    }

    public void setWorkoutLiftId(Integer workoutLiftId) {
        this.workoutLiftId = workoutLiftId;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getLiftId() {
        return liftId;
    }

    public void setLiftId(Integer liftId) {
        this.liftId = liftId;
    }

    @Override
    public String toString() {
        return "WorkoutLift{" +
                "workoutLiftId=" + workoutLiftId +
                ", workoutId=" + workoutId +
                ", liftId=" + liftId +
                '}';
    }

    public WorkoutLiftDTO toDTO() {
        return new WorkoutLiftDTO(this.workoutLiftId,this.workoutId,this.liftId,
                null);
    }
}
