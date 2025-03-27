package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftLiftEqp;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LiftLiftEqpRepository extends JpaRepository<LiftLiftEqp, Integer> {


	/**
	 * get Iterable<LiftLiftEqp> by foreign key : liftId
	 * @param liftId
	 * @return Iterable<LiftLiftEqp>
	*/
	public Iterable<LiftLiftEqp> findLiftLiftEqpByLiftId(int liftId);
	/**
	 * get Iterable<LiftLiftEqp> by foreign key : liftEquipId
	 * @param liftEquipId
	 * @return Iterable<LiftLiftEqp>
	*/
	public Iterable<LiftLiftEqp> findLiftLiftEqpByLiftEquipId(int liftEquipId);
	/**
	 * get Iterable<LiftLiftEqp> by all foreign keys
	 * @return Iterable<LiftLiftEqp>
	*/
	public Iterable<LiftLiftEqp> findLiftLiftEqpByLiftIdAndLiftEquipId(int liftId,int liftEquipId);
}
