package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.QuickIngredientsListDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Ingredients;
import com.schnarbiesnmeowers.nmsmonolith.pojos.QuickIngredientsList;
import com.schnarbiesnmeowers.nmsmonolith.repositories.QuickIngredientsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QuickIngredientsListService {

    @Autowired
    QuickIngredientsListRepository quickIngredientsListRepository;

     public List<QuickIngredientsListDTO> findAllQuickIngredientsForMealType(int mealTypeId, int userId) {
         Iterable<QuickIngredientsList> results = quickIngredientsListRepository
                 .findAllQuickIngredientsForMealType(mealTypeId, userId);
         Iterator<QuickIngredientsList> iter = results.iterator();
         List<QuickIngredientsListDTO> dtos = new ArrayList<>();
         while(iter.hasNext()) {
             dtos.add(iter.next().toDTO());
         }
         return dtos;
     }
}
