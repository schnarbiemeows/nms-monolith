package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.TemplatesDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "templates")
public class Templates implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "template_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer templateId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "template_name")
    private String templateName;

    public Templates() {
    }

    public Templates(Integer templateId, Integer userId, String templateName) {
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

    public TemplatesDTO toDTO() {
        return new TemplatesDTO(this.templateId,this.userId,this.templateName);
    }
}
