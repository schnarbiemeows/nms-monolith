package com.schnarbiesnmeowers.nmsmonolith.entities.workout;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutCardioVwDTO;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "workout_cardio_vw")
public class WorkoutCardioVw implements Serializable {

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

    @Column(name = "description")
    private String description;

    public WorkoutCardioVw() {
    }

    public WorkoutCardioVw(Integer workoutId, Integer userId, Date calendarDate, String description) {
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

    public Date getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Date calendarDate) {
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
        return "WorkoutCardioVw{" +
                "workoutId=" + workoutId +
                ", userId=" + userId +
                ", calendarDate=" + calendarDate +
                ", description='" + description + '\'' +
                '}';
    }

    public WorkoutCardioVwDTO toDTO() {
        return new WorkoutCardioVwDTO(this.workoutId,this.userId,this.calendarDate.toLocalDate(),this.description);
    }
}
