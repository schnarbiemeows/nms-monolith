package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftSteps;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LiftStepsRepository extends JpaRepository<LiftSteps, Integer> {


	/**
	 * get Iterable<LiftSteps> by foreign key : liftId
	 * @param liftId
	 * @return Iterable<LiftSteps>
	*/
	public Iterable<LiftSteps> findLiftStepsByLiftId(int liftId);
	/**
	 * get Iterable<LiftSteps> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<LiftSteps>
	*/
	public Iterable<LiftSteps> findLiftStepsByImageLoc(int imageLoc);
	/**
	 * get Iterable<LiftSteps> by all foreign keys
	 * @return Iterable<LiftSteps>
	*/
	public Iterable<LiftSteps> findLiftStepsByLiftIdAndImageLoc(int liftId,int imageLoc);
}
