package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUser;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GrpUserRepository extends JpaRepository<GrpUser, Integer> {


	/**
	 * get Iterable<GrpUser> by foreign key : grpId
	 * @param grpId
	 * @return Iterable<GrpUser>
	*/
	public Iterable<GrpUser> findGrpUserByGrpId(int grpId);
	/**
	 * get Iterable<GrpUser> by foreign key : userId
	 * @param userId
	 * @return Iterable<GrpUser>
	*/
	public Iterable<GrpUser> findGrpUserByUserId(int userId);
	/**
	 * get Iterable<GrpUser> by all foreign keys
	 * @return Iterable<GrpUser>
	*/
	public Iterable<GrpUser> findGrpUserByGrpIdAndUserId(int grpId,int userId);
}
