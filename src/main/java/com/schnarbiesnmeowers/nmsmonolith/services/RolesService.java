package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Roles;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RolesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RolesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RolesRepository rolesRepository;

	/**
	 * get all Roles records
	 * @return
	 * @throws Exception
	 */
	public List<RolesDTO> getAllRoles() throws Exception {
		Iterable<Roles> roles = rolesRepository.findAll();
		Iterator<Roles> roless = roles.iterator();
		List<RolesDTO> rolesdto = new ArrayList();
		while(roless.hasNext()) {
			Roles item = roless.next();
			rolesdto.add(item.toDTO());
		}
		return rolesdto;
	}

	/**
	 * get Roles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RolesDTO findRolesById(int id) throws Exception {
		Optional<Roles> rolesOptional = rolesRepository.findById(id);
		if(rolesOptional.isPresent()) {
			Roles results = rolesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Roles
	 * @param data
	 * @return
	 */
	public RolesDTO createRoles(RolesDTO data) {
		try {
		    Roles createdData = data.toEntity();
		    createdData = rolesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Roles
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RolesDTO updateRoles(RolesDTO data) throws Exception {
		Optional<Roles> rolesOptional = rolesRepository.findById(data.getRoleId());
		if(rolesOptional.isPresent()) {
		    Roles updatedData = data.toEntity();
			updatedData = rolesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRoleId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Roles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRoles(int id) throws Exception {
		Optional<Roles> rolesOptional = rolesRepository.findById(id);
		if(rolesOptional.isPresent()) {
			rolesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RolesDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByGrpId(int id) throws Exception {
		Iterable<Roles> results = rolesRepository.findRolesByGrpId(id);
		Iterator<Roles> iter = results.iterator();
		List<RolesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Roles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesDTO> by foreign key : rsrcId
	 * @param rsrcId
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByRsrcId(int id) throws Exception {
		Iterable<Roles> results = rolesRepository.findRolesByRsrcId(id);
		Iterator<Roles> iter = results.iterator();
		List<RolesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Roles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByActionTypeId(int id) throws Exception {
		Iterable<Roles> results = rolesRepository.findRolesByActionTypeId(id);
		Iterator<Roles> iter = results.iterator();
		List<RolesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Roles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RolesDTO> by foreign key : GrpIdAndRsrcIdAndActionTypeId
	 * @param GrpIdAndRsrcIdAndActionTypeId
	 * @return List<Roles>
	 * @throws Exception
	*/
	public List<RolesDTO> findRolesByGrpIdAndRsrcIdAndActionTypeId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<Roles> results = rolesRepository.findRolesByGrpIdAndRsrcIdAndActionTypeId(id0, id1, id2);
		Iterator<Roles> iter = results.iterator();
		List<RolesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Roles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
