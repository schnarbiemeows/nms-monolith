package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyWeightServiceTest {


	/**
	 * get all DailyWeight records
	 * @return
	 * @throws Exception
	 */
	public List<DailyWeightDataPoint> getAllDailyWeight() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<DailyWeightDataPoint> dailyweightDataPoint = new ArrayList<DailyWeightDataPoint>();
		return dailyweightDataPoint;
	}

	/**
	 * get DailyWeight by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyWeightDataPoint findDailyWeightById(int id) throws Exception {
		return new DailyWeightDataPoint();
	}

	/**
	 * create a new DailyWeight
	 * @param data
	 * @return
	 */
	public DailyWeightDataPoint createDailyWeight(DailyWeightDataPoint data) {
        data.setDailyWeightId(1);
        return data;
	}

	/**
	 * update a DailyWeight
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyWeightDataPoint updateDailyWeight(DailyWeightDataPoint data) throws Exception {
		return data;
	}

	/**
	 * delete a DailyWeight by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyWeight(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<DailyWeightDTO> by foreign key : userId
	 * @param userId
	 * @return List<DailyWeight>
	 * @throws Exception
	*/
	public List<DailyWeightDataPoint> findDailyWeightByUserId(int id) throws Exception {
		List<DailyWeightDataPoint> resultsdto = new ArrayList();
		return resultsdto;
	}

}
