package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftEquipDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftEquipServiceTest {


	/**
	 * get all LiftEquip records
	 * @return
	 * @throws Exception
	 */
	public List<LiftEquipDTO> getAllLiftEquip() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<LiftEquipDTO> liftequipDTO = new ArrayList<LiftEquipDTO>();
		return liftequipDTO;
	}

	/**
	 * get LiftEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftEquipDTO findLiftEquipById(int id) throws Exception {
		return new LiftEquipDTO();
	}

	/**
	 * create a new LiftEquip
	 * @param data
	 * @return
	 */
	public LiftEquipDTO createLiftEquip(LiftEquipDTO data) {
        data.setLiftEquipId(1);
        return data;
	}

	/**
	 * update a LiftEquip
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftEquipDTO updateLiftEquip(LiftEquipDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a LiftEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLiftEquip(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<LiftEquipDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<LiftEquip>
	 * @throws Exception
	*/
	public List<LiftEquipDTO> findLiftEquipByImageLoc(int id) throws Exception {
		List<LiftEquipDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
