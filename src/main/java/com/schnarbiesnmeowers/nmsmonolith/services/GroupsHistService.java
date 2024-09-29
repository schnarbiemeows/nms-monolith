package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GroupsHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GroupsHistRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GroupsHistService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GroupsHistRepository groupsHistRepository;

	/**
	 * get all GroupsHist records
	 * @return
	 * @throws Exception
	 */
	public List<GroupsHistDTO> getAllGroupsHist() throws Exception {
		Iterable<GroupsHist> groupshist = groupsHistRepository.findAll();
		Iterator<GroupsHist> groupshists = groupshist.iterator();
		List<GroupsHistDTO> groupshistdto = new ArrayList();
		while(groupshists.hasNext()) {
			GroupsHist item = groupshists.next();
			groupshistdto.add(item.toDTO());
		}
		return groupshistdto;
	}

	/**
	 * get GroupsHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GroupsHistDTO findGroupsHistById(int id) throws Exception {
		Optional<GroupsHist> groupshistOptional = groupsHistRepository.findById(id);
		if(groupshistOptional.isPresent()) {
			GroupsHist results = groupshistOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GroupsHist
	 * @param data
	 * @return
	 */
	public GroupsHistDTO createGroupsHist(GroupsHistDTO data) {
		try {
		    GroupsHist createdData = data.toEntity();
		    createdData = groupsHistRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GroupsHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GroupsHistDTO updateGroupsHist(GroupsHistDTO data) throws Exception {
		Optional<GroupsHist> groupshistOptional = groupsHistRepository.findById(data.getGrpHistId());
		if(groupshistOptional.isPresent()) {
		    GroupsHist updatedData = data.toEntity();
			updatedData = groupsHistRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGrpHistId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GroupsHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGroupsHist(int id) throws Exception {
		Optional<GroupsHist> groupshistOptional = groupsHistRepository.findById(id);
		if(groupshistOptional.isPresent()) {
			groupsHistRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : grpId
	 * @param id
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByGrpId(int id) throws Exception {
		Iterable<GroupsHist> results = groupsHistRepository.findGroupsHistByGrpId(id);
		Iterator<GroupsHist> iter = results.iterator();
		List<GroupsHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GroupsHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByActionTypeId(int id) throws Exception {
		Iterable<GroupsHist> results = groupsHistRepository.findGroupsHistByActionTypeId(id);
		Iterator<GroupsHist> iter = results.iterator();
		List<GroupsHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GroupsHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : evntOperId
	 * @param id
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByEvntOperId(int id) throws Exception {
		Iterable<GroupsHist> results = groupsHistRepository.findGroupsHistByEvntOperId(id);
		Iterator<GroupsHist> iter = results.iterator();
		List<GroupsHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GroupsHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : GrpIdAndActionTypeIdAndEvntOperId
	 * @param id0
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	public List<GroupsHistDTO> findGroupsHistByGrpIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<GroupsHist> results = groupsHistRepository.findGroupsHistByGrpIdAndActionTypeIdAndEvntOperId(id0, id1, id2);
		Iterator<GroupsHist> iter = results.iterator();
		List<GroupsHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GroupsHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
