package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.MessageTypes;
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
public class MessageTypesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer messageTypeId;

	/**
	 * "d(dashboard)&!@ c(calendar)&!@t(text message)&!@ e(email message)" 
	 */
	private String messageTypeCde;

	/**
	 * "description of the message_type_cde") 
	 */
	private String messageTypeDesc;

	/**
	 * default constructor
	 */
	public MessageTypesDTO() {
		super();
	}

	public MessageTypesDTO(Integer messageTypeId, String messageTypeCde, String messageTypeDesc) {
		super();
		this.messageTypeId = messageTypeId;
		this.messageTypeCde = messageTypeCde;
		this.messageTypeDesc = messageTypeDesc;
	}

	public Integer getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId=messageTypeId;
	}

	public String getMessageTypeCde() {
		return messageTypeCde;
	}

	public void setMessageTypeCde(String messageTypeCde) {
		this.messageTypeCde=messageTypeCde;
	}

	public String getMessageTypeDesc() {
		return messageTypeDesc;
	}

	public void setMessageTypeDesc(String messageTypeDesc) {
		this.messageTypeDesc=messageTypeDesc;
	}

	@Override
	public String toString() {
		return "MessageTypesDTO [messageTypeId=" + messageTypeId + ", messageTypeCde=" + messageTypeCde + ", messageTypeDesc=" + messageTypeDesc + "]";
	}

	public static MessageTypesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, MessageTypesDTO.class );
	}
	public MessageTypes toEntity() {
		return new MessageTypes(this.getMessageTypeId(),this.getMessageTypeCde(),this.getMessageTypeDesc());
	}
}
