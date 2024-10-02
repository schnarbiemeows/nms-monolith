package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyJournalDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/dailyjournal")
public class DailyJournalController {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     * JPA Repository handle
     */
    @Autowired
    private DailyJournalService dailyJournalService;

    /**
     * get all DailyJournal records
     * @return Iterable<DailyJournal>
     */
    @GetMapping(path = "/all")
    public ResponseEntity<List<DailyJournalDTO>> getAllDailyJournal() throws Exception {
        List<DailyJournalDTO> DailyJournal = dailyJournalService.getAllDailyJournal();
        return ResponseEntity.status(HttpStatus.OK).body(DailyJournal);
    }

    /**
     * get DailyJournal by primary key
     * @param id
     * @return DailyJournal
     */
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<DailyJournalDTO> findDailyJournalById(@PathVariable int id) throws Exception {
        DailyJournalDTO results = dailyJournalService.findDailyJournalById(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    /**
     * create a new DailyJournal
     * @param data
     * @return DailyJournal
     */
    @PostMapping(path = "/create")
    public ResponseEntity<DailyJournalDTO> createDailyJournal(@Valid @RequestBody DailyJournalDTO data) throws Exception {
        try {
            DailyJournalDTO createdData = dailyJournalService.createDailyJournal(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a DailyJournal
     * @param data
     * @return DailyJournal
     */
    @PostMapping(path = "/update")
    public ResponseEntity<DailyJournalDTO> updateDailyJournal(@Valid @RequestBody DailyJournalDTO data) throws Exception {
        DailyJournalDTO updatedData = dailyJournalService.updateDailyJournal(data);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    /**
     * delete a DailyJournal by primary key
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteDailyJournal(@PathVariable int id) throws Exception {
        dailyJournalService.deleteDailyJournal(id);
        ResponseMessage rb = new ResponseMessage("successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(rb);
    }

    /**
     * get List<DailyJournalDTO> by foreign key : userId
     * @param id
     * @return List<DailyJournal>
     * @throws Exception
     */
    @GetMapping(path = "/findByUserId/{id}")
    public ResponseEntity<List<DailyJournalDTO>> findDailyJournalByUserId(@PathVariable int id) throws Exception {
        List<DailyJournalDTO> results = dailyJournalService.findDailyJournalByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

}
