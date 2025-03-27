package com.schnarbiesnmeowers.nmsmonolith.services;

//import com.schnarbiesnmeowers.nmsmonolith.exceptions.user.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Dylan I. Kessler
 *
 */
@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements UserDetailsService {

	/**
	 * this is the main method that the Spring Security will call; our program itself does not directly call it
	 * @param username
	 * @returns UserDetails
	 */
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logAction("finding User - " + username);
		AppUser user = repository.findUserByUserName(username);
		if(user == null) {
			logAction("User - " + username + " not found!");
			throw new UsernameNotFoundException(USER_NOT_FOUND + " : " + username);
		} else {
			try {
				validateLoginAttempt(user);
			} catch (AddressException e) {
				logAction("AddressException when trying to send an email to administrators for a locked account");
				e.printStackTrace();
			} catch (MessagingException e) {
				logAction("MessagingException when trying to send an email to administrators for a locked account");
				e.printStackTrace();
			}
			user.setLastLoginDateDisplay(user.getLastLoginDate());
			user.setLastLoginDate(LocalDate.now());
			repository.save(user);
			UserPrincipal userPrincipal = new UserPrincipal(user.toDTO());
			logAction("returning User - " + username);
			return userPrincipal;
		}
	}*/


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
