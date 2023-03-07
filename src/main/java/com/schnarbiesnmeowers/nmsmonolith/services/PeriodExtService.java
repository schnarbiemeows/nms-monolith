package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodExtDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.PeriodExt;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodExtRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PeriodExtService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PeriodExtRepository periodExtRepository;

	/**
	 * get all PeriodExt records
	 * @return
	 * @throws Exception
	 */
	public List<PeriodExtDTO> getAllPeriodExt() throws Exception {
		Iterable<PeriodExt> periodext = periodExtRepository.findAll();
		Iterator<PeriodExt> periodexts = periodext.iterator();
		List<PeriodExtDTO> periodextdto = new ArrayList();
		while(periodexts.hasNext()) {
			PeriodExt item = periodexts.next();
			periodextdto.add(item.toDTO());
		}
		return periodextdto;
	}

	/**
	 * get PeriodExt by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PeriodExtDTO findPeriodExtById(int id) throws Exception {
		Optional<PeriodExt> periodextOptional = periodExtRepository.findById(id);
		if(periodextOptional.isPresent()) {
			PeriodExt results = periodextOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new PeriodExt
	 * @param data
	 * @return
	 */
	public PeriodExtDTO createPeriodExt(PeriodExtDTO data) {
		try {
		    PeriodExt createdData = data.toEntity();
		    createdData = periodExtRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PeriodExt
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PeriodExtDTO updatePeriodExt(PeriodExtDTO data) throws Exception {
		Optional<PeriodExt> periodextOptional = periodExtRepository.findById(data.getPeriodExtId());
		if(periodextOptional.isPresent()) {
		    PeriodExt updatedData = data.toEntity();
			updatedData = periodExtRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getPeriodExtId() + NOT_FOUND);
		}
	}

	/**
	 * delete a PeriodExt by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePeriodExt(int id) throws Exception {
		Optional<PeriodExt> periodextOptional = periodExtRepository.findById(id);
		if(periodextOptional.isPresent()) {
			periodExtRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<PeriodExtDTO> by foreign key : periodId
	 * @param periodId
	 * @return List<PeriodExt>
	 * @throws Exception
	*/
	public List<PeriodExtDTO> findPeriodExtByPeriodId(int id) throws Exception {
		Iterable<PeriodExt> results = periodExtRepository.findPeriodExtByPeriodId(id);
		Iterator<PeriodExt> iter = results.iterator();
		List<PeriodExtDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			PeriodExt item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
