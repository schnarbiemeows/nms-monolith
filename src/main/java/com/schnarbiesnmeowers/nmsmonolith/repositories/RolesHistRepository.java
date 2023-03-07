package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RolesHist;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RolesHistRepository extends JpaRepository<RolesHist, Integer> {


	/**
	 * get Iterable<RolesHist> by foreign key : roleId
	 * @param roleId
	 * @return Iterable<RolesHist>
	*/
	public Iterable<RolesHist> findRolesHistByRoleId(int roleId);
	/**
	 * get Iterable<RolesHist> by foreign key : grpId
	 * @param grpId
	 * @return Iterable<RolesHist>
	*/
	public Iterable<RolesHist> findRolesHistByGrpId(int grpId);
	/**
	 * get Iterable<RolesHist> by foreign key : rsrcId
	 * @param rsrcId
	 * @return Iterable<RolesHist>
	*/
	public Iterable<RolesHist> findRolesHistByRsrcId(int rsrcId);
	/**
	 * get Iterable<RolesHist> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return Iterable<RolesHist>
	*/
	public Iterable<RolesHist> findRolesHistByActionTypeId(int actionTypeId);
	/**
	 * get Iterable<RolesHist> by foreign key : evntOperId
	 * @param evntOperId
	 * @return Iterable<RolesHist>
	*/
	public Iterable<RolesHist> findRolesHistByEvntOperId(int evntOperId);
	/**
	 * get Iterable<RolesHist> by all foreign keys
	 * @return Iterable<RolesHist>
	*/
	public Iterable<RolesHist> findRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId(int roleId,int grpId,int rsrcId,int actionTypeId,int evntOperId);
}
