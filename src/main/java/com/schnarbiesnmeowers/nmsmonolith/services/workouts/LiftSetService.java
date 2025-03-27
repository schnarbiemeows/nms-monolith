package com.schnarbiesnmeowers.nmsmonolith.services.workouts;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.LiftSetDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.LiftSet;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.LiftSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class LiftSetService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private LiftSetRepository LiftSetRepository;

    /**
     * get all LiftSet records
     * @return
     * @throws Exception
     */
    public List<LiftSetDTO> getAllLiftSet() throws Exception {
        Iterable<LiftSet> LiftSet = LiftSetRepository.findAll();
        Iterator<LiftSet> LiftSets = LiftSet.iterator();
        List<LiftSetDTO> LiftSetdto = new ArrayList();
        while(LiftSets.hasNext()) {
            LiftSet item = LiftSets.next();
            LiftSetdto.add(item.toDTO());
        }
        return LiftSetdto;
    }

    /**
     * get LiftSet by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public LiftSetDTO findLiftSetById(int id) throws Exception {
        Optional<LiftSet> LiftSetOptional = LiftSetRepository.findById(id);
        if(LiftSetOptional.isPresent()) {
            LiftSet results = LiftSetOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new LiftSet
     * @param data
     * @return
     */
    public LiftSetDTO createLiftSet(LiftSetDTO data) {
        try {
            LiftSet createdData = data.toEntity();
            createdData = LiftSetRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a LiftSet
     * @param data
     * @return
     * @throws Exception
     */
    public LiftSetDTO updateLiftSet(LiftSetDTO data) throws Exception {
        Optional<LiftSet> LiftSetOptional = LiftSetRepository.findById(data.getLiftSetId());
        if(LiftSetOptional.isPresent()) {
            LiftSet updatedData = data.toEntity();
            updatedData = LiftSetRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getLiftSetId() + NOT_FOUND);
        }
    }

    /**
     * delete a LiftSet by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteLiftSet(int id) throws Exception {
        Optional<LiftSet> LiftSetOptional = LiftSetRepository.findById(id);
        if(LiftSetOptional.isPresent()) {
            LiftSetRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * get LiftSet by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public List<LiftSetDTO> findLiftSetByWorkoutLiftId(int id) throws Exception {
        Iterable<LiftSet> LiftSet = LiftSetRepository.findLiftSetByWorkoutLiftId(id);
        Iterator<LiftSet> LiftSets = LiftSet.iterator();
        List<LiftSetDTO> LiftSetdto = new ArrayList();
        while(LiftSets.hasNext()) {
            LiftSet item = LiftSets.next();
            LiftSetdto.add(item.toDTO());
        }
        return LiftSetdto;
    }
}
