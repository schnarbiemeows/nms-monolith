package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftEquip;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftEquipRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftEquipService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftEquipRepository liftEquipRepository;

	/**
	 * get all LiftEquip records
	 * @return
	 * @throws Exception
	 */
	public List<LiftEquipDTO> getAllLiftEquip() throws Exception {
		Iterable<LiftEquip> liftequip = liftEquipRepository.findAll();
		Iterator<LiftEquip> liftequips = liftequip.iterator();
		List<LiftEquipDTO> liftequipdto = new ArrayList();
		while(liftequips.hasNext()) {
			LiftEquip item = liftequips.next();
			liftequipdto.add(item.toDTO());
		}
		return liftequipdto;
	}

	/**
	 * get LiftEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftEquipDTO findLiftEquipById(int id) throws Exception {
		Optional<LiftEquip> liftequipOptional = liftEquipRepository.findById(id);
		if(liftequipOptional.isPresent()) {
			LiftEquip results = liftequipOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LiftEquip
	 * @param data
	 * @return
	 */
	public LiftEquipDTO createLiftEquip(LiftEquipDTO data) {
		try {
		    LiftEquip createdData = data.toEntity();
		    createdData = liftEquipRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftEquip
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftEquipDTO updateLiftEquip(LiftEquipDTO data) throws Exception {
		Optional<LiftEquip> liftequipOptional = liftEquipRepository.findById(data.getLiftEquipId());
		if(liftequipOptional.isPresent()) {
		    LiftEquip updatedData = data.toEntity();
			updatedData = liftEquipRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getLiftEquipId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LiftEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLiftEquip(int id) throws Exception {
		Optional<LiftEquip> liftequipOptional = liftEquipRepository.findById(id);
		if(liftequipOptional.isPresent()) {
			liftEquipRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<LiftEquipDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<LiftEquip>
	 * @throws Exception
	*/
	public List<LiftEquipDTO> findLiftEquipByImageLoc(int id) throws Exception {
		Iterable<LiftEquip> results = liftEquipRepository.findLiftEquipByImageLoc(id);
		Iterator<LiftEquip> iter = results.iterator();
		List<LiftEquipDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftEquip item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
