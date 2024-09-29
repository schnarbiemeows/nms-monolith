package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.CardioType;

public class CardioTypeDTO {

    private Integer cardioTypeId;

    private String description;

    private String actv;

    public CardioTypeDTO() {
    }

    public CardioTypeDTO(Integer cardioTypeId, String description, String actv) {
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

    public CardioType toEntity() {
        return new CardioType(this.cardioTypeId, this.description, this.actv);
    }
}
