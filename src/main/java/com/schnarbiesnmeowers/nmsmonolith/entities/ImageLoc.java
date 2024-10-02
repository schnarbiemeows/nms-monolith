package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ImageLocDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "image_loc")
public class ImageLoc implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "image_loc_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer imageLocId;

	/**
	 * "description of the image" 
	 */
	@Column(name = "img_desc")
	private String imgDesc;

	/**
	 * "file path to the image") 
	 */
	@Column(name = "img_path")
	private String imgPath;

	/**
	 * default constructor
	 */
	public ImageLoc() {
		super();
	}

	public ImageLoc(Integer imageLocId, String imgDesc, String imgPath) {
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
		return "ImageLoc [imageLocId=" + imageLocId + ", imgDesc=" + imgDesc + ", imgPath=" + imgPath + "]";
	}

	public static ImageLoc fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ImageLoc.class );
	}
	public ImageLocDTO toDTO() {
		return new ImageLocDTO(this.getImageLocId(),this.getImgDesc(),this.getImgPath());
	}
}
