package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftLiftEqp;
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
public class LiftLiftEqpDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer liftLiftEqpId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	private Integer liftId;

	/**
	 * "fk to the lift_equip.lift_equip_id field" 
	 */
	private Integer liftEquipId;

	/**
	 * default constructor
	 */
	public LiftLiftEqpDTO() {
		super();
	}

	public LiftLiftEqpDTO(Integer liftLiftEqpId, Integer liftId, Integer liftEquipId) {
		super();
		this.liftLiftEqpId = liftLiftEqpId;
		this.liftId = liftId;
		this.liftEquipId = liftEquipId;
	}

	public Integer getLiftLiftEqpId() {
		return liftLiftEqpId;
	}

	public void setLiftLiftEqpId(Integer liftLiftEqpId) {
		this.liftLiftEqpId=liftLiftEqpId;
	}

	public Integer getLiftId() {
		return liftId;
	}

	public void setLiftId(Integer liftId) {
		this.liftId=liftId;
	}

	public Integer getLiftEquipId() {
		return liftEquipId;
	}

	public void setLiftEquipId(Integer liftEquipId) {
		this.liftEquipId=liftEquipId;
	}

	@Override
	public String toString() {
		return "LiftLiftEqpDTO [liftLiftEqpId=" + liftLiftEqpId + ", liftId=" + liftId + ", liftEquipId=" + liftEquipId + "]";
	}

	public static LiftLiftEqpDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftLiftEqpDTO.class );
	}
	public LiftLiftEqp toEntity() {
		return new LiftLiftEqp(this.getLiftLiftEqpId(),this.getLiftId(),this.getLiftEquipId());
	}
}
