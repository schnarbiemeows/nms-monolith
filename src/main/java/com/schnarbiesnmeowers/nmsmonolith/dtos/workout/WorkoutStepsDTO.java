package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutSteps;

import java.time.LocalDate;

public class WorkoutStepsDTO {

    private Integer workoutId;

    /**
     * "fk to the users.user_id field"
     */
    private Integer userId;

    /**
     * "the caledar date(date only&!@ no time)"
     */
    private LocalDate calendarDate;

    private Integer steps;

    public WorkoutStepsDTO() {
    }

    public WorkoutStepsDTO(Integer workoutId, Integer userId, LocalDate calendarDate, Integer steps) {
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

    public LocalDate getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(LocalDate calendarDate) {
        this.calendarDate = calendarDate;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public WorkoutSteps toEntity() {
        return new WorkoutSteps(this.getWorkoutId(),this.getUserId(),java.sql.Date.valueOf(this.getCalendarDate()),
                this.getSteps());
    }
}
