package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.PaymentType;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class PaymentTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer paymentTypeId;

	/**
	 * "short code for the payment type" 
	 */
	private String paymentTypeCde;

	/**
	 * "longer description of the payment type" 
	 */
	private String paymentTypeDesc;

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
	public PaymentTypeDTO() {
		super();
	}

	public PaymentTypeDTO(Integer paymentTypeId, String paymentTypeCde, String paymentTypeDesc, Integer imageLoc, String actv) {
		super();
		this.paymentTypeId = paymentTypeId;
		this.paymentTypeCde = paymentTypeCde;
		this.paymentTypeDesc = paymentTypeDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId=paymentTypeId;
	}

	public String getPaymentTypeCde() {
		return paymentTypeCde;
	}

	public void setPaymentTypeCde(String paymentTypeCde) {
		this.paymentTypeCde=paymentTypeCde;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc=paymentTypeDesc;
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
		return "PaymentTypeDTO [paymentTypeId=" + paymentTypeId + ", paymentTypeCde=" + paymentTypeCde + ", paymentTypeDesc=" + paymentTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static PaymentTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PaymentTypeDTO.class );
	}
	public PaymentType toEntity() {
		return new PaymentType(this.getPaymentTypeId(),this.getPaymentTypeCde(),this.getPaymentTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
