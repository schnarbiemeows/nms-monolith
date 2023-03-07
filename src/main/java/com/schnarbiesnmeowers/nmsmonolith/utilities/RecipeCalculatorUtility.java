package com.schnarbiesnmeowers.nmsmonolith.utilities;

import com.schnarbiesnmeowers.nmsmonolith.pojos.ServingTypeRatios;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeRatiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RecipeCalculatorUtility {

    public static Map<Integer, Map<Integer, BigDecimal>> ratios = null;
    @Autowired
    private ServingTypeRatiosRepository servingTypeRatiosRepository;

    private void initialize() {
        ratios = new HashMap();
        System.out.println("************************** populating ServingTypeRatios map **************************");
        List<ServingTypeRatios> ratioRecords = servingTypeRatiosRepository.findAllAndOrder();
        ratioRecords.forEach(rec -> {
            if(ratios.containsKey(rec.getServTypeId1())) {
                Map<Integer, BigDecimal> innerMap = ratios.get(rec.getServTypeId1());
                innerMap.put(rec.getServTypeId2(),rec.getRatio());
            } else {
                Map<Integer, BigDecimal> innerMap = new HashMap();
                innerMap.put(rec.getServTypeId2(),rec.getRatio());
                ratios.put(rec.getServTypeId1(),innerMap);
            }
        });
        System.out.println("************************** populating ServingTypeRatios map **************************");
    }

    public boolean hasRatio(Integer servingSizeGiven, Integer servingSizeFromRecord) {
        if(ratios==null) {
            initialize();
        }
        Map<Integer, BigDecimal> innerMap = ratios.get(servingSizeGiven);
        if(innerMap!=null&&innerMap.containsKey(servingSizeFromRecord)) {
            return true;
        }
        return false;
    }

    public BigDecimal getRatio(Integer servingSizeGiven, Integer servingSizeFromRecord) {
        Map<Integer, BigDecimal> innerMap = ratios.get(servingSizeGiven);
        if(innerMap.containsKey(servingSizeFromRecord)) {
            return innerMap.get(servingSizeFromRecord);
        }
        return BigDecimal.ZERO;
    }

    public boolean hasFittingRatios(Integer servingSizeGiven, Integer servingSizeFromRecord) {
        if(ratios==null) {
            initialize();
        }
        Map<Integer, BigDecimal> innerMap1 = ratios.get(servingSizeGiven);
        Map<Integer, BigDecimal> innerMap2 = ratios.get(servingSizeFromRecord);
        if(innerMap1!=null&&innerMap2!=null) {
            for (Integer key : innerMap1.keySet()) {
                if (innerMap2.containsKey(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal findFittingRatio(Integer servingSizeGiven, Integer servingSizeFromRecord) {
        Map<Integer, BigDecimal> innerMap1 = ratios.get(servingSizeGiven);
        Map<Integer, BigDecimal> innerMap2 = ratios.get(servingSizeFromRecord);
        for (Integer key : innerMap1.keySet()) {
            if (innerMap2.containsKey(key)) {
                BigDecimal multiplier = innerMap2.get(key);
                BigDecimal m1 = innerMap1.get(key).divide(multiplier,6, RoundingMode.HALF_UP);
                System.out.println("MULTIPLIER = " + m1);
                return m1;
            }
        }
        return BigDecimal.ZERO;
    }

}
