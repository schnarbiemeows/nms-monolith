package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MessagesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "messages")
public class Messages implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "message_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer messageId;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	@Column(name = "event_id")
	private Integer eventId;

	/**
	 * "fk to the message_types.message_type_id field" 
	 */
	@Column(name = "message_type_id")
	private Integer messageTypeId;

	/**
	 * "message text") 
	 */
	@Column(name = "message_txt")
	private String messageTxt;

	/**
	 * default constructor
	 */
	public Messages() {
		super();
	}

	public Messages(Integer messageId, Integer eventId, Integer messageTypeId, String messageTxt) {
		super();
		this.messageId = messageId;
		this.eventId = eventId;
		this.messageTypeId = messageTypeId;
		this.messageTxt = messageTxt;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId=messageId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId=eventId;
	}

	public Integer getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId=messageTypeId;
	}

	public String getMessageTxt() {
		return messageTxt;
	}

	public void setMessageTxt(String messageTxt) {
		this.messageTxt=messageTxt;
	}

	@Override
	public String toString() {
		return "Messages [messageId=" + messageId + ", eventId=" + eventId + ", messageTypeId=" + messageTypeId + ", messageTxt=" + messageTxt + "]";
	}

	public static Messages fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Messages.class );
	}
	public MessagesDTO toDTO() {
		return new MessagesDTO(this.getMessageId(),this.getEventId(),this.getMessageTypeId(),this.getMessageTxt());
	}
}
