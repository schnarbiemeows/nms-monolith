package com.schnarbiesnmeowers.nmsmonolith.services;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDietTotals;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietTotalsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietTotalsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietTotalsRepository dailyDietTotalsRepository;

	/**
	 * get all DailyDietTotals records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietTotalsDTO> getAllDailyDietTotals() throws Exception {
		Iterable<DailyDietTotals> dailydiettotals = dailyDietTotalsRepository.findAll();
		Iterator<DailyDietTotals> dailydiettotalss = dailydiettotals.iterator();
		List<DailyDietTotalsDTO> dailydiettotalsdto = new ArrayList();
		while(dailydiettotalss.hasNext()) {
			DailyDietTotals item = dailydiettotalss.next();
			dailydiettotalsdto.add(item.toDTO());
		}
		return dailydiettotalsdto;
	}

	/**
	 * get DailyDietTotals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietTotalsDTO findDailyDietTotalsById(int id) throws Exception {
		Optional<DailyDietTotals> dailydiettotalsOptional = dailyDietTotalsRepository.findById(id);
		if(dailydiettotalsOptional.isPresent()) {
			DailyDietTotals results = dailydiettotalsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new DailyDietTotals
	 * @param data
	 * @return
	 */
	public DailyDietTotalsDTO createDailyDietTotals(DailyDietTotalsDTO data) {
		try {
		    DailyDietTotals createdData = data.toEntity();
		    createdData = dailyDietTotalsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDietTotals
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietTotalsDTO updateDailyDietTotals(DailyDietTotalsDTO data) throws Exception {
		Optional<DailyDietTotals> dailydiettotalsOptional = dailyDietTotalsRepository.findById(data.getDailyDietTotalId());
		if(dailydiettotalsOptional.isPresent()) {
		    DailyDietTotals updatedData = data.toEntity();
			updatedData = dailyDietTotalsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getDailyDietTotalId() + NOT_FOUND);
		}
	}

	/**
	 * delete a DailyDietTotals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietTotals(int id) throws Exception {
		Optional<DailyDietTotals> dailydiettotalsOptional = dailyDietTotalsRepository.findById(id);
		if(dailydiettotalsOptional.isPresent()) {
			dailyDietTotalsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * delete a daily_diet_totals record for userId, calendarDate, and bdlstId
	 * @param userId
	 * @param calendarDate
	 * @param bdlstId
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(int userId,
		Date calendarDate, int bdlstId) {
		String returnMessage = "";
		try {
			Optional<DailyDietTotals> dailydiettotalsOptional =
					dailyDietTotalsRepository
							.findDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,calendarDate,bdlstId);
			if(dailydiettotalsOptional.isPresent()) {
				int pk = dailydiettotalsOptional.get().getDailyDietTotalId();
				dailyDietTotalsRepository.deleteById(pk);
				returnMessage = "Successfully Deleted";
			} else {
			/*throw new ResourceNotFoundException("daily_diet_totals record for userId = " + userId + " and date = " +
					calendarDate + " and bdlstId = " + bdlstId + NOT_FOUND);*/
				returnMessage = "daily_diet_totals record for userId = " + userId + " and date = " +
						calendarDate + " and bdlstId = " + bdlstId + NOT_FOUND;
			}
		} catch(Exception e) {
			e.printStackTrace();
			returnMessage = e.getLocalizedMessage();
		}
		return returnMessage;
	}

	public DailyDietTotalsDTO upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(DailyDietTotalsDTO totals) {
		try {
			Optional<DailyDietTotals> dailydiettotalsOptional =
					dailyDietTotalsRepository
							.findDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals.getUserId(),
									totals.getCalendarDate(),totals.getBldstId());
			if(dailydiettotalsOptional.isPresent()) {
				totals.setDailyDietTotalId(dailydiettotalsOptional.get().getDailyDietTotalId());
				updateDailyDietTotals(totals);
			} else {
				createDailyDietTotals(totals);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return totals;
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	public List<DailyDietTotalsDTO> findDailyDietTotalsByUserId(int id) throws Exception {
		Iterable<DailyDietTotals> results = dailyDietTotalsRepository.findDailyDietTotalsByUserId(id);
		Iterator<DailyDietTotals> iter = results.iterator();
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDietTotals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<DailyDietTotalsDTO> by user_id and calendar_date
	 * @param id
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietTotalsDTO> findDailyDietTotalsByUserIdAndCalendarDate(int id,Date date) throws Exception {
		Iterable<DailyDietTotals> results =
				dailyDietTotalsRepository.findDailyDietTotalsByUserIdAndCalendarDate(id,date);
		Iterator<DailyDietTotals> iter = results.iterator();
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDietTotals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : bldstId
	 * @param id
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	public List<DailyDietTotalsDTO> findDailyDietTotalsByBldstId(int id) throws Exception {
		Iterable<DailyDietTotals> results = dailyDietTotalsRepository.findDailyDietTotalsByBldstId(id);
		Iterator<DailyDietTotals> iter = results.iterator();
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDietTotals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : UserIdAndBldstId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietTotalsDTO> findDailyDietTotalsByUserIdAndBldstId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<DailyDietTotals> results = dailyDietTotalsRepository.findDailyDietTotalsByUserIdAndBldstId(id0, id1);
		Iterator<DailyDietTotals> iter = results.iterator();
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDietTotals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
