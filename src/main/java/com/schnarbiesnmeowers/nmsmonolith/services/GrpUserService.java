package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUser;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GrpUserRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GrpUserService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GrpUserRepository grpUserRepository;

	/**
	 * get all GrpUser records
	 * @return
	 * @throws Exception
	 */
	public List<GrpUserDTO> getAllGrpUser() throws Exception {
		Iterable<GrpUser> grpuser = grpUserRepository.findAll();
		Iterator<GrpUser> grpusers = grpuser.iterator();
		List<GrpUserDTO> grpuserdto = new ArrayList();
		while(grpusers.hasNext()) {
			GrpUser item = grpusers.next();
			grpuserdto.add(item.toDTO());
		}
		return grpuserdto;
	}

	/**
	 * get GrpUser by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GrpUserDTO findGrpUserById(int id) throws Exception {
		Optional<GrpUser> grpuserOptional = grpUserRepository.findById(id);
		if(grpuserOptional.isPresent()) {
			GrpUser results = grpuserOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GrpUser
	 * @param data
	 * @return
	 */
	public GrpUserDTO createGrpUser(GrpUserDTO data) {
		try {
		    GrpUser createdData = data.toEntity();
		    createdData = grpUserRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GrpUser
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GrpUserDTO updateGrpUser(GrpUserDTO data) throws Exception {
		Optional<GrpUser> grpuserOptional = grpUserRepository.findById(data.getGrpUserId());
		if(grpuserOptional.isPresent()) {
		    GrpUser updatedData = data.toEntity();
			updatedData = grpUserRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGrpUserId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GrpUser by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGrpUser(int id) throws Exception {
		Optional<GrpUser> grpuserOptional = grpUserRepository.findById(id);
		if(grpuserOptional.isPresent()) {
			grpUserRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GrpUserDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	public List<GrpUserDTO> findGrpUserByGrpId(int id) throws Exception {
		Iterable<GrpUser> results = grpUserRepository.findGrpUserByGrpId(id);
		Iterator<GrpUser> iter = results.iterator();
		List<GrpUserDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUser item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserDTO> by foreign key : userId
	 * @param userId
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	public List<GrpUserDTO> findGrpUserByUserId(int id) throws Exception {
		Iterable<GrpUser> results = grpUserRepository.findGrpUserByUserId(id);
		Iterator<GrpUser> iter = results.iterator();
		List<GrpUserDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUser item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserDTO> by foreign key : GrpIdAndUserId
	 * @param GrpIdAndUserId
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	public List<GrpUserDTO> findGrpUserByGrpIdAndUserId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<GrpUser> results = grpUserRepository.findGrpUserByGrpIdAndUserId(id0, id1);
		Iterator<GrpUser> iter = results.iterator();
		List<GrpUserDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUser item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
