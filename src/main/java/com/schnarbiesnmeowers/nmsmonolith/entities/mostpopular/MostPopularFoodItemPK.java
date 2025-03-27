package com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class MostPopularFoodItemPK {

    @Column(name = "USER_ID")
    @Id
    private Integer userId;

    @Column(name = "BLDST_ID")
    @Id
    private Integer bldstId;

    @Column(name = "INGR_ID")
    @Id
    private Integer ingrId;

    @Column(name = "IS_RECIPE")
    @Id
    private Boolean isRecipe;

    @Column(name = "IS_LOCAL")
    @Id
    private Boolean isLocal;

    @Column(name = "NUM_SRV")
    @Id
    private BigDecimal numSrv;

    @Column(name = "SERV_TYPE_ID")
    @Id
    private Integer servTypeId;

    public MostPopularFoodItemPK() {}

}
