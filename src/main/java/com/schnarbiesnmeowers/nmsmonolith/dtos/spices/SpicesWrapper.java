package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpiceRecordDisplay;

import java.util.ArrayList;
import java.util.List;

public class SpicesWrapper {

    private List<SpiceRecordDisplay> globals = new ArrayList();
    private List<SpiceRecordDisplay> locals = new ArrayList();
    private List<FavoriteSpicesDTO> favorites = new ArrayList<>();



    public SpicesWrapper() {
    }

    public SpicesWrapper(List<SpiceRecordDisplay> globals, List<SpiceRecordDisplay> locals,
                              List<FavoriteSpicesDTO> favorites) {
        this.globals = globals;
        this.locals = locals;
        this.favorites = favorites;
    }

    public List<SpiceRecordDisplay> getGlobals() {
        return globals;
    }

    public void setGlobals(List<SpiceRecordDisplay> globals) {
        this.globals = globals;
    }

    public List<SpiceRecordDisplay> getLocals() {
        return locals;
    }

    public void setLocals(List<SpiceRecordDisplay> locals) {
        this.locals = locals;
    }

    public List<FavoriteSpicesDTO> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<FavoriteSpicesDTO> favorites) {
        this.favorites = favorites;
    }

}
