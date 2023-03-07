package com.schnarbiesnmeowers.nmsmonolith.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/goalcategories")
public class GoalCategoriesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalCategoriesService businessService;

	/**
	 * get all GoalCategories records
	 * @return Iterable<GoalCategories>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GoalCategoriesDTO>> getAllGoalCategories() throws Exception {
		List<GoalCategoriesDTO> goalcategories = businessService.getAllGoalCategories();
		return ResponseEntity.status(HttpStatus.OK).body(goalcategories);
	}

	/**
	 * get GoalCategories by primary key
	 * @param id
	 * @return GoalCategories
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GoalCategoriesDTO> findGoalCategoriesById(@PathVariable int id) throws Exception {
		GoalCategoriesDTO results = businessService.findGoalCategoriesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GoalCategories
	 * @param GoalCategoriesDTO
	 * @return GoalCategories
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GoalCategoriesDTO> createGoalCategories(@Valid @RequestBody GoalCategoriesDTO data) throws Exception {
		try {
		    GoalCategoriesDTO createdData = businessService.createGoalCategories(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalCategories
	 * @param GoalCategoriesDTO
	 * @return GoalCategories
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GoalCategoriesDTO> updateGoalCategories(@Valid @RequestBody GoalCategoriesDTO data) throws Exception {
		GoalCategoriesDTO updatedData = businessService.updateGoalCategories(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GoalCategories by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGoalCategories(@PathVariable int id) throws Exception {
		businessService.deleteGoalCategories(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GoalCategoriesDTO> by foreign key : goalTypeId
	 * @param goalTypeId
	 * @return List<GoalCategories>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGoalTypeId/{id}")
	public ResponseEntity<List<GoalCategoriesDTO>> findGoalCategoriesByGoalTypeId(@PathVariable int id) throws Exception {
		List<GoalCategoriesDTO> results = businessService.findGoalCategoriesByGoalTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
