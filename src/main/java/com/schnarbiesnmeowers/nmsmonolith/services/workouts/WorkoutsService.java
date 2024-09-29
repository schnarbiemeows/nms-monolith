package com.schnarbiesnmeowers.nmsmonolith.services.workouts;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.schnarbiesnmeowers.nmsmonolith.dtos.utility.GraphWrapperDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.*;
import com.schnarbiesnmeowers.nmsmonolith.pojos.WeightWorkoutType;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutCardioVw;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutSteps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.WeightWorkoutTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutCardioRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutCardioVwRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutStepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.utilities.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.Workouts;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WorkoutsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
	/**
	 * these 3 constants are bad design; they represent the primary keys of the records in the exercise_type table
	 */
	public static final int WEIGHTS = 2;
	public static final int CARDIO = 1;
	public static final int WALKING = 3;

    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WorkoutsRepository workoutsRepository;

	@Autowired
	private WorkoutStepsRepository workoutStepsRepository;

	@Autowired
	private WorkoutCardioVwRepository workoutCardioVwRepository;

	@Autowired
	StepsService stepsService;

	@Autowired
	WorkoutCardioService workoutCardioService;

	@Autowired
	WorkoutLiftService workoutLiftService;

	@Autowired
	LiftSetService liftSetService;

	@Autowired
	private WeightWorkoutTypeRepository weightWorkoutTypeRepository;

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
	public WorkoutWrapperDTO findWorkoutsById(int id) throws Exception {
		WorkoutWrapperDTO returnDTO = new WorkoutWrapperDTO();
		Optional<Workouts> workoutsOptional = workoutsRepository.findById(id);
		if(workoutsOptional.isPresent()) {
			Workouts results = workoutsOptional.get();
			if(results.getExerciseTypeId()==WEIGHTS) {
				returnDTO.setWorkoutType(WEIGHTS);
				WorkoutWeightsFormDTO weightWorkout = new WorkoutWeightsFormDTO();
				weightWorkout.setWorkout(results.toDTO());
				List<WorkoutLiftDTO> workoutLiftEntities = workoutLiftService
						.findWorkoutLiftByWorkoutId(results.getWorkoutId());
				for (WorkoutLiftDTO dto : workoutLiftEntities) {
					List<LiftSetDTO> liftSetByWorkoutLiftId = liftSetService
							.findLiftSetByWorkoutLiftId(dto.getWorkoutLiftId());
					dto.setLiftSetDTO(liftSetByWorkoutLiftId);
				}
				weightWorkout.setWorkoutLifts(workoutLiftEntities);
				WeightWorkoutType weightWorkoutType =
						weightWorkoutTypeRepository.findByWorkoutId(weightWorkout.getWorkout().getWorkoutId());
				weightWorkout.setWeightWorkoutType(weightWorkoutType.getMuscleGroupId());
				returnDTO.setWorkoutWeightsFormDTO(weightWorkout);
			} else if(results.getExerciseTypeId()==WALKING) {
				returnDTO.setWorkoutType(WALKING);
				WorkoutStepsFormDTO stepsWorkout = new WorkoutStepsFormDTO();
				stepsWorkout.setWorkout(results.toDTO());
				StepsDTO steps = stepsService.findStepsByWorkoutId(results.getWorkoutId());
				stepsWorkout.setSteps(steps.getSteps());
				returnDTO.setWorkoutStepsFormDTO(stepsWorkout);
			} else if(results.getExerciseTypeId()==CARDIO) {
				returnDTO.setWorkoutType(CARDIO);
				WorkoutCardioFormDTO cardioWorkout = new WorkoutCardioFormDTO();
				cardioWorkout.setWorkout(results.toDTO());
				WorkoutCardioDTO workoutCardioByWorkoutId = workoutCardioService
						.findWorkoutCardioByWorkoutId(results.getWorkoutId());
				cardioWorkout.setCardioType(workoutCardioByWorkoutId.getCardioTypeId());
				returnDTO.setWorkoutCardioFormDTO(cardioWorkout);
			} else {
				throw new Exception("wrong workout type!");
			}
			return returnDTO;
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
	 * create a new Workout
	 * @param data
	 * @return
	 */
	public WorkoutWrapperDTO createWorkout(WorkoutWrapperDTO data) throws Exception {
		try {
			int workoutType = data.getWorkoutType();
			if(workoutType==WEIGHTS) {
				// weight lifting workout
				WorkoutWeightsFormDTO weightWorkout = data.getWorkoutWeightsFormDTO();
				WorkoutsDTO workout = weightWorkout.getWorkout();
				Workouts workoutEntity = workout.toEntity();
				workoutEntity = workoutsRepository.save(workoutEntity);
				data.getWorkoutWeightsFormDTO().getWorkout().setWorkoutId(workoutEntity.getWorkoutId());
				WeightWorkoutType weightWorkoutType = new WeightWorkoutType(null,
						workoutEntity.getWorkoutId(),
						data.getWorkoutWeightsFormDTO().getWeightWorkoutType());
				weightWorkoutTypeRepository.save(weightWorkoutType);
				List<WorkoutLiftDTO> lifts = weightWorkout.getWorkoutLifts();
				for(WorkoutLiftDTO liftDTO : lifts) {
					liftDTO.setWorkoutId(workoutEntity.getWorkoutId());
					List<LiftSetDTO> liftSetDTOs = liftDTO.getLiftSetDTO();
					liftDTO = workoutLiftService.createWorkoutLift(liftDTO);
					for(LiftSetDTO dto : liftSetDTOs) {
						dto.setWorkoutLiftId(liftDTO.getWorkoutLiftId());
						dto = liftSetService.createLiftSet(dto);
					}
					liftDTO.setLiftSetDTO(liftSetDTOs);
				}
				System.out.println(weightWorkout.toString());
				System.out.println("HERE!");
			} else if(workoutType==WALKING) {
				// walking workout
				WorkoutStepsFormDTO stepWorkout = data.getWorkoutStepsFormDTO();
				WorkoutsDTO workout = stepWorkout.getWorkout();
				Workouts workoutEntity = workout.toEntity();
				workoutEntity = workoutsRepository.save(workoutEntity);
				data.getWorkoutStepsFormDTO().getWorkout().setWorkoutId(workoutEntity.getWorkoutId());
				StepsDTO stepsDTO = new StepsDTO();
				stepsDTO.setWorkoutId(workoutEntity.getWorkoutId());
				stepsDTO.setSteps(stepWorkout.getSteps());
				stepsDTO.setActv("Y");
				stepsService.createSteps(stepsDTO);
				// not sure if I would need the stepsId at any point
			} else if(workoutType==CARDIO) {
				// cardio workout
				WorkoutCardioFormDTO workoutCardioFormDTO = data.getWorkoutCardioFormDTO();
				WorkoutsDTO workout = workoutCardioFormDTO.getWorkout();
				Workouts workoutEntity = workout.toEntity();
				workoutEntity = workoutsRepository.save(workoutEntity);
				data.getWorkoutCardioFormDTO().getWorkout().setWorkoutId(workoutEntity.getWorkoutId());
				WorkoutCardioDTO workoutCardioDTO = new WorkoutCardioDTO(null,workoutEntity.getWorkoutId(),
						workoutCardioFormDTO.getCardioType());
				workoutCardioDTO = workoutCardioService.createWorkoutCardio(workoutCardioDTO);
			} else throw new Exception("wrong workout type!");
		} catch (Exception e) {
			throw e;
		}
		return data;
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
	 * update a Workout
	 * assumption: you cannot change the workout TYPE
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WorkoutWrapperDTO updateWorkout(WorkoutWrapperDTO data) throws Exception {
		Optional<Workouts> workoutsOptional = null;
		int workoutType = data.getWorkoutType();
		try {
			if(workoutType==WEIGHTS) {
				List<WorkoutLiftDTO> previousWorkoutLifts = null;
				List<LiftSetDTO> previousLiftSets = null;
				workoutsOptional = workoutsRepository.findById(data.getWorkoutWeightsFormDTO().getWorkout()
						.getWorkoutId());
				if(workoutsOptional.isPresent()) {
					// get the current list of lifts for this workout, so we can track what needs to be deleted
					previousWorkoutLifts = workoutLiftService
							.findWorkoutLiftByWorkoutId(workoutsOptional.get()
							.getWorkoutId());
					Workouts updatedWorkout = data.getWorkoutWeightsFormDTO().getWorkout().toEntity();
					// save the workout record data
					updatedWorkout = workoutsRepository.save(updatedWorkout);
					// UPDATE THE WEIGHT WORKOUT TYPE
					WeightWorkoutType byWorkoutId =
							weightWorkoutTypeRepository.findByWorkoutId(updatedWorkout.getWorkoutId());
					byWorkoutId.setMuscleGroupId(data.getWorkoutWeightsFormDTO().getWeightWorkoutType());
					weightWorkoutTypeRepository.save(byWorkoutId);
					// 2. upsert any workout_lift records; objects with no primary key would be inserted
					// ( and then lift_set records would need to be created )
					List<WorkoutLiftDTO> workoutLiftDTOS = data.getWorkoutWeightsFormDTO().getWorkoutLifts();
					// update/add existing and new workout_lift records
					for(WorkoutLiftDTO lift : workoutLiftDTOS) {
						boolean newRecord = false;
						if(null!=lift.getWorkoutLiftId()) {
							// gather the current lift_sets for this workout_lift record
							previousLiftSets = liftSetService.findLiftSetByWorkoutLiftId(lift
									.getWorkoutLiftId());
							// update the workout_lift record
							workoutLiftService.updateWorkoutLift(lift);
							// remove it from the previousWorkoutLifts list
							final int tempWorkoutLiftId = lift.getWorkoutLiftId();
							previousWorkoutLifts = previousWorkoutLifts.stream().filter(rec ->
									rec.getWorkoutLiftId() != tempWorkoutLiftId).collect(Collectors.toList());
						} else {
							// if it is a new workout_lift record, then it will not be in the previousWorkoutLifts list
							newRecord = true;
							// we need to store the LiftSetRecords first before saving
							List<LiftSetDTO> liftSetDTOs = lift.getLiftSetDTO();
							lift = workoutLiftService.createWorkoutLift(lift);
							for(LiftSetDTO dto : liftSetDTOs) {
								dto.setWorkoutLiftId(lift.getWorkoutLiftId());
							}
							lift.setLiftSetDTO(liftSetDTOs);
						}
						// update/add lift_set records
						for(LiftSetDTO liftSet : lift.getLiftSetDTO()) {
							if(newRecord) {
								liftSet = liftSetService.createLiftSet(liftSet);
							} else {
								// remember, there could be additional liftSets added onto an already existing workoutLift
								if(null==liftSet.getLiftSetId()) {
									liftSet = liftSetService.createLiftSet(liftSet);
								} else {
									liftSetService.updateLiftSet(liftSet);
									// remove it from the previousLiftSets list
									final int tempLiftSetId = liftSet.getLiftSetId();
									previousLiftSets = previousLiftSets.stream().filter(rec ->
											rec.getLiftSetId() != tempLiftSetId).collect(Collectors.toList());
								}
							}
						}
						// now delete any lift_set records
						for(LiftSetDTO dto : previousLiftSets) {
							liftSetService.deleteLiftSet(dto.getLiftSetId());
						}
					}
					// now delete any workout_lift records that need to be deleted
					for(WorkoutLiftDTO liftsToDelete : previousWorkoutLifts) {
						previousLiftSets = liftSetService.findLiftSetByWorkoutLiftId(liftsToDelete.getWorkoutLiftId());
						for(LiftSetDTO dto : previousLiftSets) {
							liftSetService.deleteLiftSet(dto.getLiftSetId());
						}
						workoutLiftService.deleteWorkoutLift(liftsToDelete.getWorkoutLiftId());
					}
					System.out.println("check that all of the records have primary keys");
//					data = findWorkoutsById(data.getWeightWorkout().getWorkout().getWorkoutId());
				} else {
					throw new ResourceNotFoundException(ID_EQUALS +
							data.getWorkoutWeightsFormDTO().getWorkout().getWorkoutId() + NOT_FOUND);
				}
			} else if(workoutType==WALKING) {
				workoutsOptional = workoutsRepository.findById(data.getWorkoutStepsFormDTO().getWorkout().getWorkoutId());
				if(workoutsOptional.isPresent()) {
					Workouts updatedWorkout = data.getWorkoutStepsFormDTO().getWorkout().toEntity();
					updatedWorkout = workoutsRepository.save(updatedWorkout);
					StepsDTO updatedSteps =  stepsService.findStepsByWorkoutId(updatedWorkout.getWorkoutId());
					if(null!=updatedSteps) {
						updatedSteps.setSteps(data.getWorkoutStepsFormDTO().getSteps());
						stepsService.updateSteps(updatedSteps);
					} else {
						updatedSteps = new StepsDTO(null,updatedWorkout.getWorkoutId(),
								data.getWorkoutStepsFormDTO().getSteps(),"Y");
						updatedSteps = stepsService.createSteps(updatedSteps);
					}
				}
				System.out.println("check that all of the records have primary keys");
				data = findWorkoutsById(data.getWorkoutStepsFormDTO().getWorkout().getWorkoutId());
			} else if(workoutType==CARDIO) {
				workoutsOptional = workoutsRepository.findById(data.getWorkoutCardioFormDTO().getWorkout().getWorkoutId());
				if(workoutsOptional.isPresent()) {
					Workouts updatedWorkout = data.getWorkoutCardioFormDTO().getWorkout().toEntity();
					updatedWorkout = workoutsRepository.save(updatedWorkout);
					WorkoutCardioDTO updatedWorkoutCardio = workoutCardioService
							.findWorkoutCardioByWorkoutId(updatedWorkout.getWorkoutId());
					if(null!=updatedWorkoutCardio) {
						updatedWorkoutCardio.setCardioTypeId(data.getWorkoutCardioFormDTO().getCardioType());
						workoutCardioService.updateWorkoutCardio(updatedWorkoutCardio);
					} else {
						updatedWorkoutCardio = new WorkoutCardioDTO(null,updatedWorkout.getWorkoutId(),
								data.getWorkoutCardioFormDTO().getCardioType());
						updatedWorkoutCardio = workoutCardioService.createWorkoutCardio(updatedWorkoutCardio);
					}
				}
				System.out.println("check that all of the records have primary keys");
				data = findWorkoutsById(data.getWorkoutCardioFormDTO().getWorkout().getWorkoutId());
			} else {
				throw new Exception("wrong workout type!");
			}
		} catch (Exception e) {
			throw e;
		}
		return data;
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
	 * delete a Workout by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWorkout(int id, int type) throws Exception {
		Optional<Workouts> workoutsOptional = workoutsRepository.findById(id);
		if (workoutsOptional.isPresent()) {
			// first have to delete other records
			if (type == WEIGHTS) {
				List<WorkoutLiftDTO> workoutLiftDTOS = workoutLiftService.findWorkoutLiftByWorkoutId(id);
				for (WorkoutLiftDTO lift : workoutLiftDTOS) {
					List<LiftSetDTO> liftSetDTOs = liftSetService.findLiftSetByWorkoutLiftId(lift.getWorkoutLiftId());
					for (LiftSetDTO dto : liftSetDTOs) {
						liftSetService.deleteLiftSet(dto.getLiftSetId());
					}
					workoutLiftService.deleteWorkoutLift(lift.getWorkoutLiftId());
				}
				Workouts workouts = workoutsOptional.get();
				WeightWorkoutType weightWorkoutType = weightWorkoutTypeRepository
						.findByWorkoutId(workouts.getWorkoutId());
				weightWorkoutTypeRepository.deleteById(weightWorkoutType.getWeightWorkoutTypeId());
				workoutsRepository.deleteById(id);
				return "Successfully Deleted";
			} else if (type == WALKING) {
				StepsDTO stepsToDelete = stepsService.findStepsByWorkoutId(id);
				if (null != stepsToDelete) {
					stepsService.deleteSteps(stepsToDelete.getStepId());
				}
				workoutsRepository.deleteById(id);
				return "Successfully Deleted";
			} else if (type == CARDIO) {
				WorkoutCardioDTO cardioToDelete = workoutCardioService.findWorkoutCardioByWorkoutId(id);
				if (null != cardioToDelete) {
					workoutCardioService.deleteWorkoutCardio(cardioToDelete.getWorkoutCardioId());
				}
				// then delete workout record
				workoutsRepository.deleteById(id);
				return "Successfully Deleted";
			} else {
				throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
			}
		}
		return null;
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : userId
	 * @param id
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

	public List<WorkoutsDTO> findWorkoutsByUserIdAndDate(int id0, String id1) {
		Iterable<Workouts> results = workoutsRepository.findWorkoutsByUserIdAndDate(id0, id1);
		Iterator<Workouts> iter = results.iterator();
		List<WorkoutsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Workouts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public GraphWrapperDTO findWorkoutStepsByUserIdAndDate(int userId, int daysBack) {
		List<LocalDate> dateList = DateUtil.getDateList(daysBack);
		int count = 0;
		LocalDate earliestDate = dateList.get(0);
		Iterable<WorkoutSteps> steps = workoutStepsRepository.findWorkoutStepsByUserIdAndDate(userId,earliestDate);
		Iterator<WorkoutSteps> iter = steps.iterator();
		List<WorkoutStepsDTO> resultsdto = new ArrayList();
		GraphWrapperDTO returnDto = new GraphWrapperDTO();
		while(iter.hasNext()) {
			count++;
			WorkoutSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		List<LocalDate> missingDatesList = DateUtil.getDateList(dateList.size()-count);
		for(LocalDate date : missingDatesList) {
			WorkoutSteps item = new WorkoutSteps(null,userId,java.sql.Date.valueOf(date),0);
			resultsdto.add(item.toDTO());
		}
		returnDto.setData(resultsdto);
		returnDto.setDateRange(dateList);
		return returnDto;
	}

	public GraphWrapperDTO findCardioWorkoutsByUserIdAndDate(int userId, String date) {
		Iterable<WorkoutCardioVw> steps = workoutCardioVwRepository.findWorkoutCardioByUserIdAndDate(userId,date);
		Iterator<WorkoutCardioVw> iter = steps.iterator();
		List<WorkoutCardioVwDTO> resultsdto = new ArrayList();
		GraphWrapperDTO returnDto = new GraphWrapperDTO();
		while(iter.hasNext()) {
			WorkoutCardioVw item = iter.next();
			resultsdto.add(item.toDTO());
		}
		returnDto.setData(resultsdto);
		List<LocalDate> dateList = DateUtil.getDateList(LocalDate.parse(date));
		returnDto.setDateRange(dateList);
		return returnDto;
	}
}
