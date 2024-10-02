package com.schnarbiesnmeowers.nmsmonolith.services.workouts;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutCardioDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutCardio;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutCardioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutCardioService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private WorkoutCardioRepository workoutCardioRepository;

    /**
     * get all WorkoutCardio records
     * @return
     * @throws Exception
     */
    public List<WorkoutCardioDTO> getAllWorkoutCardio() throws Exception {
        Iterable<WorkoutCardio> WorkoutCardio = workoutCardioRepository.findAll();
        Iterator<WorkoutCardio> WorkoutCardios = WorkoutCardio.iterator();
        List<WorkoutCardioDTO> WorkoutCardiodto = new ArrayList();
        while(WorkoutCardios.hasNext()) {
            WorkoutCardio item = WorkoutCardios.next();
            WorkoutCardiodto.add(item.toDTO());
        }
        return WorkoutCardiodto;
    }

    /**
     * get WorkoutCardio by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public WorkoutCardioDTO findWorkoutCardioById(int id) throws Exception {
        Optional<WorkoutCardio> WorkoutCardioOptional = workoutCardioRepository.findById(id);
        if(WorkoutCardioOptional.isPresent()) {
            WorkoutCardio results = WorkoutCardioOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new WorkoutCardio
     * @param data
     * @return
     */
    public WorkoutCardioDTO createWorkoutCardio(WorkoutCardioDTO data) {
        try {
            WorkoutCardio createdData = data.toEntity();
            createdData = workoutCardioRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a WorkoutCardio
     * @param data
     * @return
     * @throws Exception
     */
    public WorkoutCardioDTO updateWorkoutCardio(WorkoutCardioDTO data) throws Exception {
        Optional<WorkoutCardio> WorkoutCardioOptional = workoutCardioRepository.findById(data.getWorkoutCardioId());
        if(WorkoutCardioOptional.isPresent()) {
            WorkoutCardio updatedData = data.toEntity();
            updatedData = workoutCardioRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getWorkoutCardioId() + NOT_FOUND);
        }
    }

    /**
     * delete a WorkoutCardio by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteWorkoutCardio(int id) throws Exception {
        Optional<WorkoutCardio> WorkoutCardioOptional = workoutCardioRepository.findById(id);
        if(WorkoutCardioOptional.isPresent()) {
            workoutCardioRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * get List<WorkoutCardioDTO> by foreign key : workoutId
     * @param id
     * @return List<WorkoutCardio>
     * @throws Exception
     */
    public WorkoutCardioDTO findWorkoutCardioByWorkoutId(int id) throws Exception {
        Iterable<WorkoutCardio> results = workoutCardioRepository.findWorkoutCardioByWorkoutId(id);
        Iterator<WorkoutCardio> iter = results.iterator();
        WorkoutCardioDTO resultsdto = null;
        while(iter.hasNext()) {
            WorkoutCardio item = iter.next();
            resultsdto = item.toDTO();
            break;
        }
        return resultsdto;
    }
}
