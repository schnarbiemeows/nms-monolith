package com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet;

import com.schnarbiesnmeowers.nmsmonolith.entities.DietaryTemplates;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class DietaryTemplatesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer dietaryTemplateId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the calendar date(date only&!@ no time)" 
	 */
	private Date calendarDate;

	/**
	 * "name of the template") 
	 */
	private String templateName;

	/**
	 * default constructor
	 */
	public DietaryTemplatesDTO() {
		super();
	}

	public DietaryTemplatesDTO(Integer dietaryTemplateId, Integer userId, Date calendarDate, String templateName) {
		super();
		this.dietaryTemplateId = dietaryTemplateId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.templateName = templateName;
	}

	public Integer getDietaryTemplateId() {
		return dietaryTemplateId;
	}

	public void setDietaryTemplateId(Integer dietaryTemplateId) {
		this.dietaryTemplateId=dietaryTemplateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Date getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(Date calendarDate) {
		this.calendarDate=calendarDate;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName=templateName;
	}

	@Override
	public String toString() {
		return "DietaryTemplatesDTO [dietaryTemplateId=" + dietaryTemplateId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", templateName=" + templateName + "]";
	}

	public static DietaryTemplatesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DietaryTemplatesDTO.class );
	}
	public DietaryTemplates toEntity() {
		return new DietaryTemplates(this.getDietaryTemplateId(),this.getUserId(),this.getCalendarDate(),this.getTemplateName());
	}
}
