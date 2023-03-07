package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsHistDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GroupsHistBusiness {


	/**
	 * get all GroupsHist records
	 * @return
	 * @throws Exception
	 */
	public List<GroupsHistDTO> getAllGroupsHist() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GroupsHistDTO> groupshistDTO = new ArrayList<GroupsHistDTO>();
		return groupshistDTO;
	}

	/**
	 * get GroupsHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GroupsHistDTO findGroupsHistById(int id) throws Exception {
		return new GroupsHistDTO();
	}

	/**
	 * create a new GroupsHist
	 * @param data
	 * @return
	 */
	public GroupsHistDTO createGroupsHist(GroupsHistDTO data) {
        data.setGrpHistId(1);
        return data;
	}

	/**
	 * update a GroupsHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GroupsHistDTO updateGroupsHist(GroupsHistDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GroupsHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGroupsHist(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByGrpId(int id) throws Exception {
		List<GroupsHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByActionTypeId(int id) throws Exception {
		List<GroupsHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByEvntOperId(int id) throws Exception {
		List<GroupsHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : GrpIdAndActionTypeIdAndEvntOperId
	 * @param GrpIdAndActionTypeIdAndEvntOperId
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByGrpIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		List<GroupsHistDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
