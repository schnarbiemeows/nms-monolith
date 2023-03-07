package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Messages;
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
public class MessagesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer messageId;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	private Integer eventId;

	/**
	 * "fk to the message_types.message_type_id field" 
	 */
	private Integer messageTypeId;

	/**
	 * "message text") 
	 */
	private String messageTxt;

	/**
	 * default constructor
	 */
	public MessagesDTO() {
		super();
	}

	public MessagesDTO(Integer messageId, Integer eventId, Integer messageTypeId, String messageTxt) {
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
		return "MessagesDTO [messageId=" + messageId + ", eventId=" + eventId + ", messageTypeId=" + messageTypeId + ", messageTxt=" + messageTxt + "]";
	}

	public static MessagesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, MessagesDTO.class );
	}
	public Messages toEntity() {
		return new Messages(this.getMessageId(),this.getEventId(),this.getMessageTypeId(),this.getMessageTxt());
	}
}
