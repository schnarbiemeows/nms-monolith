package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutCardioVw;

import java.time.LocalDate;

public class WorkoutCardioVwDTO {

    private Integer workoutId;

    /**
     * "fk to the users.user_id field"
     */
    private Integer userId;

    /**
     * "the caledar date(date only&!@ no time)"
     */
    private LocalDate calendarDate;

    private String description;

    public WorkoutCardioVwDTO() {
    }

    public WorkoutCardioVwDTO(Integer workoutId, Integer userId, LocalDate calendarDate, String description) {
        this.workoutId = workoutId;
        this.userId = userId;
        this.calendarDate = calendarDate;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WorkoutCardioVwDTO{" +
                "workoutId=" + workoutId +
                ", userId=" + userId +
                ", calendarDate=" + calendarDate +
                ", description='" + description + '\'' +
                '}';
    }

    public WorkoutCardioVw toEntity() {
        return new WorkoutCardioVw(this.workoutId,this.userId,java.sql.Date.valueOf(this.calendarDate),this.description);
    }
}
