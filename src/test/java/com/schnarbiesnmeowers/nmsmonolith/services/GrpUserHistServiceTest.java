package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserHistDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GrpUserHistServiceTest {


	/**
	 * get all GrpUserHist records
	 * @return
	 * @throws Exception
	 */
	public List<GrpUserHistDTO> getAllGrpUserHist() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GrpUserHistDTO> grpuserhistDTO = new ArrayList<GrpUserHistDTO>();
		return grpuserhistDTO;
	}

	/**
	 * get GrpUserHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GrpUserHistDTO findGrpUserHistById(int id) throws Exception {
		return new GrpUserHistDTO();
	}

	/**
	 * create a new GrpUserHist
	 * @param data
	 * @return
	 */
	public GrpUserHistDTO createGrpUserHist(GrpUserHistDTO data) {
        data.setGrpUserHistId(1);
        return data;
	}

	/**
	 * update a GrpUserHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GrpUserHistDTO updateGrpUserHist(GrpUserHistDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GrpUserHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGrpUserHist(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : grpUserId
	 * @param grpUserId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByGrpUserId(int id) throws Exception {
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByGrpId(int id) throws Exception {
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : userId
	 * @param userId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByUserId(int id) throws Exception {
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByActionTypeId(int id) throws Exception {
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByEvntOperId(int id) throws Exception {
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : GrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId
	 * @param GrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2,@PathVariable int id3,@PathVariable int id4) throws Exception {
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
