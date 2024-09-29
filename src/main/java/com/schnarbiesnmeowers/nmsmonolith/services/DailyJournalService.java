package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyJournalDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyJournal;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DailyJournalService {

    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private DailyJournalRepository dailyJournalRepository;

    /**
     * get all DailyJournal records
     * @return
     * @throws Exception
     */
    public List<DailyJournalDTO> getAllDailyJournal() throws Exception {
        Iterable<DailyJournal> DailyJournal = dailyJournalRepository.findAll();
        Iterator<DailyJournal> DailyJournals = DailyJournal.iterator();
        List<DailyJournalDTO> DailyJournaldto = new ArrayList();
        while(DailyJournals.hasNext()) {
            DailyJournal item = DailyJournals.next();
            DailyJournaldto.add(item.toDTO());
        }
        return DailyJournaldto;
    }

    /**
     * get DailyJournal by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public DailyJournalDTO findDailyJournalById(int id) throws Exception {
        Optional<DailyJournal> DailyJournalOptional = dailyJournalRepository.findById(id);
        if(DailyJournalOptional.isPresent()) {
            DailyJournal results = DailyJournalOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new DailyJournal
     * @param data
     * @return
     */
    public DailyJournalDTO createDailyJournal(DailyJournalDTO data) {
        try {
            DailyJournal createdData = data.toEntity();
            createdData = dailyJournalRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a DailyJournal
     * @param data
     * @return
     * @throws Exception
     */
    public DailyJournalDTO updateDailyJournal(DailyJournalDTO data) throws Exception {
        Optional<DailyJournal> DailyJournalOptional = dailyJournalRepository.findById(data.getDailyJournalId());
        if(DailyJournalOptional.isPresent()) {
            DailyJournal updatedData = data.toEntity();
            updatedData = dailyJournalRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getDailyJournalId() + NOT_FOUND);
        }
    }

    /**
     * delete a DailyJournal by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteDailyJournal(int id) throws Exception {
        Optional<DailyJournal> DailyJournalOptional = dailyJournalRepository.findById(id);
        if(DailyJournalOptional.isPresent()) {
            dailyJournalRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * get List<DailyJournalDTO> by foreign key : userId
     * @param id
     * @return List<DailyJournal>
     * @throws Exception
     */
    public List<DailyJournalDTO> findDailyJournalByUserId(int id) throws Exception {
        Iterable<DailyJournal> results = dailyJournalRepository.findDailyJournalByUserId(id);
        Iterator<DailyJournal> iter = results.iterator();
        List<DailyJournalDTO> resultsdto = new ArrayList();
        while(iter.hasNext()) {
            DailyJournal item = iter.next();
            resultsdto.add(item.toDTO());
        }
        return resultsdto;
    }

    public DailyJournalDTO findDailyJournalByUserIdAndDate(int id, Date date) throws Exception {
        Optional<DailyJournal> results = dailyJournalRepository.findDailyJournalByUserIdAndDate(id,date);
        if(results.isPresent()) {
            return results.get().toDTO();
        }
        return null;
    }
}
