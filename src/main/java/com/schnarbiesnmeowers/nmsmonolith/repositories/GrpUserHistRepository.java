package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GrpUserHist;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GrpUserHistRepository extends JpaRepository<GrpUserHist, Integer> {


	/**
	 * get Iterable<GrpUserHist> by foreign key : grpUserId
	 * @param grpUserId
	 * @return Iterable<GrpUserHist>
	*/
	public Iterable<GrpUserHist> findGrpUserHistByGrpUserId(int grpUserId);
	/**
	 * get Iterable<GrpUserHist> by foreign key : grpId
	 * @param grpId
	 * @return Iterable<GrpUserHist>
	*/
	public Iterable<GrpUserHist> findGrpUserHistByGrpId(int grpId);
	/**
	 * get Iterable<GrpUserHist> by foreign key : userId
	 * @param userId
	 * @return Iterable<GrpUserHist>
	*/
	public Iterable<GrpUserHist> findGrpUserHistByUserId(int userId);
	/**
	 * get Iterable<GrpUserHist> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return Iterable<GrpUserHist>
	*/
	public Iterable<GrpUserHist> findGrpUserHistByActionTypeId(int actionTypeId);
	/**
	 * get Iterable<GrpUserHist> by foreign key : evntOperId
	 * @param evntOperId
	 * @return Iterable<GrpUserHist>
	*/
	public Iterable<GrpUserHist> findGrpUserHistByEvntOperId(int evntOperId);
	/**
	 * get Iterable<GrpUserHist> by all foreign keys
	 * @return Iterable<GrpUserHist>
	*/
	public Iterable<GrpUserHist> findGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId(int grpUserId,int grpId,int userId,int actionTypeId,int evntOperId);
}
