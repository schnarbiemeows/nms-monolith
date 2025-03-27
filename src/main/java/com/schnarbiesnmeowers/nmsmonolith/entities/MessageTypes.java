package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MessageTypesDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "message_types")
public class MessageTypes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "message_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer messageTypeId;

	/**
	 * "d(dashboard)&!@ c(calendar)&!@t(text message)&!@ e(email message)" 
	 */
	@Column(name = "message_type_cde")
	private String messageTypeCde;

	/**
	 * "description of the message_type_cde") 
	 */
	@Column(name = "message_type_desc")
	private String messageTypeDesc;

	/**
	 * default constructor
	 */
	public MessageTypes() {
		super();
	}

	public MessageTypes(Integer messageTypeId, String messageTypeCde, String messageTypeDesc) {
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
		return "MessageTypes [messageTypeId=" + messageTypeId + ", messageTypeCde=" + messageTypeCde + ", messageTypeDesc=" + messageTypeDesc + "]";
	}

	public static MessageTypes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, MessageTypes.class );
	}
	public MessageTypesDTO toDTO() {
		return new MessageTypesDTO(this.getMessageTypeId(),this.getMessageTypeCde(),this.getMessageTypeDesc());
	}
}
