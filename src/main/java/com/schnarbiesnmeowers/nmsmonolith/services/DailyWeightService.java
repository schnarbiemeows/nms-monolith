package com.schnarbiesnmeowers.nmsmonolith.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.email.InputMessage;
import com.schnarbiesnmeowers.nmsmonolith.pojos.tuples.Tuple2;
import com.schnarbiesnmeowers.nmsmonolith.pojos.tuples.Tuple3;
import com.schnarbiesnmeowers.nmsmonolith.services.helpers.DailyWeightUtil;
import com.schnarbiesnmeowers.nmsmonolith.utilities.EmailUtility;
import com.schnarbiesnmeowers.nmsmonolith.utilities.excel.DailyWeightExcelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyWeight;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyWeightRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyWeightService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyWeightRepository dailyWeightRepository;

	@Autowired
	private EmailUtility emailUtility;

	@Autowired
	private MessagesService messagesService;

	/**
	 * get all DailyWeight records
	 * @return
	 * @throws Exception
	 */
	public List<DailyWeightDataPoint> getAllDailyWeight() throws Exception {
		Iterable<DailyWeight> dailyweight = dailyWeightRepository.findAll();
		Iterator<DailyWeight> dailyweights = dailyweight.iterator();
		List<DailyWeightDataPoint> dailyweightdto = new ArrayList();
		while(dailyweights.hasNext()) {
			DailyWeight item = dailyweights.next();
			dailyweightdto.add(item.toDTO());
		}
		return dailyweightdto;
	}

	/**
	 * get DailyWeight by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyWeightDataPoint findDailyWeightById(int id) throws Exception {
		Optional<DailyWeight> dailyweightOptional = dailyWeightRepository.findById(id);
		if(dailyweightOptional.isPresent()) {
			DailyWeight results = dailyweightOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new DailyWeight
	 * @param data
	 * @return
	 */
	public DailyWeightDataPoint createDailyWeight(DailyWeightDataPoint data) {
		try {
		    DailyWeight createdData = data.toEntity();
		    createdData = dailyWeightRepository.save(createdData);
			InputMessage inputMessage = new InputMessage("recorded daily weight for : " + data.getCalendarDate().toString(),
					getBody(data));
			String outputMessage = emailUtility.sendTestEmailUsingWebflux(inputMessage).block();
		    return createdData.toDTO();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String getBody(DailyWeightDataPoint data) {
		String content = "<!DOCTYPE html>";
		content += "<h1 style=\"text-align:center;\">Hi there!</h1>";
		content += "<p style=\"text-align:center;\">You recorded your daily weight for : " + data.getCalendarDate().toString() + " </p>";
		content += "<p style=\"text-align:center;\">Your recorded weight was: : " + data.getWeight() + "</p>";
		content += "<br/>";
		content += "<p>Sincerely:</p><br/>";
		content += "<p>The Schnarbies-n-meowers team</p>";
		content += "</html>";
		return content;
	}

	/**
	 * update a DailyWeight
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyWeightDataPoint updateDailyWeight(DailyWeightDataPoint data) throws Exception {
		Optional<DailyWeight> dailyweightOptional = dailyWeightRepository.findById(data.getDailyWeightId());
		if(dailyweightOptional.isPresent()) {
		    DailyWeight updatedData = data.toEntity();
			updatedData = dailyWeightRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getDailyWeightId() + NOT_FOUND);
		}
	}

	/**
	 * delete a DailyWeight by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyWeight(int id) throws Exception {
		Optional<DailyWeight> dailyweightOptional = dailyWeightRepository.findById(id);
		if(dailyweightOptional.isPresent()) {
			dailyWeightRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<DailyWeightDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyWeight>
	 * @throws Exception
	*/
	public List<DailyWeightDataPoint> findDailyWeightByUserId(int id) throws Exception {
		Iterable<DailyWeight> results = dailyWeightRepository.findDailyWeightByUserId(id);
		Iterator<DailyWeight> iter = results.iterator();
		List<DailyWeightDataPoint> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyWeight item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * finds all of the daily wieghts for agiven user, sorted by calendar_date asc
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<DailyWeightDataPoint> findDailyWeightByUserIdSorted(int id) throws Exception {
		Iterable<DailyWeight> results = dailyWeightRepository.findSortedDailyWeightByUserId(id);
		Iterator<DailyWeight> iter = results.iterator();
		List<DailyWeightDataPoint> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyWeight item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * returns a list of daily weights for a given user, up to a certain amount
	 * of days back(usually 30, 90, 180, 365)
	 * the weights are sorted by date asc
	 * for a complete list of weights for all time, use the findSortedDailyWeightByUserId() method above
	 * @param id
	 * @param daysBack
	 * @return
	 * @throws Exception
	 */
	public DailyWeightDTO findDailyWeightByUserIdAndDate(int id, int daysBack) throws Exception {
		LocalDate today = LocalDate.now();
		LocalDate pastDate = today.minus(daysBack, ChronoUnit.DAYS);
		String dateStr = pastDate.toString();
		Iterable<DailyWeight> results = dailyWeightRepository.findDailyWeightByUserIdAndDate(id,dateStr);
		Iterator<DailyWeight> iter = results.iterator();
		List<DailyWeightDataPoint> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyWeight item = iter.next();
			resultsdto.add(item.toDTO());
		}
		Tuple2<BigDecimal,BigDecimal> minMaxWeights = DailyWeightUtil.findMinAndMaxWeights(resultsdto);
		BigDecimal minWeight = (BigDecimal)minMaxWeights.getA();
		BigDecimal maxWeight = (BigDecimal)minMaxWeights.getB();
		BigDecimal averageWeight = DailyWeightUtil.findAverageWeight(resultsdto);
		List<LocalDate> dateList = DailyWeightUtil.getDateList(resultsdto,daysBack);
		Tuple3<List<DailyWeightDataPoint>,List<DailyWeightDataPoint>,List<LocalDate>> dataMissingDataAndMissingDates =
				DailyWeightUtil.getDataMissingDataAndMissingDates(resultsdto,dateList);
		List<DailyWeightDataPoint> validDataPoints = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getA();
		List<DailyWeightDataPoint> missingData = (List<DailyWeightDataPoint>)dataMissingDataAndMissingDates.getB();
		List<LocalDate> missingDates = (List<LocalDate>)dataMissingDataAndMissingDates.getC();
		DailyWeightDTO response = new DailyWeightDTO()
				.data(validDataPoints)
				.missingData(missingData)
				.missingDates(missingDates)
				.min(minWeight)
				.max(maxWeight)
				.average(averageWeight);
		return response;
	}

	public void uploadFile(String filepath, int userId, String tabName, int columnNumber) {
		BigDecimal threshold = BigDecimal.valueOf(221.0d);
		BigDecimal thresholdlow = BigDecimal.valueOf(174.0d);
		List<DailyWeight> weights = DailyWeightExcelUtility.processFile(filepath,userId,tabName,columnNumber);
		for(DailyWeight weight : weights) {
			try {
				//System.out.println("record: " + weight.toString());
				if(weight.getWeight().compareTo(threshold)>0||weight.getWeight().compareTo(thresholdlow)<0) {
					System.out.println("Daily weight with date = " + weight.getCalendarDate() + " too high, value = " + weight.getWeight());
				}
				dailyWeightRepository.save(weight);
			} catch(Exception sql) {
				System.out.println("SqlException: " + sql.getLocalizedMessage());
				System.out.println("record with date: " + weight.getCalendarDate() + " may already exist");
			}
		}
	}
}
