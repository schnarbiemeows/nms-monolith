package com.schnarbiesnmeowers.nmsmonolith.entities.workout;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutsDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.sql.Date;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "workouts")
public class Workouts implements Serializable {
	// default serial version id, required for serializable classes
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

	/**
	 * "fk to the exercise_type.exercise_type_id field" 
	 */
	@Column(name = "exercise_type_id")
	private Integer exerciseTypeId;

	/**
	 * "length of workout&!@ in minutes" 
	 */
	@Column(name = "duration")
	private Integer duration;

	/**
	 * "user's statisfaction with their workout 0.0 - 10.0 rating" 
	 */
	@Column(name = "rating")
	private BigDecimal rating;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;


	@Column(name="notes")
	private String notes;
	/**
	 * default constructor
	 */
	public Workouts() {
		super();
	}

	public Workouts(Integer workoutId, Integer userId, Date calendarDate, Integer exerciseTypeId,
					Integer duration, BigDecimal rating, String actv,String notes) {
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

	public Date getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(Date calendarDate) {
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
		return "Workouts{" +
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

	public static Workouts fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Workouts.class );
	}
	public WorkoutsDTO toDTO() {
		return new WorkoutsDTO(this.getWorkoutId(),this.getUserId(),this.getCalendarDate().toLocalDate(),
		this.getExerciseTypeId(),this.getDuration(),this.getRating(),this.getActv(),this.notes);
	}
}
