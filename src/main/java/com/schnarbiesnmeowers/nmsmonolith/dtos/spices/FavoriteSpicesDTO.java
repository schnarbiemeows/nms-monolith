package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteSpices;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class FavoriteSpicesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer favoriteSpiceId;

	/**
	 * "fk to the spices.spice_id field or the local_spices.spice_id field" 
	 */
	private Integer spiceId;

	/**
	 * "is the spice_id fk a local spice_id?" 
	 */
	private boolean isLocal;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	/**
	 * "fk to the user.user_id field") 
	 */
	private Integer userId;

	/**
	 * default constructor
	 */
	public FavoriteSpicesDTO() {
		super();
	}

	public FavoriteSpicesDTO(Integer favoriteSpiceId, Integer spiceId, boolean isLocal, String actv, Integer userId) {
		super();
		this.favoriteSpiceId = favoriteSpiceId;
		this.spiceId = spiceId;
		this.isLocal = isLocal;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getFavoriteSpiceId() {
		return favoriteSpiceId;
	}

	public void setFavoriteSpiceId(Integer favoriteSpiceId) {
		this.favoriteSpiceId=favoriteSpiceId;
	}

	public Integer getSpiceId() {
		return spiceId;
	}

	public void setSpiceId(Integer spiceId) {
		this.spiceId=spiceId;
	}

	public boolean getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(boolean isLocal) {
		this.isLocal=isLocal;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "FavoriteSpicesDTO [favoriteSpiceId=" + favoriteSpiceId + ", spiceId=" + spiceId + ", isLocal=" + isLocal + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteSpicesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteSpicesDTO.class );
	}
	public FavoriteSpices toEntity() {
		return new FavoriteSpices(this.getFavoriteSpiceId(),this.getSpiceId(),this.getIsLocal(),this.getActv(),this.getUserId());
	}
}
