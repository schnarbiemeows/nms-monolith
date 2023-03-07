package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.UsersHist;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface UsersHistRepository extends JpaRepository<UsersHist, Integer> {


	/**
	 * get Iterable<UsersHist> by foreign key : userId
	 * @param userId
	 * @return Iterable<UsersHist>
	*/
	public Iterable<UsersHist> findUsersHistByUserId(int userId);
	/**
	 * get Iterable<UsersHist> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return Iterable<UsersHist>
	*/
	public Iterable<UsersHist> findUsersHistByActionTypeId(int actionTypeId);
	/**
	 * get Iterable<UsersHist> by foreign key : evntOperId
	 * @param evntOperId
	 * @return Iterable<UsersHist>
	*/
	public Iterable<UsersHist> findUsersHistByEvntOperId(int evntOperId);
	/**
	 * get Iterable<UsersHist> by all foreign keys
	 * @return Iterable<UsersHist>
	*/
	public Iterable<UsersHist> findUsersHistByUserIdAndActionTypeIdAndEvntOperId(int userId,int actionTypeId,int evntOperId);
}
