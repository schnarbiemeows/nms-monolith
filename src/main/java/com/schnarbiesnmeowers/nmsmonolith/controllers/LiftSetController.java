package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.LiftSetDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.LiftSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/liftset")
public class LiftSetController {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     * JPA Repository handle
     */
    @Autowired
    private LiftSetService liftSetService;

    /**
     * get all LiftSet records
     * @return Iterable<LiftSet>
     */
    @GetMapping(path = "/all")
    public ResponseEntity<List<LiftSetDTO>> getAllLiftSet() throws Exception {
        List<LiftSetDTO> LiftSet = liftSetService.getAllLiftSet();
        return ResponseEntity.status(HttpStatus.OK).body(LiftSet);
    }

    /**
     * get LiftSet by primary key
     * @param id
     * @return LiftSet
     */
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<LiftSetDTO> findLiftSetById(@PathVariable int id) throws Exception {
        LiftSetDTO results = liftSetService.findLiftSetById(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    /**
     * create a new LiftSet
     * @param data
     * @return LiftSet
     */
    @PostMapping(path = "/create")
    public ResponseEntity<LiftSetDTO> createLiftSet(@Valid @RequestBody LiftSetDTO data) throws Exception {
        try {
            LiftSetDTO createdData = liftSetService.createLiftSet(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a LiftSet
     * @param data
     * @return LiftSet
     */
    @PostMapping(path = "/update")
    public ResponseEntity<LiftSetDTO> updateLiftSet(@Valid @RequestBody LiftSetDTO data) throws Exception {
        LiftSetDTO updatedData = liftSetService.updateLiftSet(data);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    /**
     * delete a LiftSet by primary key
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteLiftSet(@PathVariable int id) throws Exception {
        liftSetService.deleteLiftSet(id);
        ResponseMessage rb = new ResponseMessage("successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(rb);
    }
}
