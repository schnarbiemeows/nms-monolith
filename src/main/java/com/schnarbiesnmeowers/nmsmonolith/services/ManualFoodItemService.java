package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemVwDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItem;
import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItemVw;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ManualFoodItemRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ManualFoodItemVwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManualFoodItemService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    @Autowired
    private ManualFoodItemVwRepository manualFoodItemVwRepository;

    @Autowired
    private ManualFoodItemRepository manualFoodItemRepository;

    /**
     * get all ManualFoodItem records
     * @return
     * @throws Exception
     */
    public List<ManualFoodItemVwDTO> getAllManualFoodItem(int userId) throws Exception {
        List<ManualFoodItemVw> manualFoodItemVws = manualFoodItemVwRepository.findManualItemsByUserId(userId);
        List<ManualFoodItemVwDTO>  manualFoodItemsdto = manualFoodItemVws
                .stream().map(rec -> rec.toDTO()).collect(Collectors.toList());
        return  manualFoodItemsdto;
    }

    public List<ManualFoodItemVwDTO> getAllManualFoodItemsForBldstId(int userId, int bldstId) throws Exception {
        List<ManualFoodItemVw> manualFoodItemVws = manualFoodItemVwRepository
                .findManualItemsByUserIdAndBldstId(userId, bldstId);
        List<ManualFoodItemVwDTO>  manualFoodItemsdto = manualFoodItemVws.stream()
                .map(rec -> rec.toDTO()).collect(Collectors.toList());
        return  manualFoodItemsdto;
    }

    /**
     * get ManualFoodItem by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public ManualFoodItemDTO findManualFoodItemById(int id) throws Exception {
        Optional<ManualFoodItem>  manualFoodItemsOptional = manualFoodItemRepository.findById(id);
        if( manualFoodItemsOptional.isPresent()) {
            ManualFoodItem results =  manualFoodItemsOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new ManualFoodItem
     * @param data
     * @return
     */
    public ManualFoodItemDTO createManualFoodItem(ManualFoodItemVwDTO data) {
        try {
            ManualFoodItem createdData = data.toEntity();
            createdData = manualFoodItemRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a ManualFoodItem
     * @param data
     * @return
     * @throws Exception
     */
    public ManualFoodItemDTO updateManualFoodItem(ManualFoodItemVwDTO data) throws Exception {
        Optional<ManualFoodItem>  manualFoodItemsOptional = manualFoodItemRepository.findById(data.getManualFoodItemId());
        if( manualFoodItemsOptional.isPresent()) {
            ManualFoodItem updatedData = data.toEntity();
            updatedData = manualFoodItemRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getManualFoodItemId() + NOT_FOUND);
        }
    }

    /**
     * delete a ManualFoodItem by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteManualFoodItem(int id) throws Exception {
        Optional<ManualFoodItem>  manualFoodItemsOptional = manualFoodItemRepository.findById(id);
        if( manualFoodItemsOptional.isPresent()) {
            manualFoodItemRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }
}
