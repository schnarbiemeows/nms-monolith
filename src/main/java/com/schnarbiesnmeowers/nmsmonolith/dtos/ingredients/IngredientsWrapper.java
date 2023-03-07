package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients;

import java.util.ArrayList;
import java.util.List;

public class IngredientsWrapper {

    private List<IngredientRecordDisplay> globals = new ArrayList();
    private List<IngredientRecordDisplay> locals = new ArrayList();
    private List<FavoriteIngredientsDTO> favorites = new ArrayList<>();

    /**
     * we need this value because every recipe has its nutritional information saved
     * as either an ingredients record or a local_ingredients record. for these records,
     * the ingr_type_id = the record in the ingredient_types table where the description = 'recipe'
     * so, knowing this record's PK will enable us to tell the user which items in the
     * ingredients lists are recipes. We can also use this value to filter out recipes
     * from the ingredient lists.
     */
    private Integer recipeIngredientTypePK = null;

    public IngredientsWrapper() {
    }

    public IngredientsWrapper(List<IngredientRecordDisplay> globals, List<IngredientRecordDisplay> locals,
                              List<FavoriteIngredientsDTO> favorites, Integer recipeIngredientTypePK) {
        this.globals = globals;
        this.locals = locals;
        this.favorites = favorites;
        this.recipeIngredientTypePK = recipeIngredientTypePK;
    }

    public List<IngredientRecordDisplay> getGlobals() {
        return globals;
    }

    public void setGlobals(List<IngredientRecordDisplay> globals) {
        this.globals = globals;
    }

    public List<IngredientRecordDisplay> getLocals() {
        return locals;
    }

    public void setLocals(List<IngredientRecordDisplay> locals) {
        this.locals = locals;
    }

    public List<FavoriteIngredientsDTO> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<FavoriteIngredientsDTO> favorites) {
        this.favorites = favorites;
    }

    public Integer getRecipeIngredientTypePK() {
        return recipeIngredientTypePK;
    }

    public void setRecipeIngredientTypePK(Integer recipeIngredientTypePK) {
        this.recipeIngredientTypePK = recipeIngredientTypePK;
    }
}
