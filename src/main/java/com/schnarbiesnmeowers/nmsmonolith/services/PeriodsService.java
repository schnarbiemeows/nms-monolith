package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Periods;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodsRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PeriodsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PeriodsRepository periodsRepository;

	/**
	 * get all Periods records
	 * @return
	 * @throws Exception
	 */
	public List<PeriodsDTO> getAllPeriods() throws Exception {
		Iterable<Periods> periods = periodsRepository.findAll();
		Iterator<Periods> periodss = periods.iterator();
		List<PeriodsDTO> periodsdto = new ArrayList();
		while(periodss.hasNext()) {
			Periods item = periodss.next();
			periodsdto.add(item.toDTO());
		}
		return periodsdto;
	}

	/**
	 * get Periods by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PeriodsDTO findPeriodsById(int id) throws Exception {
		Optional<Periods> periodsOptional = periodsRepository.findById(id);
		if(periodsOptional.isPresent()) {
			Periods results = periodsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Periods
	 * @param data
	 * @return
	 */
	public PeriodsDTO createPeriods(PeriodsDTO data) {
		try {
		    Periods createdData = data.toEntity();
		    createdData = periodsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Periods
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PeriodsDTO updatePeriods(PeriodsDTO data) throws Exception {
		Optional<Periods> periodsOptional = periodsRepository.findById(data.getPeriodId());
		if(periodsOptional.isPresent()) {
		    Periods updatedData = data.toEntity();
			updatedData = periodsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getPeriodId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Periods by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePeriods(int id) throws Exception {
		Optional<Periods> periodsOptional = periodsRepository.findById(id);
		if(periodsOptional.isPresent()) {
			periodsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<PeriodsDTO> by foreign key : periodTypeId
	 * @param periodTypeId
	 * @return List<Periods>
	 * @throws Exception
	*/
	public List<PeriodsDTO> findPeriodsByPeriodTypeId(int id) throws Exception {
		Iterable<Periods> results = periodsRepository.findPeriodsByPeriodTypeId(id);
		Iterator<Periods> iter = results.iterator();
		List<PeriodsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Periods item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
