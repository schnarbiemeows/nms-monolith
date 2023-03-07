package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietaryExclusionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDietaryExclusions;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietaryExclusionsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietaryExclusionsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietaryExclusionsRepository dailyDietaryExclusionsRepository;

	/**
	 * get all DailyDietaryExclusions records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietaryExclusionsDTO> getAllDailyDietaryExclusions() throws Exception {
		Iterable<DailyDietaryExclusions> dailydietaryexclusions = dailyDietaryExclusionsRepository.findAll();
		Iterator<DailyDietaryExclusions> dailydietaryexclusionss = dailydietaryexclusions.iterator();
		List<DailyDietaryExclusionsDTO> dailydietaryexclusionsdto = new ArrayList();
		while(dailydietaryexclusionss.hasNext()) {
			DailyDietaryExclusions item = dailydietaryexclusionss.next();
			dailydietaryexclusionsdto.add(item.toDTO());
		}
		return dailydietaryexclusionsdto;
	}

	/**
	 * get DailyDietaryExclusions by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietaryExclusionsDTO findDailyDietaryExclusionsById(int id) throws Exception {
		Optional<DailyDietaryExclusions> dailydietaryexclusionsOptional = dailyDietaryExclusionsRepository.findById(id);
		if(dailydietaryexclusionsOptional.isPresent()) {
			DailyDietaryExclusions results = dailydietaryexclusionsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new DailyDietaryExclusions
	 * @param data
	 * @return
	 */
	public DailyDietaryExclusionsDTO createDailyDietaryExclusions(DailyDietaryExclusionsDTO data) {
		try {
		    DailyDietaryExclusions createdData = data.toEntity();
		    createdData = dailyDietaryExclusionsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDietaryExclusions
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietaryExclusionsDTO updateDailyDietaryExclusions(DailyDietaryExclusionsDTO data) throws Exception {
		Optional<DailyDietaryExclusions> dailydietaryexclusionsOptional =
				dailyDietaryExclusionsRepository.findById(data.getDailyDietaryExclusionId());
		if(dailydietaryexclusionsOptional.isPresent()) {
		    DailyDietaryExclusions updatedData = data.toEntity();
			updatedData = dailyDietaryExclusionsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getDailyDietaryExclusionId() + NOT_FOUND);
		}
	}

	/**
	 * delete a DailyDietaryExclusions by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietaryExclusions(int id) throws Exception {
		Optional<DailyDietaryExclusions> dailydietaryexclusionsOptional = dailyDietaryExclusionsRepository.findById(id);
		if(dailydietaryexclusionsOptional.isPresent()) {
			dailyDietaryExclusionsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 *
	 * @param id
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietaryExclusions(int id,Date date) throws Exception {
		Optional<DailyDietaryExclusions> dailydietaryexclusionsOptional =
				dailyDietaryExclusionsRepository.findDailyDietaryExclusionsByUserIdAndDate(id,date);
		if(dailydietaryexclusionsOptional.isPresent()) {
			DailyDietaryExclusions exclusion = dailydietaryexclusionsOptional.get();
			dailyDietaryExclusionsRepository.deleteById(exclusion.getDailyDietaryExclusionId());
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<DailyDietaryExclusionsDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietaryExclusions>
	 * @throws Exception
	*/
	public List<DailyDietaryExclusionsDTO> findDailyDietaryExclusionsByUserId(int id) throws Exception {
		Iterable<DailyDietaryExclusions> results = dailyDietaryExclusionsRepository.findDailyDietaryExclusionsByUserId(id);
		Iterator<DailyDietaryExclusions> iter = results.iterator();
		List<DailyDietaryExclusionsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDietaryExclusions item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public boolean hasExclusion(int id, Date date) throws Exception {
		Optional<DailyDietaryExclusions> exclusion =
				dailyDietaryExclusionsRepository.findDailyDietaryExclusionsByUserIdAndDate(id,date);
		if(exclusion.isPresent()) {
			return true;
		}
		return false;
	}


}