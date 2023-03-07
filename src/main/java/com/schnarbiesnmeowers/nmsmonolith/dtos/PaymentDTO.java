package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Payment;
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
public class PaymentDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer paymentId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "fk to the payment_type.payment_type_id field" 
	 */
	private Integer paymentTypeId;

	/**
	 * "payment amount" 
	 */
	private BigDecimal paymentAmt;

	/**
	 * "payment description" 
	 */
	private String paymentDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public PaymentDTO() {
		super();
	}

	public PaymentDTO(Integer paymentId, Integer userId, Integer paymentTypeId, BigDecimal paymentAmt, String paymentDesc, String actv) {
		super();
		this.paymentId = paymentId;
		this.userId = userId;
		this.paymentTypeId = paymentTypeId;
		this.paymentAmt = paymentAmt;
		this.paymentDesc = paymentDesc;
		this.actv = actv;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId=paymentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId=paymentTypeId;
	}

	public BigDecimal getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(BigDecimal paymentAmt) {
		this.paymentAmt=paymentAmt;
	}

	public String getPaymentDesc() {
		return paymentDesc;
	}

	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc=paymentDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", userId=" + userId + ", paymentTypeId=" + paymentTypeId + ", paymentAmt=" + paymentAmt + ", paymentDesc=" + paymentDesc + ", actv=" + actv + "]";
	}

	public static PaymentDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PaymentDTO.class );
	}
	public Payment toEntity() {
		return new Payment(this.getPaymentId(),this.getUserId(),this.getPaymentTypeId(),this.getPaymentAmt(),this.getPaymentDesc(),this.getActv());
	}
}
