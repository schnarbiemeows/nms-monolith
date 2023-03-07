package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RolesHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RolesHistRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RolesHistBusiness {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RolesHistRepository rolesHistRepository;

	/**
	 * get all RolesHist records
	 * @return
	 * @throws Exception
	 */
	public List<RolesHistDTO> getAllRolesHist() throws Exception {
		Iterable<RolesHist> roleshist = rolesHistRepository.findAll();
		Iterator<RolesHist> roleshists = roleshist.iterator();
		List<RolesHistDTO> roleshistdto = new ArrayList();
		while(roleshists.hasNext()) {
			RolesHist item = roleshists.next();
			roleshistdto.add(item.toDTO());
		}
		return roleshistdto;
	}

	/**
	 * get RolesHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RolesHistDTO findRolesHistById(int id) throws Exception {
		Optional<RolesHist> roleshistOptional = rolesHistRepository.findById(id);
		if(roleshistOptional.isPresent()) {
			RolesHist results = roleshistOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RolesHist
	 * @param data
	 * @return
	 */
	public RolesHistDTO createRolesHist(RolesHistDTO data) {
		try {
		    RolesHist createdData = data.toEntity();
		    createdData = rolesHistRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RolesHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RolesHistDTO updateRolesHist(RolesHistDTO data) throws Exception {
		Optional<RolesHist> roleshistOptional = rolesHistRepository.findById(data.getRoleHistId());
		if(roleshistOptional.isPresent()) {
		    RolesHist updatedData = data.toEntity();
			updatedData = rolesHistRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRoleHistId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RolesHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRolesHist(int id) throws Exception {
		Optional<RolesHist> roleshistOptional = rolesHistRepository.findById(id);
		if(roleshistOptional.isPresent()) {
			rolesHistRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RolesHistDTO> by foreign key : roleId
	 * @param roleId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByRoleId(int id) throws Exception {
		Iterable<RolesHist> results = rolesHistRepository.findRolesHistByRoleId(id);
		Iterator<RolesHist> iter = results.iterator();
		List<RolesHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RolesHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByGrpId(int id) throws Exception {
		Iterable<RolesHist> results = rolesHistRepository.findRolesHistByGrpId(id);
		Iterator<RolesHist> iter = results.iterator();
		List<RolesHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RolesHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : rsrcId
	 * @param rsrcId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByRsrcId(int id) throws Exception {
		Iterable<RolesHist> results = rolesHistRepository.findRolesHistByRsrcId(id);
		Iterator<RolesHist> iter = results.iterator();
		List<RolesHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RolesHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByActionTypeId(int id) throws Exception {
		Iterable<RolesHist> results = rolesHistRepository.findRolesHistByActionTypeId(id);
		Iterator<RolesHist> iter = results.iterator();
		List<RolesHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RolesHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByEvntOperId(int id) throws Exception {
		Iterable<RolesHist> results = rolesHistRepository.findRolesHistByEvntOperId(id);
		Iterator<RolesHist> iter = results.iterator();
		List<RolesHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RolesHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesHistDTO> by foreign key : RoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId
	 * @param RoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	public List<RolesHistDTO> findRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2,@PathVariable int id3,@PathVariable int id4) throws Exception {
		Iterable<RolesHist> results = rolesHistRepository.findRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId(id0, id1, id2, id3, id4);
		Iterator<RolesHist> iter = results.iterator();
		List<RolesHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RolesHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
