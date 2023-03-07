package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Roles;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RolesRepository extends JpaRepository<Roles, Integer> {


	/**
	 * get Iterable<Roles> by foreign key : grpId
	 * @param grpId
	 * @return Iterable<Roles>
	*/
	public Iterable<Roles> findRolesByGrpId(int grpId);
	/**
	 * get Iterable<Roles> by foreign key : rsrcId
	 * @param rsrcId
	 * @return Iterable<Roles>
	*/
	public Iterable<Roles> findRolesByRsrcId(int rsrcId);
	/**
	 * get Iterable<Roles> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return Iterable<Roles>
	*/
	public Iterable<Roles> findRolesByActionTypeId(int actionTypeId);
	/**
	 * get Iterable<Roles> by all foreign keys
	 * @return Iterable<Roles>
	*/
	public Iterable<Roles> findRolesByGrpIdAndRsrcIdAndActionTypeId(int grpId,int rsrcId,int actionTypeId);
}
