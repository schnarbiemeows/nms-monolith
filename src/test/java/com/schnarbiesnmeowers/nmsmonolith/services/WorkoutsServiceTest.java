package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.*;
import com.schnarbiesnmeowers.nmsmonolith.repositories.WeightWorkoutTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class WorkoutsServiceTest {

    @Mock
    private WorkoutsRepository workoutsRepository;

    @Mock
    StepsService stepsService;

    @Mock
    WorkoutCardioService workoutCardioService;

    @Mock
    WorkoutLiftService workoutLiftService;

    @Mock
    LiftSetService liftSetService;

    @Mock
    private WeightWorkoutTypeRepository weightWorkoutTypeRepository;

    @InjectMocks
    private WorkoutsService workoutsService;

    private Workouts workouts;
    private WorkoutsDTO workoutsDTO;

    @BeforeEach
    void setUp() {
        workouts = generateRandomWorkoutsEntity();
        workoutsDTO = generateRandomWorkouts();
    }

    @Test
    void testGetAllWorkouts() throws Exception {
        when(workoutsRepository.findAll()).thenReturn(Collections.singletonList(workouts));

        List<WorkoutsDTO> result = workoutsService.getAllWorkouts();

        assertEquals(1, result.size());
    }

    @Test
    void testFindWorkoutsById_option1() throws Exception {
        workouts.setExerciseTypeId(1);
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.of(workouts));
        when(workoutCardioService
                .findWorkoutCardioByWorkoutId(anyInt()))
                .thenReturn(new WorkoutCardioDTO());
        WorkoutWrapperDTO result = workoutsService.findWorkoutsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindWorkoutsById_option2() throws Exception {
        workouts.setExerciseTypeId(2);
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.of(workouts));
        when(workoutLiftService
                .findWorkoutLiftByWorkoutId(anyInt()))
                .thenReturn(new ArrayList<>());
        when(weightWorkoutTypeRepository
                .findByWorkoutId(anyInt()))
                .thenReturn(new WeightWorkoutType());
        WorkoutWrapperDTO result = workoutsService.findWorkoutsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindWorkoutsById_option3() throws Exception {
        workouts.setExerciseTypeId(3);
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.of(workouts));
        when(stepsService.findStepsByWorkoutId(anyInt()))
                .thenReturn(new StepsDTO());
        WorkoutWrapperDTO result = workoutsService.findWorkoutsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindWorkoutsById_NotFound() {
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutsService.findWorkoutsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateWorkouts() {
        when(workoutsRepository.save(any(Workouts.class))).thenReturn(workouts);

        WorkoutsDTO result = workoutsService.createWorkouts(workoutsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWorkouts_Found() throws Exception {
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.of(workouts));
        when(workoutsRepository.save(any(Workouts.class))).thenReturn(workouts);

        WorkoutsDTO result = workoutsService.updateWorkouts(workoutsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWorkouts_NotFound() {
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutsService.updateWorkouts(workoutsDTO);
        });

        assertEquals("id = " + workoutsDTO.getWorkoutId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteWorkouts_Found() throws Exception {
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.of(workouts));
        doNothing().when(workoutsRepository).deleteById(anyInt());

        String result = workoutsService.deleteWorkouts(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteWorkouts_NotFound() {
        when(workoutsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutsService.deleteWorkouts(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static WorkoutsDTO generateRandomWorkouts() {
		WorkoutsDTO record = new WorkoutsDTO();
		record.setWorkoutId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomLocalDate());
		record.setExerciseTypeId(Randomizer.randomInt(1000));
		record.setDuration(Randomizer.randomInt(1000));
		record.setRating(Randomizer.randomBigDecimal("1000"));
		record.setNotes(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Workouts generateRandomWorkoutsEntity() {
		Workouts record = new Workouts();
		record.setWorkoutId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(new java.sql.Date(Randomizer.randomDate()
                .getTime()));
		record.setExerciseTypeId(Randomizer.randomInt(1000));
		record.setDuration(Randomizer.randomInt(1000));
		record.setRating(Randomizer.randomBigDecimal("1000"));
		record.setNotes(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

    private static WorkoutWrapperDTO generateRandomWorkoutWrapper() {
        WorkoutWrapperDTO wrapper = new WorkoutWrapperDTO();
        wrapper.setWorkoutType(Randomizer.randomInt(anyInt()));
        wrapper.setWorkoutCardioFormDTO(new WorkoutCardioFormDTO());
        wrapper.setWorkoutStepsFormDTO(new WorkoutStepsFormDTO());
        wrapper.setWorkoutWeightsFormDTO(new WorkoutWeightsFormDTO());
        return wrapper;
    }

}
