package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.TemplatesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.TemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/templates")
public class TemplatesController {

    @Autowired
    private TemplatesService businessService;

    /**
     * get all Templates records
     * @return Iterable<Templates>
     */
    @GetMapping(path = "/all")
    public ResponseEntity<List<TemplatesDTO>> getAllTemplates() throws Exception {
        List<TemplatesDTO> Templates = businessService.getAllTemplates();
        return ResponseEntity.status(HttpStatus.OK).body(Templates);
    }

    /**
     * get Templates by primary key
     * @param id
     * @return Templates
     */
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<TemplatesDTO> findTemplatesById(@PathVariable int id) throws Exception {
        TemplatesDTO results = businessService.findTemplatesById(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    /**
     * create a new Templates
     * @param data
     * @return Templates
     */
    @PostMapping(path = "/create")
    public ResponseEntity<TemplatesDTO> createTemplates(@Valid @RequestBody TemplatesDTO data) throws Exception {
        try {
            TemplatesDTO createdData = businessService.createTemplates(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a Templates
     * @param data
     * @return Templates
     */
    @PostMapping(path = "/update")
    public ResponseEntity<TemplatesDTO> updateTemplates(@Valid @RequestBody TemplatesDTO data) throws Exception {
        TemplatesDTO updatedData = businessService.updateTemplates(data);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    /**
     * delete a Templates by primary key
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteTemplates(@PathVariable int id) throws Exception {
        businessService.deleteTemplates(id);
        ResponseMessage rb = new ResponseMessage("successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(rb);
    }
}
