package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Templates;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class TemplatesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer templateId;

    private Integer userId;

    private String templateName;

    public TemplatesDTO() {
    }

    public TemplatesDTO(Integer templateId, Integer userId, String templateName) {
        this.templateId = templateId;
        this.userId = userId;
        this.templateName = templateName;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return "Templates{" +
                "templateId=" + templateId +
                ", userId=" + userId +
                ", templateName='" + templateName + '\'' +
                '}';
    }

    public Templates toEntity() {
        return new Templates(this.templateId,this.userId,this.templateName);
    }
}
