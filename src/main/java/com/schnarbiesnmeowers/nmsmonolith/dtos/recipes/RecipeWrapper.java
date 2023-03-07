package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import java.util.ArrayList;
import java.util.List;

public class RecipeWrapper {

    List<RecipeRecordDisplay> globals = new ArrayList();

    List<RecipeRecordDisplay> locals = new ArrayList();

    List<FavoriteRecipesDTO> favorites = new ArrayList<>();

    public RecipeWrapper() {
    }

    public RecipeWrapper(List<RecipeRecordDisplay> globals, List<RecipeRecordDisplay> locals, List<FavoriteRecipesDTO> favorites) {
        this.globals = globals;
        this.locals = locals;
        this.favorites = favorites;
    }

    public List<RecipeRecordDisplay> getGlobals() {
        return globals;
    }

    public void setGlobals(List<RecipeRecordDisplay> globals) {
        this.globals = globals;
    }

    public List<RecipeRecordDisplay> getLocals() {
        return locals;
    }

    public void setLocals(List<RecipeRecordDisplay> locals) {
        this.locals = locals;
    }

    public List<FavoriteRecipesDTO> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<FavoriteRecipesDTO> favorites) {
        this.favorites = favorites;
    }
}
