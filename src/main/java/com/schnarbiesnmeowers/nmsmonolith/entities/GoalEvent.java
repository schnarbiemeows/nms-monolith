package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalEventDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "goal_event")
public class GoalEvent implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "goal_event_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer goalEventId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "fk to the goals.goal_id field" 
	 */
	@Column(name = "goal_id")
	private Integer goalId;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	@Column(name = "event_id")
	private Integer eventId;

	/**
	 * default constructor
	 */
	public GoalEvent() {
		super();
	}

	public GoalEvent(Integer goalEventId, Integer userId, Integer goalId, Integer eventId) {
		super();
		this.goalEventId = goalEventId;
		this.userId = userId;
		this.goalId = goalId;
		this.eventId = eventId;
	}

	public Integer getGoalEventId() {
		return goalEventId;
	}

	public void setGoalEventId(Integer goalEventId) {
		this.goalEventId=goalEventId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getGoalId() {
		return goalId;
	}

	public void setGoalId(Integer goalId) {
		this.goalId=goalId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId=eventId;
	}

	@Override
	public String toString() {
		return "GoalEvent [goalEventId=" + goalEventId + ", userId=" + userId + ", goalId=" + goalId + ", eventId=" + eventId + "]";
	}

	public static GoalEvent fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalEvent.class );
	}
	public GoalEventDTO toDTO() {
		return new GoalEventDTO(this.getGoalEventId(),this.getUserId(),this.getGoalId(),this.getEventId());
	}
}
