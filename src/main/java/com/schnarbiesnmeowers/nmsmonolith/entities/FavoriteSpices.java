package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "favorite_spices")
public class FavoriteSpices implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "favorite_spice_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer favoriteSpiceId;

	/**
	 * "fk to the spices.spice_id field or the local_spices.spice_id field" 
	 */
	@Column(name = "spice_id")
	private Integer spiceId;

	/**
	 * "is the spice_id fk a local spice_id?" 
	 */
	@Column(name = "is_local")
	private boolean isLocal;

	/**
	 * "is this record active(y or n)?" 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * "fk to the user.user_id field") 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * default constructor
	 */
	public FavoriteSpices() {
		super();
	}

	public FavoriteSpices(Integer favoriteSpiceId, Integer spiceId, boolean isLocal, String actv, Integer userId) {
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
		return "FavoriteSpices [favoriteSpiceId=" + favoriteSpiceId + ", spiceId=" + spiceId + ", isLocal=" + isLocal + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteSpices fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteSpices.class );
	}
	public FavoriteSpicesDTO toDTO() {
		return new FavoriteSpicesDTO(this.getFavoriteSpiceId(),this.getSpiceId(),this.getIsLocal(),this.getActv(),this.getUserId());
	}
}
