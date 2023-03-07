package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalCategoriesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalCategories;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalCategoriesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalCategoriesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalCategoriesRepository goalCategoriesRepository;

	/**
	 * get all GoalCategories records
	 * @return
	 * @throws Exception
	 */
	public List<GoalCategoriesDTO> getAllGoalCategories() throws Exception {
		Iterable<GoalCategories> goalcategories = goalCategoriesRepository.findAll();
		Iterator<GoalCategories> goalcategoriess = goalcategories.iterator();
		List<GoalCategoriesDTO> goalcategoriesdto = new ArrayList();
		while(goalcategoriess.hasNext()) {
			GoalCategories item = goalcategoriess.next();
			goalcategoriesdto.add(item.toDTO());
		}
		return goalcategoriesdto;
	}

	/**
	 * get GoalCategories by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalCategoriesDTO findGoalCategoriesById(int id) throws Exception {
		Optional<GoalCategories> goalcategoriesOptional = goalCategoriesRepository.findById(id);
		if(goalcategoriesOptional.isPresent()) {
			GoalCategories results = goalcategoriesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GoalCategories
	 * @param data
	 * @return
	 */
	public GoalCategoriesDTO createGoalCategories(GoalCategoriesDTO data) {
		try {
		    GoalCategories createdData = data.toEntity();
		    createdData = goalCategoriesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalCategories
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalCategoriesDTO updateGoalCategories(GoalCategoriesDTO data) throws Exception {
		Optional<GoalCategories> goalcategoriesOptional = goalCategoriesRepository.findById(data.getGcId());
		if(goalcategoriesOptional.isPresent()) {
		    GoalCategories updatedData = data.toEntity();
			updatedData = goalCategoriesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGcId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GoalCategories by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalCategories(int id) throws Exception {
		Optional<GoalCategories> goalcategoriesOptional = goalCategoriesRepository.findById(id);
		if(goalcategoriesOptional.isPresent()) {
			goalCategoriesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GoalCategoriesDTO> by foreign key : goalTypeId
	 * @param goalTypeId
	 * @return List<GoalCategories>
	 * @throws Exception
	*/
	public List<GoalCategoriesDTO> findGoalCategoriesByGoalTypeId(int id) throws Exception {
		Iterable<GoalCategories> results = goalCategoriesRepository.findGoalCategoriesByGoalTypeId(id);
		Iterator<GoalCategories> iter = results.iterator();
		List<GoalCategoriesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalCategories item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
