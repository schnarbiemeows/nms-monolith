package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import java.io.Serializable;
import java.util.List;

public class RecipeStepsDisplay implements Serializable {

    private String stepDescription;

    public RecipeStepsDisplay() {
    }

    public RecipeStepsDisplay(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    @Override
    public String toString() {
        return "RecipeStepsDisplay{" +
                "stepDescription='" + stepDescription + '\'' +
                '}';
    }
}
