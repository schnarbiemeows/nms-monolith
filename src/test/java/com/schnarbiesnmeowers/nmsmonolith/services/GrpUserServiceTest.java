package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GrpUserServiceTest {


	/**
	 * get all GrpUser records
	 * @return
	 * @throws Exception
	 */
	public List<GrpUserDTO> getAllGrpUser() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GrpUserDTO> grpuserDTO = new ArrayList<GrpUserDTO>();
		return grpuserDTO;
	}

	/**
	 * get GrpUser by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GrpUserDTO findGrpUserById(int id) throws Exception {
		return new GrpUserDTO();
	}

	/**
	 * create a new GrpUser
	 * @param data
	 * @return
	 */
	public GrpUserDTO createGrpUser(GrpUserDTO data) {
        data.setGrpUserId(1);
        return data;
	}

	/**
	 * update a GrpUser
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GrpUserDTO updateGrpUser(GrpUserDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GrpUser by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGrpUser(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GrpUserDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	public List<GrpUserDTO> findGrpUserByGrpId(int id) throws Exception {
		List<GrpUserDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserDTO> by foreign key : userId
	 * @param userId
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	public List<GrpUserDTO> findGrpUserByUserId(int id) throws Exception {
		List<GrpUserDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserDTO> by foreign key : GrpIdAndUserId
	 * @param GrpIdAndUserId
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	public List<GrpUserDTO> findGrpUserByGrpIdAndUserId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<GrpUserDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
