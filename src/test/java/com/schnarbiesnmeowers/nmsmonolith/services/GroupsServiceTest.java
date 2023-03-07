package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GroupsServiceTest {


	/**
	 * get all Groups records
	 * @return
	 * @throws Exception
	 */
	public List<GroupsDTO> getAllGroups() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GroupsDTO> groupsDTO = new ArrayList<GroupsDTO>();
		return groupsDTO;
	}

	/**
	 * get Groups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GroupsDTO findGroupsById(int id) throws Exception {
		return new GroupsDTO();
	}

	/**
	 * create a new Groups
	 * @param data
	 * @return
	 */
	public GroupsDTO createGroups(GroupsDTO data) {
        data.setGrpId(1);
        return data;
	}

	/**
	 * update a Groups
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GroupsDTO updateGroups(GroupsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Groups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGroups(int id) throws Exception {
		return "Successfully Deleted";
	}

}
