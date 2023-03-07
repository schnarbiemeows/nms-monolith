package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Groups;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GroupsRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GroupsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GroupsRepository groupsRepository;

	/**
	 * get all Groups records
	 * @return
	 * @throws Exception
	 */
	public List<GroupsDTO> getAllGroups() throws Exception {
		Iterable<Groups> groups = groupsRepository.findAll();
		Iterator<Groups> groupss = groups.iterator();
		List<GroupsDTO> groupsdto = new ArrayList();
		while(groupss.hasNext()) {
			Groups item = groupss.next();
			groupsdto.add(item.toDTO());
		}
		return groupsdto;
	}

	/**
	 * get Groups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GroupsDTO findGroupsById(int id) throws Exception {
		Optional<Groups> groupsOptional = groupsRepository.findById(id);
		if(groupsOptional.isPresent()) {
			Groups results = groupsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Groups
	 * @param data
	 * @return
	 */
	public GroupsDTO createGroups(GroupsDTO data) {
		try {
		    Groups createdData = data.toEntity();
		    createdData = groupsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Groups
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GroupsDTO updateGroups(GroupsDTO data) throws Exception {
		Optional<Groups> groupsOptional = groupsRepository.findById(data.getGrpId());
		if(groupsOptional.isPresent()) {
		    Groups updatedData = data.toEntity();
			updatedData = groupsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGrpId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Groups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGroups(int id) throws Exception {
		Optional<Groups> groupsOptional = groupsRepository.findById(id);
		if(groupsOptional.isPresent()) {
			groupsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
