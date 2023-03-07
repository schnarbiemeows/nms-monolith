package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentTypeDTO;
import javax.persistence.*;
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
@Entity
@Table(name = "payment_type")
public class PaymentType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "payment_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer paymentTypeId;

	/**
	 * "short code for the payment type" 
	 */
	@Column(name = "payment_type_cde")
	private String paymentTypeCde;

	/**
	 * "longer description of the payment type" 
	 */
	@Column(name = "payment_type_desc")
	private String paymentTypeDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public PaymentType() {
		super();
	}

	public PaymentType(Integer paymentTypeId, String paymentTypeCde, String paymentTypeDesc, Integer imageLoc, String actv) {
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
		return "PaymentType [paymentTypeId=" + paymentTypeId + ", paymentTypeCde=" + paymentTypeCde + ", paymentTypeDesc=" + paymentTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static PaymentType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PaymentType.class );
	}
	public PaymentTypeDTO toDTO() {
		return new PaymentTypeDTO(this.getPaymentTypeId(),this.getPaymentTypeCde(),this.getPaymentTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
