package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftLiftEqpDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftLiftEqp;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftLiftEqpRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftLiftEqpService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftLiftEqpRepository liftLiftEqpRepository;

	/**
	 * get all LiftLiftEqp records
	 * @return
	 * @throws Exception
	 */
	public List<LiftLiftEqpDTO> getAllLiftLiftEqp() throws Exception {
		Iterable<LiftLiftEqp> liftlifteqp = liftLiftEqpRepository.findAll();
		Iterator<LiftLiftEqp> liftlifteqps = liftlifteqp.iterator();
		List<LiftLiftEqpDTO> liftlifteqpdto = new ArrayList();
		while(liftlifteqps.hasNext()) {
			LiftLiftEqp item = liftlifteqps.next();
			liftlifteqpdto.add(item.toDTO());
		}
		return liftlifteqpdto;
	}

	/**
	 * get LiftLiftEqp by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftLiftEqpDTO findLiftLiftEqpById(int id) throws Exception {
		Optional<LiftLiftEqp> liftlifteqpOptional = liftLiftEqpRepository.findById(id);
		if(liftlifteqpOptional.isPresent()) {
			LiftLiftEqp results = liftlifteqpOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LiftLiftEqp
	 * @param data
	 * @return
	 */
	public LiftLiftEqpDTO createLiftLiftEqp(LiftLiftEqpDTO data) {
		try {
		    LiftLiftEqp createdData = data.toEntity();
		    createdData = liftLiftEqpRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftLiftEqp
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftLiftEqpDTO updateLiftLiftEqp(LiftLiftEqpDTO data) throws Exception {
		Optional<LiftLiftEqp> liftlifteqpOptional = liftLiftEqpRepository.findById(data.getLiftLiftEqpId());
		if(liftlifteqpOptional.isPresent()) {
		    LiftLiftEqp updatedData = data.toEntity();
			updatedData = liftLiftEqpRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getLiftLiftEqpId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LiftLiftEqp by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLiftLiftEqp(int id) throws Exception {
		Optional<LiftLiftEqp> liftlifteqpOptional = liftLiftEqpRepository.findById(id);
		if(liftlifteqpOptional.isPresent()) {
			liftLiftEqpRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	public List<LiftLiftEqpDTO> findLiftLiftEqpByLiftId(int id) throws Exception {
		Iterable<LiftLiftEqp> results = liftLiftEqpRepository.findLiftLiftEqpByLiftId(id);
		Iterator<LiftLiftEqp> iter = results.iterator();
		List<LiftLiftEqpDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftLiftEqp item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : liftEquipId
	 * @param liftEquipId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	public List<LiftLiftEqpDTO> findLiftLiftEqpByLiftEquipId(int id) throws Exception {
		Iterable<LiftLiftEqp> results = liftLiftEqpRepository.findLiftLiftEqpByLiftEquipId(id);
		Iterator<LiftLiftEqp> iter = results.iterator();
		List<LiftLiftEqpDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftLiftEqp item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : LiftIdAndLiftEquipId
	 * @param LiftIdAndLiftEquipId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	public List<LiftLiftEqpDTO> findLiftLiftEqpByLiftIdAndLiftEquipId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<LiftLiftEqp> results = liftLiftEqpRepository.findLiftLiftEqpByLiftIdAndLiftEquipId(id0, id1);
		Iterator<LiftLiftEqp> iter = results.iterator();
		List<LiftLiftEqpDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftLiftEqp item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
