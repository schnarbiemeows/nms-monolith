package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Notifications;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.sql.Time;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class NotificationsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer notificationId;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	private Integer eventId;

	/**
	 * "time of day to send notification" 
	 */
	private java.sql.Time notifTime;

	/**
	 * "(null if there is none&!@ or set to actv = false when done&!@ or move to history table)" 
	 */
	private Date nextNotifDate;

	/**
	 * "was this message delivered?") 
	 */
	private String delivered;

	/**
	 * default constructor
	 */
	public NotificationsDTO() {
		super();
	}

	public NotificationsDTO(Integer notificationId, Integer eventId, Time notifTime, Date nextNotifDate, String delivered) {
		super();
		this.notificationId = notificationId;
		this.eventId = eventId;
		this.notifTime = notifTime;
		this.nextNotifDate = nextNotifDate;
		this.delivered = delivered;
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId=notificationId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId=eventId;
	}

	public Time getNotifTime() {
		return notifTime;
	}

	public void setNotifTime(Time notifTime) {
		this.notifTime=notifTime;
	}

	public Date getNextNotifDate() {
		return nextNotifDate;
	}

	public void setNextNotifDate(Date nextNotifDate) {
		this.nextNotifDate=nextNotifDate;
	}

	public String getDelivered() {
		return delivered;
	}

	public void setDelivered(String delivered) {
		this.delivered=delivered;
	}

	@Override
	public String toString() {
		return "NotificationsDTO [notificationId=" + notificationId + ", eventId=" + eventId + ", notifTime=" + notifTime + ", nextNotifDate=" + nextNotifDate + ", delivered=" + delivered + "]";
	}

	public static NotificationsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, NotificationsDTO.class );
	}
	public Notifications toEntity() {
		return new Notifications(this.getNotificationId(),this.getEventId(),this.getNotifTime(),this.getNextNotifDate(),this.getDelivered());
	}
}
