package com.schnarbiesnmeowers.nmsmonolith.dtos.brands;

import java.util.ArrayList;
import java.util.List;

public class BrandsWrapper {

    private List<BrandRecordDisplay> globals = new ArrayList();
    private List<BrandRecordDisplay> locals = new ArrayList();
    private List<FavoriteBrandsDTO> favorites = new ArrayList<>();

    public BrandsWrapper() {
    }

    public BrandsWrapper(List<BrandRecordDisplay> globals, List<BrandRecordDisplay> locals, List<FavoriteBrandsDTO> favorites) {
        this.globals = globals;
        this.locals = locals;
        this.favorites = favorites;
    }

    public List<BrandRecordDisplay> getGlobals() {
        return globals;
    }

    public void setGlobals(List<BrandRecordDisplay> globals) {
        this.globals = globals;
    }

    public List<BrandRecordDisplay> getLocals() {
        return locals;
    }

    public void setLocals(List<BrandRecordDisplay> locals) {
        this.locals = locals;
    }

    public List<FavoriteBrandsDTO> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<FavoriteBrandsDTO> favorites) {
        this.favorites = favorites;
    }
}
