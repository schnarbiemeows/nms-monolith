package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.CardioTypeDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Type;

@Entity
@Table(name = "cardio_type")
public class CardioType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cardio_type_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cardioTypeId;

    private String description;

    private String actv;

    public CardioType() {
    }

    public CardioType(Integer cardioTypeId, String description, String actv) {
        this.cardioTypeId = cardioTypeId;
        this.description = description;
        this.actv = actv;
    }

    public Integer getCardioTypeId() {
        return cardioTypeId;
    }

    public void setCardioTypeId(Integer cardioTypeId) {
        this.cardioTypeId = cardioTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActv() {
        return actv;
    }

    public void setActv(String actv) {
        this.actv = actv;
    }

    @Override
    public String toString() {
        return "CardioType{" +
                "cardioTypeId=" + cardioTypeId +
                ", description='" + description + '\'' +
                ", actv='" + actv + '\'' +
                '}';
    }

    public CardioTypeDTO toDTO() {
        return new CardioTypeDTO(this.cardioTypeId, this.description, this.actv);
    }
}
