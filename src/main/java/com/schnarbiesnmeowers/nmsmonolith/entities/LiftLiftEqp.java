package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftLiftEqpDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "lift_lift_eqp")
public class LiftLiftEqp implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "lift_lift_eqp_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer liftLiftEqpId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	@Column(name = "lift_id")
	private Integer liftId;

	/**
	 * "fk to the lift_equip.lift_equip_id field" 
	 */
	@Column(name = "lift_equip_id")
	private Integer liftEquipId;

	/**
	 * default constructor
	 */
	public LiftLiftEqp() {
		super();
	}

	public LiftLiftEqp(Integer liftLiftEqpId, Integer liftId, Integer liftEquipId) {
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
		return "LiftLiftEqp [liftLiftEqpId=" + liftLiftEqpId + ", liftId=" + liftId + ", liftEquipId=" + liftEquipId + "]";
	}

	public static LiftLiftEqp fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftLiftEqp.class );
	}
	public LiftLiftEqpDTO toDTO() {
		return new LiftLiftEqpDTO(this.getLiftLiftEqpId(),this.getLiftId(),this.getLiftEquipId());
	}
}
