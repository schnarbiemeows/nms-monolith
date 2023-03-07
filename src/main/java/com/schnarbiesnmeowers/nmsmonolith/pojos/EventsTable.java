package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.EventsTableDTO;
import javax.persistence.*;
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
@Entity
@Table(name = "events_table")
public class EventsTable implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "event_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer eventId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "short name of the event" 
	 */
	@Column(name = "event_name")
	private String eventName;

	/**
	 * "longer description of the event" 
	 */
	@Column(name = "event_desc")
	private String eventDesc;

	/**
	 * "fk to the periods.period_id field" 
	 */
	@Column(name = "period_id")
	private Integer periodId;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public EventsTable() {
		super();
	}

	public EventsTable(Integer eventId, Integer userId, String eventName, String eventDesc, Integer periodId, String actv) {
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
		return "EventsTable [eventId=" + eventId + ", userId=" + userId + ", eventName=" + eventName + ", eventDesc=" + eventDesc + ", periodId=" + periodId + ", actv=" + actv + "]";
	}

	public static EventsTable fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, EventsTable.class );
	}
	public EventsTableDTO toDTO() {
		return new EventsTableDTO(this.getEventId(),this.getUserId(),this.getEventName(),this.getEventDesc(),this.getPeriodId(),this.getActv());
	}
}
