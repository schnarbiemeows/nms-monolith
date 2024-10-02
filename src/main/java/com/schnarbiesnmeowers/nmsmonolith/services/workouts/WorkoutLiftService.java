package com.schnarbiesnmeowers.nmsmonolith.services.workouts;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutLift;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutLiftDTO;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutLiftRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WorkoutLiftService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WorkoutLiftRepository workoutLiftRepository;

	/**
	 * get all WorkoutLift records
	 * @return
	 * @throws Exception
	 */
	public List<WorkoutLiftDTO> getAllWorkoutLift() throws Exception {
		Iterable<WorkoutLift> WorkoutLift = workoutLiftRepository.findAll();
		Iterator<WorkoutLift> WorkoutLifts = WorkoutLift.iterator();
		List<WorkoutLiftDTO> WorkoutLiftdto = new ArrayList();
		while(WorkoutLifts.hasNext()) {
			WorkoutLift item = WorkoutLifts.next();
			WorkoutLiftdto.add(item.toDTO());
		}
		return WorkoutLiftdto;
	}

	/**
	 * get WorkoutLift by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WorkoutLiftDTO findWorkoutLiftById(int id) throws Exception {
		Optional<WorkoutLift> WorkoutLiftOptional = workoutLiftRepository.findById(id);
		if(WorkoutLiftOptional.isPresent()) {
			WorkoutLift results = WorkoutLiftOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new WorkoutLift
	 * @param data
	 * @return
	 */
	public WorkoutLiftDTO createWorkoutLift(WorkoutLiftDTO data) {
		try {
		    WorkoutLift createdData = data.toEntity();
		    createdData = workoutLiftRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WorkoutLift
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WorkoutLiftDTO updateWorkoutLift(WorkoutLiftDTO data) throws Exception {
		Optional<WorkoutLift> WorkoutLiftOptional = workoutLiftRepository.findById(data.getWorkoutLiftId());
		if(WorkoutLiftOptional.isPresent()) {
		    WorkoutLift updatedData = data.toEntity();
			updatedData = workoutLiftRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getWorkoutLiftId() + NOT_FOUND);
		}
	}

	/**
	 * delete a WorkoutLift by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWorkoutLift(int id) throws Exception {
		Optional<WorkoutLift> WorkoutLiftOptional = workoutLiftRepository.findById(id);
		if(WorkoutLiftOptional.isPresent()) {
			workoutLiftRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<WorkoutLiftDTO> by foreign key : workoutId
	 * @param id
	 * @return List<WorkoutLift>
	 * @throws Exception
	*/
	public List<WorkoutLiftDTO> findWorkoutLiftByWorkoutId(int id) throws Exception {
		Iterable<WorkoutLift> results = workoutLiftRepository.findWorkoutLiftByWorkoutId(id);
		Iterator<WorkoutLift> iter = results.iterator();
		List<WorkoutLiftDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			WorkoutLift item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<WorkoutLiftDTO> by foreign key : liftId
	 * @param id
	 * @return List<WorkoutLift>
	 * @throws Exception
	*/
	public List<WorkoutLiftDTO> findWorkoutLiftByLiftId(int id) throws Exception {
		Iterable<WorkoutLift> results = workoutLiftRepository.findWorkoutLiftByLiftId(id);
		Iterator<WorkoutLift> iter = results.iterator();
		List<WorkoutLiftDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			WorkoutLift item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<WorkoutLiftDTO> by foreign key : WorkoutIdAndLiftId
	 * @param id0
	 * @return List<WorkoutLift>
	 * @throws Exception
	*/
	public List<WorkoutLiftDTO> findWorkoutLiftByWorkoutIdAndLiftId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		Iterable<WorkoutLift> results = workoutLiftRepository.findWorkoutLiftByWorkoutIdAndLiftId(id0, id1);
		Iterator<WorkoutLift> iter = results.iterator();
		List<WorkoutLiftDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			WorkoutLift item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
