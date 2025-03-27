package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftMuscleDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftMuscle;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftMuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class LiftMuscleService {

    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";

    @Autowired
    private LiftMuscleRepository liftMuscleRepository;

    /**
     * get all LiftMuscle records
     * @return
     * @throws Exception
     */
    public List<LiftMuscleDTO> getAllLiftMuscle() throws Exception {
        Iterable<LiftMuscle> LiftMuscle = liftMuscleRepository.findAll();
        Iterator<LiftMuscle> LiftMuscles = LiftMuscle.iterator();
        List<LiftMuscleDTO> LiftMuscledto = new ArrayList();
        while(LiftMuscles.hasNext()) {
            LiftMuscle item = LiftMuscles.next();
            LiftMuscledto.add(item.toDTO());
        }
        return LiftMuscledto;
    }

    /**
     * get LiftMuscle by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public LiftMuscleDTO findLiftMuscleById(int id) throws Exception {
        Optional<LiftMuscle> LiftMuscleOptional = liftMuscleRepository.findById(id);
        if(LiftMuscleOptional.isPresent()) {
            LiftMuscle results = LiftMuscleOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * get LiftMuscle by liftId
     * @param id
     * @return
     * @throws Exception
     */
    public List<LiftMuscleDTO> findLiftMuscleByLiftId(int id) throws Exception {
        Iterable<LiftMuscle> LiftMuscle = liftMuscleRepository.findLiftMuscleByLiftId(id);
        Iterator<LiftMuscle> LiftMuscles = LiftMuscle.iterator();
        List<LiftMuscleDTO> LiftMuscledto = new ArrayList();
        while(LiftMuscles.hasNext()) {
            LiftMuscle item = LiftMuscles.next();
            LiftMuscledto.add(item.toDTO());
        }
        return LiftMuscledto;
    }

    /**
     * get LiftMuscle by muscleId
     * @param id
     * @return
     * @throws Exception
     */
    public List<LiftMuscleDTO> findLiftMuscleByMuscleId(int id) throws Exception {
        Iterable<LiftMuscle> LiftMuscle = liftMuscleRepository.findLiftMuscleByMuscleId(id);
        Iterator<LiftMuscle> LiftMuscles = LiftMuscle.iterator();
        List<LiftMuscleDTO> LiftMuscledto = new ArrayList();
        while(LiftMuscles.hasNext()) {
            LiftMuscle item = LiftMuscles.next();
            LiftMuscledto.add(item.toDTO());
        }
        return LiftMuscledto;
    }

    /**
     * create a new LiftMuscle
     * @param data
     * @return
     */
    public LiftMuscleDTO createLiftMuscle(LiftMuscleDTO data) {
        try {
            LiftMuscle createdData = data.toEntity();
            createdData = liftMuscleRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a LiftMuscle
     * @param data
     * @return
     * @throws Exception
     */
    public LiftMuscleDTO updateLiftMuscle(LiftMuscleDTO data) throws Exception {
        Optional<LiftMuscle> LiftMuscleOptional = liftMuscleRepository.findById(data.getLiftMuscleId());
        if(LiftMuscleOptional.isPresent()) {
            LiftMuscle updatedData = data.toEntity();
            updatedData = liftMuscleRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getLiftMuscleId() + NOT_FOUND);
        }
    }

    /**
     * delete a LiftMuscle by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteLiftMuscle(int id) throws Exception {
        Optional<LiftMuscle> LiftMuscleOptional = liftMuscleRepository.findById(id);
        if(LiftMuscleOptional.isPresent()) {
            liftMuscleRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }
}
