package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftEquip;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LiftEquipRepository extends JpaRepository<LiftEquip, Integer> {


	/**
	 * get Iterable<LiftEquip> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<LiftEquip>
	*/
	public Iterable<LiftEquip> findLiftEquipByImageLoc(int imageLoc);
}
