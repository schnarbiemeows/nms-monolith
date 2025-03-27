package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.GroupsHist;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GroupsHistRepository extends JpaRepository<GroupsHist, Integer> {


	/**
	 * get Iterable<GroupsHist> by foreign key : grpId
	 * @param grpId
	 * @return Iterable<GroupsHist>
	*/
	public Iterable<GroupsHist> findGroupsHistByGrpId(int grpId);
	/**
	 * get Iterable<GroupsHist> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return Iterable<GroupsHist>
	*/
	public Iterable<GroupsHist> findGroupsHistByActionTypeId(int actionTypeId);
	/**
	 * get Iterable<GroupsHist> by foreign key : evntOperId
	 * @param evntOperId
	 * @return Iterable<GroupsHist>
	*/
	public Iterable<GroupsHist> findGroupsHistByEvntOperId(int evntOperId);
	/**
	 * get Iterable<GroupsHist> by all foreign keys
	 * @return Iterable<GroupsHist>
	*/
	public Iterable<GroupsHist> findGroupsHistByGrpIdAndActionTypeIdAndEvntOperId(int grpId,int actionTypeId,int evntOperId);
}
