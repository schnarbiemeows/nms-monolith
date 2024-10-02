package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Users;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {


}
