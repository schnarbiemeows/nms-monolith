package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DietaryTemplatesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DietaryTemplates;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DietaryTemplatesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DietaryTemplatesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DietaryTemplatesRepository dietaryTemplatesRepository;

	/**
	 * get all DietaryTemplates records
	 * @return
	 * @throws Exception
	 */
	public List<DietaryTemplatesDTO> getAllDietaryTemplates() throws Exception {
		Iterable<DietaryTemplates> dietarytemplates = dietaryTemplatesRepository.findAll();
		Iterator<DietaryTemplates> dietarytemplatess = dietarytemplates.iterator();
		List<DietaryTemplatesDTO> dietarytemplatesdto = new ArrayList();
		while(dietarytemplatess.hasNext()) {
			DietaryTemplates item = dietarytemplatess.next();
			dietarytemplatesdto.add(item.toDTO());
		}
		return dietarytemplatesdto;
	}

	/**
	 * get DietaryTemplates by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DietaryTemplatesDTO findDietaryTemplatesById(int id) throws Exception {
		Optional<DietaryTemplates> dietarytemplatesOptional = dietaryTemplatesRepository.findById(id);
		if(dietarytemplatesOptional.isPresent()) {
			DietaryTemplates results = dietarytemplatesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new DietaryTemplates
	 * @param data
	 * @return
	 */
	public DietaryTemplatesDTO createDietaryTemplates(DietaryTemplatesDTO data) {
		try {
		    DietaryTemplates createdData = data.toEntity();
		    createdData = dietaryTemplatesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DietaryTemplates
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DietaryTemplatesDTO updateDietaryTemplates(DietaryTemplatesDTO data) throws Exception {
		Optional<DietaryTemplates> dietarytemplatesOptional = dietaryTemplatesRepository.findById(data.getDietaryTemplateId());
		if(dietarytemplatesOptional.isPresent()) {
		    DietaryTemplates updatedData = data.toEntity();
			updatedData = dietaryTemplatesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getDietaryTemplateId() + NOT_FOUND);
		}
	}

	/**
	 * delete a DietaryTemplates by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDietaryTemplates(int id) throws Exception {
		Optional<DietaryTemplates> dietarytemplatesOptional = dietaryTemplatesRepository.findById(id);
		if(dietarytemplatesOptional.isPresent()) {
			dietaryTemplatesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<DietaryTemplatesDTO> by foreign key : userId
	 * @param id
	 * @return List<DietaryTemplates>
	 * @throws Exception
	*/
	public List<DietaryTemplatesDTO> findDietaryTemplatesByUserId(int id) throws Exception {
		Iterable<DietaryTemplates> results = dietaryTemplatesRepository.findDietaryTemplatesByUserId(id);
		Iterator<DietaryTemplates> iter = results.iterator();
		List<DietaryTemplatesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DietaryTemplates item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 *
	 * @param userId
	 * @param calendarDate
	 * @return
	 * @throws Exception
	 */
	public List<DietaryTemplatesDTO> findDietaryTemplatesByUserIdAndCalendarDate(int userId, Date calendarDate) throws Exception {
		Iterable<DietaryTemplates> results =
				dietaryTemplatesRepository.findDietaryTemplatesByUserIdAndCalendarDate(userId,calendarDate);
		Iterator<DietaryTemplates> iter = results.iterator();
		List<DietaryTemplatesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DietaryTemplates item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}
}
