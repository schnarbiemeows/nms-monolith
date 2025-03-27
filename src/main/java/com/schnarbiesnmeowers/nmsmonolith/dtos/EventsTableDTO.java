package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.EventsTable;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class EventsTableDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer eventId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "short name of the event" 
	 */
	private String eventName;

	/**
	 * "longer description of the event" 
	 */
	private String eventDesc;

	/**
	 * "fk to the periods.period_id field" 
	 */
	private Integer periodId;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public EventsTableDTO() {
		super();
	}

	public EventsTableDTO(Integer eventId, Integer userId, String eventName, String eventDesc, Integer periodId, String actv) {
		super();
		this.eventId = eventId;
		this.userId = userId;
		this.eventName = eventName;
		this.eventDesc = eventDesc;
		this.periodId = periodId;
		this.actv = actv;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId=eventId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName=eventName;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc=eventDesc;
	}

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId=periodId;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "EventsTableDTO [eventId=" + eventId + ", userId=" + userId + ", eventName=" + eventName + ", eventDesc=" + eventDesc + ", periodId=" + periodId + ", actv=" + actv + "]";
	}

	public static EventsTableDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, EventsTableDTO.class );
	}
	public EventsTable toEntity() {
		return new EventsTable(this.getEventId(),this.getUserId(),this.getEventName(),this.getEventDesc(),this.getPeriodId(),this.getActv());
	}
}
