package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RolesServiceTest {


	/**
	 * get all Roles records
	 * @return
	 * @throws Exception
	 */
	public List<RolesDTO> getAllRoles() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RolesDTO> rolesDTO = new ArrayList<RolesDTO>();
		return rolesDTO;
	}

	/**
	 * get Roles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RolesDTO findRolesById(int id) throws Exception {
		return new RolesDTO();
	}

	/**
	 * create a new Roles
	 * @param data
	 * @return
	 */
	public RolesDTO createRoles(RolesDTO data) {
        data.setRoleId(1);
        return data;
	}

	/**
	 * update a Roles
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RolesDTO updateRoles(RolesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Roles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRoles(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RolesDTO> by foreign key : grpId
	 * @param id
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByGrpId(int id) throws Exception {
		List<RolesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesDTO> by foreign key : rsrcId
	 * @param id
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByRsrcId(int id) throws Exception {
		List<RolesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByActionTypeId(int id) throws Exception {
		List<RolesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesDTO> by foreign key : GrpIdAndRsrcIdAndActionTypeId
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	public List<RolesDTO> findRolesByGrpIdAndRsrcIdAndActionTypeId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		List<RolesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
