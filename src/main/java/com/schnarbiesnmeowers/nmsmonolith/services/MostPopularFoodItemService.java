package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MostPopularFoodItemDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItemVw;
import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.MostPopularFoodItem;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ManualFoodItemVwRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MostPopularFoodItemRepository;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Constants;
import com.schnarbiesnmeowers.nmsmonolith.utilities.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MostPopularFoodItemService {


    @Autowired
    private MostPopularFoodItemRepository mostPopularFoodItemRepository;

    @Autowired
    private ManualFoodItemVwRepository manualFoodItemVwRepository;


    /**
     * for when the user wants to add items for all meal types at one time
     * @param userId
     * @return
     */
    public Map<Integer,List<MostPopularFoodItemDTO>> findByUserIdAndCalendarDate(int userId) {
        String calendarDate = DateUtil.getBeginningDate(LocalDate.now(), Constants.DAYS_BACK).toString();
        Iterable<MostPopularFoodItem> results = mostPopularFoodItemRepository.findByUserIdAndCalendarDate(
                userId, calendarDate);
        Iterator<MostPopularFoodItem> iter = results.iterator();
        Map<Integer,List<MostPopularFoodItemDTO>> returnResults = new HashMap<Integer,List<MostPopularFoodItemDTO>>();
        List<MostPopularFoodItemDTO> itemsForBldstId = new ArrayList<>();
        while(iter.hasNext()) {
            MostPopularFoodItem item = iter.next();
            if(returnResults.containsKey(item.getBldstId())) {
                itemsForBldstId = returnResults.get(item.getBldstId());
            } else {
                itemsForBldstId = new ArrayList<>();
            }
            itemsForBldstId.add(item.toDTO());
            returnResults.put(item.getBldstId(), itemsForBldstId);
        }
        /**
         * now add all manual items
         */
        List<ManualFoodItemVw> manualItems = manualFoodItemVwRepository.findManualItemsByUserId(
                userId
        );
        for(ManualFoodItemVw item : manualItems) {
            if(returnResults.containsKey(item.getBldstId())) {
                itemsForBldstId = returnResults.get(item.getBldstId());
            } else {
                itemsForBldstId = new ArrayList<>();
            }
            itemsForBldstId.add(convertFromManualToMostPopular(item));
            returnResults.put(item.getBldstId(), itemsForBldstId);
        }
        return returnResults;
    }

    /**
     *
     * @param userId
     * @param bldstId
     * @return
     */
    public List<MostPopularFoodItemDTO> findByUserIdAndCalendarDateAndBldstId(int userId, int bldstId) {
        String calendarDate = DateUtil.getBeginningDate(LocalDate.now(), Constants.DAYS_BACK).toString();
        Iterable<MostPopularFoodItem> results = mostPopularFoodItemRepository
                .findByUserIdAndCalendarDateAndBldstId(
                userId, calendarDate,bldstId);
        Iterator<MostPopularFoodItem> iter = results.iterator();
        List<MostPopularFoodItemDTO> mostPopularItems = new ArrayList<>();
        while(iter.hasNext()) {
            MostPopularFoodItem item = iter.next();
            mostPopularItems.add(item.toDTO());
        }
        /**
         * now add all manual items
         */
        List<ManualFoodItemVw> manualItems = manualFoodItemVwRepository
                .findManualItemsByUserIdAndBldstId(userId,bldstId);
        for(ManualFoodItemVw item : manualItems) {
            mostPopularItems.add(convertFromManualToMostPopular(item));
        }
        return mostPopularItems;
    }

    public static MostPopularFoodItemDTO convertFromManualToMostPopular(ManualFoodItemVw item) {
        return new MostPopularFoodItemDTO(item.getUserId(), item.getBldstId(), item.getIngrId(), item.getIngr_desc(),
                item.getTotal().intValue(),item.getRecipe(), item.getLocal(), item.getNumSrv(), item.getServTypeId(),
                item.getServTypeCde());
    }
}
