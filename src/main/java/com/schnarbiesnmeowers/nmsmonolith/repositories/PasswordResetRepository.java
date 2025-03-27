package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.PasswordReset;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface PasswordResetRepository extends JpaRepository<PasswordReset, Integer>{


}
