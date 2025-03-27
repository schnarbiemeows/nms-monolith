package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DietaryTemplatesDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "dietary_templates")
public class DietaryTemplates implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "dietary_template_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer dietaryTemplateId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the calendar date(date only&!@ no time)" 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * "name of the template") 
	 */
	@Column(name = "template_name")
	private String templateName;

	/**
	 * default constructor
	 */
	public DietaryTemplates() {
		super();
	}

	public DietaryTemplates(Integer dietaryTemplateId, Integer userId, Date calendarDate, String templateName) {
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
		return "DietaryTemplates [dietaryTemplateId=" + dietaryTemplateId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", templateName=" + templateName + "]";
	}

	public static DietaryTemplates fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DietaryTemplates.class );
	}
	public DietaryTemplatesDTO toDTO() {
		return new DietaryTemplatesDTO(this.getDietaryTemplateId(),this.getUserId(),this.getCalendarDate(),this.getTemplateName());
	}
}
