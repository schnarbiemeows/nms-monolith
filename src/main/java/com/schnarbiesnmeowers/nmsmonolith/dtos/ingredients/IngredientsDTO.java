package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Ingredients;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class IngredientsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer ingrId;

	/**
	 * "description of the ingredient" 
	 */
	private String ingrDesc;

	/**
	 * "fk to the ingredient_types.ingr_type_id field" 
	 */
	private Integer ingrTypeId;

	/**
	 * "fk to the brands.brand_id field" 
	 */
	private Integer brandId;

	/**
	 * "the size of an individual serving" 
	 */
	private BigDecimal servSz;

	/**
	 * "fk to the serving_types.serv_type_id field" 
	 */
	private Integer servTypeId;

	/**
	 * "total killocalories per serving" 
	 */
	private BigDecimal kcalories;

	/**
	 * "total fat in grams  per serving" 
	 */
	private BigDecimal totFat;

	/**
	 * "total saturated fat in grams  per serving" 
	 */
	private BigDecimal satFat;

	/**
	 * "total trans fat in grams  per serving" 
	 */
	private BigDecimal transFat;

	/**
	 * "total polyunsaturated fat in grams per serving" 
	 */
	private BigDecimal polyFat;

	/**
	 * "total monounsaturated fat in grams per serving" 
	 */
	private BigDecimal monoFat;

	/**
	 * "total cholesterol in milligrams per serving" 
	 */
	private BigDecimal choles;

	/**
	 * "total sodium in milligrams per serving" 
	 */
	private Integer sodium;

	/**
	 * "total carbohydrates in grams per serving" 
	 */
	private BigDecimal totCarbs;

	/**
	 * "total fiber in grams per serving" 
	 */
	private BigDecimal totFiber;

	/**
	 * "total sugars in grams per serving" 
	 */
	private BigDecimal totSugars;

	/**
	 * "total protein in grams per serving" 
	 */
	private BigDecimal totProtein;

	/**
	 * "the glycemic index of this ingredient" 
	 */
	private BigDecimal glycIndx;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public IngredientsDTO() {
		super();
	}

	public IngredientsDTO(Integer ingrId, String ingrDesc, Integer ingrTypeId, Integer brandId, BigDecimal servSz,
						  Integer servTypeId, BigDecimal kcalories, BigDecimal totFat, BigDecimal satFat,
						  BigDecimal transFat, BigDecimal polyFat, BigDecimal monoFat, BigDecimal choles,
						  Integer sodium, BigDecimal totCarbs, BigDecimal totFiber, BigDecimal totSugars,
						  BigDecimal totProtein, BigDecimal glycIndx, Integer imageLoc, String actv) {
		this.ingrId = ingrId;
		this.ingrDesc = ingrDesc;
		this.ingrTypeId = ingrTypeId;
		this.brandId = brandId;
		this.servSz = servSz;
		this.servTypeId = servTypeId;
		this.kcalories = kcalories;
		this.totFat = totFat;
		this.satFat = satFat;
		this.transFat = transFat;
		this.polyFat = polyFat;
		this.monoFat = monoFat;
		this.choles = choles;
		this.sodium = sodium;
		this.totCarbs = totCarbs;
		this.totFiber = totFiber;
		this.totSugars = totSugars;
		this.totProtein = totProtein;
		this.glycIndx = glycIndx;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getIngrId() {
		return ingrId;
	}

	public void setIngrId(Integer ingrId) {
		this.ingrId=ingrId;
	}

	public String getIngrDesc() {
		return ingrDesc;
	}

	public void setIngrDesc(String ingrDesc) {
		this.ingrDesc=ingrDesc;
	}

	public Integer getIngrTypeId() {
		return ingrTypeId;
	}

	public void setIngrTypeId(Integer ingrTypeId) {
		this.ingrTypeId=ingrTypeId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId=brandId;
	}

	public BigDecimal getServSz() {
		return servSz;
	}

	public void setServSz(BigDecimal servSz) {
		this.servSz=servSz;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	public BigDecimal getKcalories() {
		return kcalories;
	}

	public void setKcalories(BigDecimal kcalories) {
		this.kcalories=kcalories;
	}

	public BigDecimal getTotFat() {
		return totFat;
	}

	public void setTotFat(BigDecimal totFat) {
		this.totFat=totFat;
	}

	public BigDecimal getSatFat() {
		return satFat;
	}

	public void setSatFat(BigDecimal satFat) {
		this.satFat=satFat;
	}

	public BigDecimal getTransFat() {
		return transFat;
	}

	public void setTransFat(BigDecimal transFat) {
		this.transFat=transFat;
	}

	public BigDecimal getPolyFat() {
		return polyFat;
	}

	public void setPolyFat(BigDecimal polyFat) {
		this.polyFat=polyFat;
	}

	public BigDecimal getMonoFat() {
		return monoFat;
	}

	public void setMonoFat(BigDecimal monoFat) {
		this.monoFat=monoFat;
	}

	public BigDecimal getCholes() {
		return choles;
	}

	public void setCholes(BigDecimal choles) {
		this.choles=choles;
	}

	public Integer getSodium() {
		return sodium;
	}

	public void setSodium(Integer sodium) {
		this.sodium=sodium;
	}

	public BigDecimal getTotCarbs() {
		return totCarbs;
	}

	public void setTotCarbs(BigDecimal totCarbs) {
		this.totCarbs=totCarbs;
	}

	public BigDecimal getTotFiber() {
		return totFiber;
	}

	public void setTotFiber(BigDecimal totFiber) {
		this.totFiber=totFiber;
	}

	public BigDecimal getTotSugars() {
		return totSugars;
	}

	public void setTotSugars(BigDecimal totSugars) {
		this.totSugars=totSugars;
	}

	public BigDecimal getTotProtein() {
		return totProtein;
	}

	public void setTotProtein(BigDecimal totProtein) {
		this.totProtein=totProtein;
	}

	public BigDecimal getGlycIndx() {
		return glycIndx;
	}

	public void setGlycIndx(BigDecimal glycIndx) {
		this.glycIndx=glycIndx;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}


	@Override
	public String toString() {
		return "IngredientsDTO{" +
				"ingrId=" + ingrId +
				", ingrDesc='" + ingrDesc + '\'' +
				", ingrTypeId=" + ingrTypeId +
				", brandId=" + brandId +
				", servSz=" + servSz +
				", servTypeId=" + servTypeId +
				", kcalories=" + kcalories +
				", totFat=" + totFat +
				", satFat=" + satFat +
				", transFat=" + transFat +
				", polyFat=" + polyFat +
				", monoFat=" + monoFat +
				", choles=" + choles +
				", sodium=" + sodium +
				", totCarbs=" + totCarbs +
				", totFiber=" + totFiber +
				", totSugars=" + totSugars +
				", totProtein=" + totProtein +
				", glycIndx=" + glycIndx +
				", imageLoc=" + imageLoc +
				", actv='" + actv + '\'' +
				'}';
	}

	public static IngredientsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, IngredientsDTO.class );
	}
	public Ingredients toEntity() {
		return new Ingredients(this.getIngrId(),this.getIngrDesc(),this.getIngrTypeId(),this.getBrandId(),this.getServSz(),this.getServTypeId(),this.getKcalories(),this.getTotFat(),this.getSatFat(),this.getTransFat(),this.getPolyFat(),this.getMonoFat(),this.getCholes(),this.getSodium(),this.getTotCarbs(),this.getTotFiber(),this.getTotSugars(),this.getTotProtein(),this.getGlycIndx(),this.getImageLoc(),this.getActv());
	}

	public IngredientRecordDisplay toDisplayObject() {
		return new IngredientRecordDisplay(this.getIngrId(),this.getIngrDesc(),this.getIngrTypeId(),this.getBrandId(),false,false);
	}
}
