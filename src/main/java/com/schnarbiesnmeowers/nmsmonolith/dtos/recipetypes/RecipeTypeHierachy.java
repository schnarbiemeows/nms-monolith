package com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes;

import java.util.ArrayList;
import java.util.List;

/**
 * this class contains a mapping hierarchy the represents the recipe type
 * hierarchy when searching for a recipe and dropdown options when creating a recipe
 * @author Dylan I. Kessler
 */
public class RecipeTypeHierachy {

    /**
     * 
     */
    private List<RecipeTypeDTO> rootRecipeTypes = new ArrayList<>();

    private List<RecipeDisplayType> displayValues = new ArrayList();

    public RecipeTypeHierachy() {
    }

    public RecipeTypeHierachy(List<RecipeTypeDTO> rootRecipeTypes) {
        this.rootRecipeTypes = rootRecipeTypes;
    }

    public RecipeTypeHierachy(List<RecipeTypeDTO> rootRecipeTypes, List<RecipeDisplayType> displayValues) {
        //this.rootRecipeTypes = rootRecipeTypes;
        this.displayValues = displayValues;
    }

    public List<RecipeTypeDTO> getRootRecipeTypes() {
        return rootRecipeTypes;
    }

    public void setRootRecipeTypes(List<RecipeTypeDTO> rootRecipeTypes) {
        this.rootRecipeTypes = rootRecipeTypes;
    }

    public List<RecipeDisplayType> getDisplayValues() {
        return displayValues;
    }

    public void setDisplayValues(List<RecipeDisplayType> displayValues) {
        this.displayValues = displayValues;
    }
}
