package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalEvent;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GoalEventDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer goalEventId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "fk to the goals.goal_id field" 
	 */
	private Integer goalId;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	private Integer eventId;

	/**
	 * default constructor
	 */
	public GoalEventDTO() {
		super();
	}

	public GoalEventDTO(Integer goalEventId, Integer userId, Integer goalId, Integer eventId) {
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
		return "GoalEventDTO [goalEventId=" + goalEventId + ", userId=" + userId + ", goalId=" + goalId + ", eventId=" + eventId + "]";
	}

	public static GoalEventDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalEventDTO.class );
	}
	public GoalEvent toEntity() {
		return new GoalEvent(this.getGoalEventId(),this.getUserId(),this.getGoalId(),this.getEventId());
	}
}
