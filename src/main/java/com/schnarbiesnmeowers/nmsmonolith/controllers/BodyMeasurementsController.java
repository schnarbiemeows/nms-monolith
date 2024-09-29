package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BodyMeasurementsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.BodyMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/body_measurements")
public class BodyMeasurementsController {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     * JPA Repository handle
     */
    @Autowired
    private BodyMeasurementsService bodyMeasurementsService;

    /**
     * get all BodyMeasurements records
     * @return Iterable<BodyMeasurements>
     */
    @GetMapping(path = "/all")
    public ResponseEntity<List<BodyMeasurementsDTO>> getAllBodyMeasurements() throws Exception {
        List<BodyMeasurementsDTO> BodyMeasurements = bodyMeasurementsService.getAllBodyMeasurements();
        return ResponseEntity.status(HttpStatus.OK).body(BodyMeasurements);
    }

    /**
     * get BodyMeasurements by primary key
     * @param id
     * @return BodyMeasurements
     */
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<BodyMeasurementsDTO> findBodyMeasurementsById(@PathVariable int id) throws Exception {
        BodyMeasurementsDTO results = bodyMeasurementsService.findBodyMeasurementsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @GetMapping(path = "/findByUserId/{id}")
    public ResponseEntity<List<BodyMeasurementsDTO>> findBodyMeasurementsByUserId(@PathVariable int id) throws Exception {
        List<BodyMeasurementsDTO> results = bodyMeasurementsService.findBodyMeasurementsByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }


    /**
     * create a new BodyMeasurements
     * @param data
     * @return BodyMeasurements
     */
    @PostMapping(path = "/create")
    public ResponseEntity<BodyMeasurementsDTO> createBodyMeasurements(@Valid @RequestBody BodyMeasurementsDTO data) throws Exception {
        try {
            BodyMeasurementsDTO createdData = bodyMeasurementsService.createBodyMeasurements(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a BodyMeasurements
     * @param data
     * @return BodyMeasurements
     */
    @PostMapping(path = "/update")
    public ResponseEntity<BodyMeasurementsDTO> updateBodyMeasurements(@Valid @RequestBody BodyMeasurementsDTO data) throws Exception {
        BodyMeasurementsDTO updatedData = bodyMeasurementsService.updateBodyMeasurements(data);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    /**
     * delete a BodyMeasurements by primary key
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteBodyMeasurements(@PathVariable int id) throws Exception {
        bodyMeasurementsService.deleteBodyMeasurements(id);
        ResponseMessage rb = new ResponseMessage("successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(rb);
    }
}
