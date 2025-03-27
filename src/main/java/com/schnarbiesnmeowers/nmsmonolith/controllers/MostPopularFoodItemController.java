package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MostPopularFoodItemDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.MostPopularFoodItem;
import com.schnarbiesnmeowers.nmsmonolith.services.MostPopularFoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path="/popularfooditems")
public class MostPopularFoodItemController {

    @Autowired
    private MostPopularFoodItemService mostPopularFoodItemService;

    @GetMapping(path = "/all/{userId}")
    public ResponseEntity<Map<Integer, List<MostPopularFoodItemDTO>>> getAllPopularFoodItemsForUserId(
            @PathVariable int userId) {
        Map<Integer, List<MostPopularFoodItemDTO>> results = mostPopularFoodItemService
                .findByUserIdAndCalendarDate(userId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}
