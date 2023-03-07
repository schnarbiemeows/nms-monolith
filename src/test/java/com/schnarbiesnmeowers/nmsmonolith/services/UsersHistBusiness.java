package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UsersHistBusiness {


	/**
	 * get all UsersHist records
	 * @return
	 * @throws Exception
	 */
	public List<UsersHistDTO> getAllUsersHist() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<UsersHistDTO> usershistDTO = new ArrayList<UsersHistDTO>();
		return usershistDTO;
	}

	/**
	 * get UsersHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UsersHistDTO findUsersHistById(int id) throws Exception {
		return new UsersHistDTO();
	}

	/**
	 * create a new UsersHist
	 * @param data
	 * @return
	 */
	public UsersHistDTO createUsersHist(UsersHistDTO data) {
        data.setUsersHistId(1);
        return data;
	}

	/**
	 * update a UsersHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UsersHistDTO updateUsersHist(UsersHistDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a UsersHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUsersHist(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<UsersHistDTO> by foreign key : userId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByUserId(int id) throws Exception {
		List<UsersHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<UsersHistDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByActionTypeId(int id) throws Exception {
		List<UsersHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<UsersHistDTO> by foreign key : evntOperId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByEvntOperId(int id) throws Exception {
		List<UsersHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<UsersHistDTO> by foreign key : UserIdAndActionTypeIdAndEvntOperId
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	public List<UsersHistDTO> findUsersHistByUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		List<UsersHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
