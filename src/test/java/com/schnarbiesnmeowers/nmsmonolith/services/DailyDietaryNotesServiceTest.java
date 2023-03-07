package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietaryNotesServiceTest {


	/**
	 * get all DailyDietaryNotes records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietaryNotesDTO> getAllDailyDietaryNotes() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<DailyDietaryNotesDTO> dailydietarynotesDTO = new ArrayList<DailyDietaryNotesDTO>();
		return dailydietarynotesDTO;
	}

	/**
	 * get DailyDietaryNotes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietaryNotesDTO findDailyDietaryNotesById(int id) throws Exception {
		return new DailyDietaryNotesDTO();
	}

	/**
	 * create a new DailyDietaryNotes
	 * @param data
	 * @return
	 */
	public DailyDietaryNotesDTO createDailyDietaryNotes(DailyDietaryNotesDTO data) {
        data.setDdnId(1);
        return data;
	}

	/**
	 * update a DailyDietaryNotes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietaryNotesDTO updateDailyDietaryNotes(DailyDietaryNotesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a DailyDietaryNotes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietaryNotes(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<DailyDietaryNotesDTO> by foreign key : userId
	 * @param userId
	 * @return List<DailyDietaryNotes>
	 * @throws Exception
	*/
	public List<DailyDietaryNotesDTO> findDailyDietaryNotesByUserId(int id) throws Exception {
		List<DailyDietaryNotesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
