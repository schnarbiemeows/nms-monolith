package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "payment")
public class Payment implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "payment_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "fk to the payment_type.payment_type_id field" 
	 */
	@Column(name = "payment_type_id")
	private Integer paymentTypeId;

	/**
	 * "payment amount" 
	 */
	@Column(name = "payment_amt")
	private BigDecimal paymentAmt;

	/**
	 * "payment description" 
	 */
	@Column(name = "payment_desc")
	private String paymentDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Payment() {
		super();
	}

	public Payment(Integer paymentId, Integer userId, Integer paymentTypeId, BigDecimal paymentAmt, String paymentDesc, String actv) {
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
		return "Payment [paymentId=" + paymentId + ", userId=" + userId + ", paymentTypeId=" + paymentTypeId + ", paymentAmt=" + paymentAmt + ", paymentDesc=" + paymentDesc + ", actv=" + actv + "]";
	}

	public static Payment fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Payment.class );
	}
	public PaymentDTO toDTO() {
		return new PaymentDTO(this.getPaymentId(),this.getUserId(),this.getPaymentTypeId(),this.getPaymentAmt(),this.getPaymentDesc(),this.getActv());
	}
}
