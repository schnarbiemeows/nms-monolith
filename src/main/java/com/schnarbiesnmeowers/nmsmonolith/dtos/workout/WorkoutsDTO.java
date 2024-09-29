package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.Workouts;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class WorkoutsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer workoutId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	private LocalDate calendarDate;

	/**
	 * "fk to the exercise_type.exercise_type_id field" 
	 */
	private Integer exerciseTypeId;

	/**
	 * "length of workout&!@ in minutes" 
	 */
	private Integer duration;

	/**
	 * "user's statisfaction with their workout 0.0 - 10.0 rating" 
	 */
	private BigDecimal rating;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	private String notes;
	/**
	 * default constructor
	 */
	public WorkoutsDTO() {
		super();
	}

	public WorkoutsDTO(Integer workoutId, Integer userId, LocalDate calendarDate, Integer exerciseTypeId, Integer duration,
		BigDecimal rating, String actv, String notes) {
		super();
		this.workoutId = workoutId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.exerciseTypeId = exerciseTypeId;
		this.duration = duration;
		this.rating = rating;
		this.actv = actv;
		this.notes = notes;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId=workoutId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public LocalDate getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(LocalDate calendarDate) {
		this.calendarDate=calendarDate;
	}

	public Integer getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(Integer exerciseTypeId) {
		this.exerciseTypeId=exerciseTypeId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration=duration;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating=rating;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "WorkoutsDTO{" +
				"workoutId=" + workoutId +
				", userId=" + userId +
				", calendarDate=" + calendarDate +
				", exerciseTypeId=" + exerciseTypeId +
				", duration=" + duration +
				", rating=" + rating +
				", actv='" + actv + '\'' +
				", notes='" + notes + '\'' +
				'}';
	}

	public static WorkoutsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, WorkoutsDTO.class );
	}
	public Workouts toEntity() {
		return new Workouts(this.getWorkoutId(),this.getUserId(),java.sql.Date.valueOf(this.getCalendarDate()),
				this.getExerciseTypeId(),this.getDuration(),this.getRating(),this.getActv(),this.notes);
	}
}
