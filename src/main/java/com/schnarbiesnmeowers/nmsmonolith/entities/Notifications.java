package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.NotificationsDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

import java.sql.Time;
import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "notifications")
public class Notifications implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "notification_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer notificationId;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	@Column(name = "event_id")
	private Integer eventId;

	/**
	 * "time of day to send notification" 
	 */
	@Column(name = "notif_time")
	private java.sql.Time notifTime;

	/**
	 * "(null if there is none&!@ or set to actv = false when done&!@ or move to history table)" 
	 */
	@Column(name = "next_notif_date")
	private Date nextNotifDate;

	/**
	 * "was this message delivered?") 
	 */
	@Column(name = "delivered")
	private String delivered;

	/**
	 * default constructor
	 */
	public Notifications() {
		super();
	}

	public Notifications(Integer notificationId, Integer eventId, Time notifTime, Date nextNotifDate, String delivered) {
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
		return "Notifications [notificationId=" + notificationId + ", eventId=" + eventId + ", notifTime=" + notifTime + ", nextNotifDate=" + nextNotifDate + ", delivered=" + delivered + "]";
	}

	public static Notifications fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Notifications.class );
	}
	public NotificationsDTO toDTO() {
		return new NotificationsDTO(this.getNotificationId(),this.getEventId(),this.getNotifTime(),this.getNextNotifDate(),this.getDelivered());
	}
}
