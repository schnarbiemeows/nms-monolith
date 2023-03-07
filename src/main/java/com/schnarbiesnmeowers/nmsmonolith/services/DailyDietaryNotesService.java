package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDietaryNotes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietaryNotesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietaryNotesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietaryNotesRepository dailyDietaryNotesRepository;

	/**
	 * get all DailyDietaryNotes records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietaryNotesDTO> getAllDailyDietaryNotes() throws Exception {
		Iterable<DailyDietaryNotes> dailydietarynotes = dailyDietaryNotesRepository.findAll();
		Iterator<DailyDietaryNotes> dailydietarynotess = dailydietarynotes.iterator();
		List<DailyDietaryNotesDTO> dailydietarynotesdto = new ArrayList();
		while(dailydietarynotess.hasNext()) {
			DailyDietaryNotes item = dailydietarynotess.next();
			dailydietarynotesdto.add(item.toDTO());
		}
		return dailydietarynotesdto;
	}

	/**
	 * get DailyDietaryNotes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietaryNotesDTO findDailyDietaryNotesById(int id) throws Exception {
		Optional<DailyDietaryNotes> dailydietarynotesOptional = dailyDietaryNotesRepository.findById(id);
		if(dailydietarynotesOptional.isPresent()) {
			DailyDietaryNotes results = dailydietarynotesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new DailyDietaryNotes
	 * @param data
	 * @return
	 */
	public DailyDietaryNotesDTO createDailyDietaryNotes(DailyDietaryNotesDTO data) {
		try {
		    DailyDietaryNotes createdData = data.toEntity();
		    createdData = dailyDietaryNotesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDietaryNotes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietaryNotesDTO updateDailyDietaryNotes(DailyDietaryNotesDTO data) throws Exception {
		Optional<DailyDietaryNotes> dailydietarynotesOptional = dailyDietaryNotesRepository.findById(data.getDdnId());
		if(dailydietarynotesOptional.isPresent()) {
		    DailyDietaryNotes updatedData = data.toEntity();
			updatedData = dailyDietaryNotesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getDdnId() + NOT_FOUND);
		}
	}

	/**
	 * delete a DailyDietaryNotes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietaryNotes(int id) throws Exception {
		Optional<DailyDietaryNotes> dailydietarynotesOptional = dailyDietaryNotesRepository.findById(id);
		if(dailydietarynotesOptional.isPresent()) {
			dailyDietaryNotesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<DailyDietaryNotesDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietaryNotes>
	 * @throws Exception
	*/
	public List<DailyDietaryNotesDTO> findDailyDietaryNotesByUserId(int id) throws Exception {
		Iterable<DailyDietaryNotes> results = dailyDietaryNotesRepository.findDailyDietaryNotesByUserId(id);
		Iterator<DailyDietaryNotes> iter = results.iterator();
		List<DailyDietaryNotesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDietaryNotes item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public DailyDietaryNotesDTO findDailyDietaryNotesByUserIdAndDate(int id, Date date) throws Exception {
		Optional<DailyDietaryNotes> results = dailyDietaryNotesRepository.findDailyDietaryNotesByUserIdAndDate(id,date);
		if(results.isPresent()) {
			return results.get().toDTO();
		}
		return null;
	}

}
