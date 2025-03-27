package com.schnarbiesnmeowers.nmsmonolith.entities.workout;

import com.google.gson.Gson;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutStepsDTO;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "workout_steps")
public class WorkoutSteps implements Serializable {

    private static final long serialVersionUID = 1L;

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     *
     */
    @Column(name = "workout_id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer workoutId;

    /**
     * "fk to the users.user_id field"
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * "the caledar date(date only&!@ no time)"
     */
    @Column(name = "calendar_date")
    private Date calendarDate;

    @Column(name = "steps")
    private Integer steps;

    public WorkoutSteps() {
    }

    public WorkoutSteps(Integer workoutId, Integer userId, Date calendarDate, Integer steps) {
        this.workoutId = workoutId;
        this.userId = userId;
        this.calendarDate = calendarDate;
        this.steps = steps;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Date calendarDate) {
        this.calendarDate = calendarDate;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "WorkoutSteps{" +
                "workoutId=" + workoutId +
                ", userId=" + userId +
                ", calendarDate=" + calendarDate +
                ", steps=" + steps +
                '}';
    }

    public static WorkoutSteps fromJson(String input) {
        Gson gson = new Gson();
        return gson.fromJson(input, WorkoutSteps.class );
    }

    public WorkoutStepsDTO toDTO() {
        return new WorkoutStepsDTO(this.getWorkoutId(),this.getUserId(),
                this.getCalendarDate().toLocalDate(),this.getSteps());
    }
}
