package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftLiftEqpDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftLiftEqpServiceTest {


	/**
	 * get all LiftLiftEqp records
	 * @return
	 * @throws Exception
	 */
	public List<LiftLiftEqpDTO> getAllLiftLiftEqp() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<LiftLiftEqpDTO> liftlifteqpDTO = new ArrayList<LiftLiftEqpDTO>();
		return liftlifteqpDTO;
	}

	/**
	 * get LiftLiftEqp by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftLiftEqpDTO findLiftLiftEqpById(int id) throws Exception {
		return new LiftLiftEqpDTO();
	}

	/**
	 * create a new LiftLiftEqp
	 * @param data
	 * @return
	 */
	public LiftLiftEqpDTO createLiftLiftEqp(LiftLiftEqpDTO data) {
        data.setLiftLiftEqpId(1);
        return data;
	}

	/**
	 * update a LiftLiftEqp
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftLiftEqpDTO updateLiftLiftEqp(LiftLiftEqpDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a LiftLiftEqp by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLiftLiftEqp(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	public List<LiftLiftEqpDTO> findLiftLiftEqpByLiftId(int id) throws Exception {
		List<LiftLiftEqpDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : liftEquipId
	 * @param liftEquipId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	public List<LiftLiftEqpDTO> findLiftLiftEqpByLiftEquipId(int id) throws Exception {
		List<LiftLiftEqpDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : LiftIdAndLiftEquipId
	 * @param LiftIdAndLiftEquipId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	public List<LiftLiftEqpDTO> findLiftLiftEqpByLiftIdAndLiftEquipId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<LiftLiftEqpDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
