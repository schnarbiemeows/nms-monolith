package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodExtDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PeriodExtServiceTest {


	/**
	 * get all PeriodExt records
	 * @return
	 * @throws Exception
	 */
	public List<PeriodExtDTO> getAllPeriodExt() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<PeriodExtDTO> periodextDTO = new ArrayList<PeriodExtDTO>();
		return periodextDTO;
	}

	/**
	 * get PeriodExt by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PeriodExtDTO findPeriodExtById(int id) throws Exception {
		return new PeriodExtDTO();
	}

	/**
	 * create a new PeriodExt
	 * @param data
	 * @return
	 */
	public PeriodExtDTO createPeriodExt(PeriodExtDTO data) {
        data.setPeriodExtId(1);
        return data;
	}

	/**
	 * update a PeriodExt
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PeriodExtDTO updatePeriodExt(PeriodExtDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a PeriodExt by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePeriodExt(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<PeriodExtDTO> by foreign key : periodId
	 * @param id
	 * @return List<PeriodExt>
	 * @throws Exception
	*/
	public List<PeriodExtDTO> findPeriodExtByPeriodId(int id) throws Exception {
		List<PeriodExtDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
