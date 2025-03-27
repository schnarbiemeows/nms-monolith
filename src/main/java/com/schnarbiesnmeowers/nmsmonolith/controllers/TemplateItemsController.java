package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.TemplateItemsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.TemplateItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/templateitems")
public class TemplateItemsController {

    @Autowired
    private TemplateItemsService businessService;

    /**
     * get all TemplateItems records
     * @return Iterable<TemplateItems>
     */
    @GetMapping(path = "/all")
    public ResponseEntity<List<TemplateItemsDTO>> getAllTemplateItems() throws Exception {
        List<TemplateItemsDTO> TemplateItems = businessService.getAllTemplateItems();
        return ResponseEntity.status(HttpStatus.OK).body(TemplateItems);
    }

    /**
     * get TemplateItems by primary key
     * @param id
     * @return TemplateItems
     */
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<TemplateItemsDTO> findTemplateItemsById(@PathVariable int id) throws Exception {
        TemplateItemsDTO results = businessService.findTemplateItemsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    /**
     * create a new TemplateItems
     * @param data
     * @return TemplateItems
     */
    @PostMapping(path = "/create")
    public ResponseEntity<TemplateItemsDTO> createTemplateItems(@Valid @RequestBody TemplateItemsDTO data) throws Exception {
        try {
            TemplateItemsDTO createdData = businessService.createTemplateItems(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a TemplateItems
     * @param data
     * @return TemplateItems
     */
    @PostMapping(path = "/update")
    public ResponseEntity<TemplateItemsDTO> updateTemplateItems(@Valid @RequestBody TemplateItemsDTO data) throws Exception {
        TemplateItemsDTO updatedData = businessService.updateTemplateItems(data);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    /**
     * delete a TemplateItems by primary key
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteTemplateItems(@PathVariable int id) throws Exception {
        businessService.deleteTemplateItems(id);
        ResponseMessage rb = new ResponseMessage("successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(rb);
    }
}
