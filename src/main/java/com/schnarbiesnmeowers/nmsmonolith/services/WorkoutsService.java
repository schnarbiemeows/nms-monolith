package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.WorkoutsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Workouts;
import com.schnarbiesnmeowers.nmsmonolith.repositories.WorkoutsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WorkoutsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WorkoutsRepository workoutsRepository;

	/**
	 * get all Workouts records
	 * @return
	 * @throws Exception
	 */
	public List<WorkoutsDTO> getAllWorkouts() throws Exception {
		Iterable<Workouts> workouts = workoutsRepository.findAll();
		Iterator<Workouts> workoutss = workouts.iterator();
		List<WorkoutsDTO> workoutsdto = new ArrayList();
		while(workoutss.hasNext()) {
			Workouts item = workoutss.next();
			workoutsdto.add(item.toDTO());
		}
		return workoutsdto;
	}

	/**
	 * get Workouts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WorkoutsDTO findWorkoutsById(int id) throws Exception {
		Optional<Workouts> workoutsOptional = workoutsRepository.findById(id);
		if(workoutsOptional.isPresent()) {
			Workouts results = workoutsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Workouts
	 * @param data
	 * @return
	 */
	public WorkoutsDTO createWorkouts(WorkoutsDTO data) {
		try {
		    Workouts createdData = data.toEntity();
		    createdData = workoutsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Workouts
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WorkoutsDTO updateWorkouts(WorkoutsDTO data) throws Exception {
		Optional<Workouts> workoutsOptional = workoutsRepository.findById(data.getWorkoutId());
		if(workoutsOptional.isPresent()) {
		    Workouts updatedData = data.toEntity();
			updatedData = workoutsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getWorkoutId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Workouts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWorkouts(int id) throws Exception {
		Optional<Workouts> workoutsOptional = workoutsRepository.findById(id);
		if(workoutsOptional.isPresent()) {
			workoutsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : userId
	 * @param userId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	public List<WorkoutsDTO> findWorkoutsByUserId(int id) throws Exception {
		Iterable<Workouts> results = workoutsRepository.findWorkoutsByUserId(id);
		Iterator<Workouts> iter = results.iterator();
		List<WorkoutsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Workouts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : exerciseTypeId
	 * @param exerciseTypeId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	public List<WorkoutsDTO> findWorkoutsByExerciseTypeId(int id) throws Exception {
		Iterable<Workouts> results = workoutsRepository.findWorkoutsByExerciseTypeId(id);
		Iterator<Workouts> iter = results.iterator();
		List<WorkoutsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Workouts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : UserIdAndExerciseTypeId
	 * @param UserIdAndExerciseTypeId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	public List<WorkoutsDTO> findWorkoutsByUserIdAndExerciseTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<Workouts> results = workoutsRepository.findWorkoutsByUserIdAndExerciseTypeId(id0, id1);
		Iterator<Workouts> iter = results.iterator();
		List<WorkoutsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Workouts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
