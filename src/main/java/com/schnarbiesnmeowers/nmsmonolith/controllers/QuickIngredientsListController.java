package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.QuickIngredientsListDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.QuickIngredientsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/quick-ingredients")
public class QuickIngredientsListController {

    private QuickIngredientsListService quickIngredientsListService;

    public QuickIngredientsListController(QuickIngredientsListService quickIngredientsListService) {
        this.quickIngredientsListService = quickIngredientsListService;
    }

    @GetMapping(value="/get-quick-ingredients/{bldst}/{userId}")
    public ResponseEntity<List<QuickIngredientsListDTO>> getQuickIngredientsByBldstIdAndUserId(@PathVariable int bldst,
                                                                                                      @PathVariable int userId) {
        List<QuickIngredientsListDTO> allQuickIngredientsForMealType = this.quickIngredientsListService
                .findAllQuickIngredientsForMealType(bldst, userId);
        return ResponseEntity.ok(allQuickIngredientsForMealType);
    }
}
