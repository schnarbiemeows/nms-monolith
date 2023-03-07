package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientRecordDisplay;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Spices;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class SpicesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer spiceId;

	/**
	 * "name of the spice" 
	 */
	private String spiceName;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * default constructor
	 */
	public SpicesDTO() {
		super();
	}

	public SpicesDTO(Integer spiceId, String spiceName, String actv, Integer imageLoc) {
		super();
		this.spiceId = spiceId;
		this.spiceName = spiceName;
		this.actv = actv;
		this.imageLoc = imageLoc;
	}

	public Integer getSpiceId() {
		return spiceId;
	}

	public void setSpiceId(Integer spiceId) {
		this.spiceId=spiceId;
	}

	public String getSpiceName() {
		return spiceName;
	}

	public void setSpiceName(String spiceName) {
		this.spiceName=spiceName;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	@Override
	public String toString() {
		return "SpicesDTO [spiceId=" + spiceId + ", spiceName=" + spiceName + ", actv=" + actv + ", imageLoc=" + imageLoc + "]";
	}

	public static SpicesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, SpicesDTO.class );
	}
	public Spices toEntity() {
		return new Spices(this.getSpiceId(),this.getSpiceName(),this.getActv(),this.getImageLoc());
	}

	public SpiceRecordDisplay toDisplayObject() {
		return new SpiceRecordDisplay(this.spiceId,this.spiceName,false);
	}
}
