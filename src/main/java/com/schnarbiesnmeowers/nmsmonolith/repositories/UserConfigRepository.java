package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.UserConfig;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface UserConfigRepository extends JpaRepository<UserConfig, Integer> {


	/**
	 * get Iterable<UserConfig> by foreign key : userId
	 * @param userId
	 * @return Iterable<UserConfig>
	*/
	public Iterable<UserConfig> findUserConfigByUserId(int userId);
}
