package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.CardioTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.CardioTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/cardiotype")
public class CardioTypeController {

    /**
     * JPA Repository handle
     */
    @Autowired
    private CardioTypeService service;

    /**
     * get all CardioType records
     * @return Iterable<CardioType>
     */
    @GetMapping(path = "/all")
    public ResponseEntity<List<CardioTypeDTO>> getAllCardioType() throws Exception {
        List<CardioTypeDTO> CardioType = service.getAllCardioType();
        return ResponseEntity.status(HttpStatus.OK).body(CardioType);
    }

    /**
     * get CardioType by primary key
     * @param id
     * @return CardioType
     */
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<CardioTypeDTO> findCardioTypeById(@PathVariable int id) throws Exception {
        CardioTypeDTO results = service.findCardioTypeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    /**
     * create a new CardioType
     * @param data
     * @return CardioType
     */
    @PostMapping(path = "/create")
    public ResponseEntity<CardioTypeDTO> createCardioType(@Valid @RequestBody CardioTypeDTO data) throws Exception {
        try {
            CardioTypeDTO createdData = service.createCardioType(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a CardioType
     * @param data
     * @return CardioType
     */
    @PostMapping(path = "/update")
    public ResponseEntity<CardioTypeDTO> updateCardioType(@Valid @RequestBody CardioTypeDTO data) throws Exception {
        CardioTypeDTO updatedData = service.updateCardioType(data);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    /**
     * delete a CardioType by primary key
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteCardioType(@PathVariable int id) throws Exception {
        service.deleteCardioType(id);
        ResponseMessage rb = new ResponseMessage("successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(rb);
    }
}
