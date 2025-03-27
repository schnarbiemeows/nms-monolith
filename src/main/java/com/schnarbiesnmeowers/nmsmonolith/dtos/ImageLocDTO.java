package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.ImageLoc;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class ImageLocDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer imageLocId;

	/**
	 * "description of the image" 
	 */
	private String imgDesc;

	/**
	 * "file path to the image") 
	 */
	private String imgPath;

	/**
	 * default constructor
	 */
	public ImageLocDTO() {
		super();
	}

	public ImageLocDTO(Integer imageLocId, String imgDesc, String imgPath) {
		super();
		this.imageLocId = imageLocId;
		this.imgDesc = imgDesc;
		this.imgPath = imgPath;
	}

	public Integer getImageLocId() {
		return imageLocId;
	}

	public void setImageLocId(Integer imageLocId) {
		this.imageLocId=imageLocId;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc=imgDesc;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath=imgPath;
	}

	@Override
	public String toString() {
		return "ImageLocDTO [imageLocId=" + imageLocId + ", imgDesc=" + imgDesc + ", imgPath=" + imgPath + "]";
	}

	public static ImageLocDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ImageLocDTO.class );
	}
	public ImageLoc toEntity() {
		return new ImageLoc(this.getImageLocId(),this.getImgDesc(),this.getImgPath());
	}
}
