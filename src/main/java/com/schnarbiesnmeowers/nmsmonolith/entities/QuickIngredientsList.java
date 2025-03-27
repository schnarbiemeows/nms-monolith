package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.QuickIngredientsListDTO;
import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Immutable
@Table(name = "quick_ingredient_list")
public class QuickIngredientsList implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id()
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "meal_type_id")
    private Integer mealTypeId;

    @Column(name = "meal_type")
    private String mealTypeDesc;
    @Column(name = "ingredient_id")
    private Integer ingredientId;
    @Column(name = "ingredient_desc")
    private String ingredientDesc;
    @Column(name = "local")
    private boolean local;
    @Column(name = "serv_type_id")
    private Integer servTypeId;
    @Column(name = "serv_type_cde")
    private String servTypeCde;
    @Column(name = "quantity")
    private BigDecimal quantity;

    public QuickIngredientsList() {
    }

    public QuickIngredientsList(Integer id, Integer userId, Integer mealTypeId, String mealTypeDesc, Integer ingredientId,
                                String ingredientDesc, boolean local, Integer servTypeId, String servTypeCde, BigDecimal quantity) {
        this.id = id;
        this.userId = userId;
        this.mealTypeId = mealTypeId;
        this.mealTypeDesc = mealTypeDesc;
        this.ingredientId = ingredientId;
        this.ingredientDesc = ingredientDesc;
        this.local = local;
        this.servTypeId = servTypeId;
        this.servTypeCde = servTypeCde;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getMealTypeId() {
        return mealTypeId;
    }

    public String getMealTypeDesc() {
        return mealTypeDesc;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public String getIngredientDesc() {
        return ingredientDesc;
    }

    public boolean isLocal() {
        return local;
    }

    public Integer getServTypeId() {
        return servTypeId;
    }

    public String getServTypeCde() {
        return servTypeCde;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "QuickIngredientsList{" +
                "id=" + id +
                ", userId=" + userId +
                ", mealTypeId=" + mealTypeId +
                ", mealTypeDesc='" + mealTypeDesc + '\'' +
                ", ingredientId=" + ingredientId +
                ", ingredientDesc='" + ingredientDesc + '\'' +
                ", local=" + local +
                ", servTypeId=" + servTypeId +
                ", servTypeCde='" + servTypeCde + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public QuickIngredientsListDTO toDTO() {
        return new QuickIngredientsListDTO(this.id, this.userId, this.mealTypeId, this.mealTypeDesc,
                this.ingredientId,this.ingredientDesc,this.local,this.servTypeId,
                this.servTypeCde,this.quantity);
    }
}
