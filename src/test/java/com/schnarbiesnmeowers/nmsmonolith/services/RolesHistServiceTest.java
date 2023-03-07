package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesHistDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RolesHistServiceTest {


	/**
	 * get all RolesHist records
	 * @return
	 * @throws Exception
	 */
	public List<RolesHistDTO> getAllRolesHist() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RolesHistDTO> roleshistDTO = new ArrayList<RolesHistDTO>();
		return roleshistDTO;
	}

	/**
	 * get RolesHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RolesHistDTO findRolesHistById(int id) throws Exception {
		return new RolesHistDTO();
	}

	/**
	 * create a new RolesHist
	 * @param data
	 * @return
	 */
	public RolesHistDTO createRolesHist(RolesHistDTO data) {
        data.setRoleHistId(1);
        return data;
	}

	/**
	 * update a RolesHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RolesHistDTO updateRolesHist(RolesHistDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RolesHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRolesHist(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RolesHistDTO> by foreign key : roleId
	 * @param id
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByRoleId(int id) throws Exception {
		List<RolesHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : grpId
	 * @param id
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByGrpId(int id) throws Exception {
		List<RolesHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : rsrcId
	 * @param id
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByRsrcId(int id) throws Exception {
		List<RolesHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByActionTypeId(int id) throws Exception {
		List<RolesHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : evntOperId
	 * @param id
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByEvntOperId(int id) throws Exception {
		List<RolesHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : RoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId
	 * @param id0
	 * @param id1
	 * @param id2
	 * @param id3
	 * @param id4
	 * @return
	 * @throws Exception
	 */
	public List<RolesHistDTO> findRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2,@PathVariable int id3,@PathVariable int id4) throws Exception {
		List<RolesHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
