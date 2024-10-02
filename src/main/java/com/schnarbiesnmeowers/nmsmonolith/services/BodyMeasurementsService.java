package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BodyMeasurementsDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.BodyMeasurements;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BodyMeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BodyMeasurementsService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private BodyMeasurementsRepository bodyMeasurementsRepository;

    /**
     * get all BodyMeasurements records
     * @return
     * @throws Exception
     */
    public List<BodyMeasurementsDTO> getAllBodyMeasurements() throws Exception {
        Iterable<BodyMeasurements> BodyMeasurements = bodyMeasurementsRepository.findAll();
        Iterator<BodyMeasurements> BodyMeasurementss = BodyMeasurements.iterator();
        List<BodyMeasurementsDTO> BodyMeasurementsdto = new ArrayList();
        while(BodyMeasurementss.hasNext()) {
            BodyMeasurements item = BodyMeasurementss.next();
            BodyMeasurementsdto.add(item.toDTO());
        }
        return BodyMeasurementsdto;
    }

    /**
     * get BodyMeasurements by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public BodyMeasurementsDTO findBodyMeasurementsById(int id) throws Exception {
        Optional<BodyMeasurements> BodyMeasurementsOptional = bodyMeasurementsRepository.findById(id);
        if(BodyMeasurementsOptional.isPresent()) {
            BodyMeasurements results = BodyMeasurementsOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    public List<BodyMeasurementsDTO> findBodyMeasurementsByUserId(int userId) throws Exception {
        Iterable<BodyMeasurements> BodyMeasurements = bodyMeasurementsRepository
                .findBodyMeasurementsByUserId(userId);
        Iterator<BodyMeasurements> BodyMeasurementss = BodyMeasurements.iterator();
        List<BodyMeasurementsDTO> BodyMeasurementsdto = new ArrayList();
        while(BodyMeasurementss.hasNext()) {
            BodyMeasurements item = BodyMeasurementss.next();
            BodyMeasurementsdto.add(item.toDTO());
        }
        return BodyMeasurementsdto;
    }

    /**
     * create a new BodyMeasurements
     * @param data
     * @return
     */
    public BodyMeasurementsDTO createBodyMeasurements(BodyMeasurementsDTO data) {
        try {
            BodyMeasurements createdData = data.toEntity();
            createdData = bodyMeasurementsRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a BodyMeasurements
     * @param data
     * @return
     * @throws Exception
     */
    public BodyMeasurementsDTO updateBodyMeasurements(BodyMeasurementsDTO data) throws Exception {
        Optional<BodyMeasurements> BodyMeasurementsOptional = bodyMeasurementsRepository
                .findById(data.getBodyMeasurementId());
        if(BodyMeasurementsOptional.isPresent()) {
            BodyMeasurements updatedData = data.toEntity();
            updatedData = bodyMeasurementsRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getBodyMeasurementId() + NOT_FOUND);
        }
    }

    /**
     * delete a BodyMeasurements by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteBodyMeasurements(int id) throws Exception {
        Optional<BodyMeasurements> BodyMeasurementsOptional = bodyMeasurementsRepository.findById(id);
        if(BodyMeasurementsOptional.isPresent()) {
            bodyMeasurementsRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }
}
