package com.schnarbiesnmeowers.nmsmonolith.entities;

public enum MacroType {

    tot_protein("tot_protein"),
    tot_fat("tot_fat"),
    mono_fat("mono_fat"),
    tot_carbs("tot_carbs"),
    tot_fiber("tot_fiber"),
    tot_sugars("tot_sugars");

    final String value;

    MacroType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean rankByInEnums(String rankBy) {
        for (MacroType e : MacroType.values()) {
            if (e.getValue().equals(rankBy)) {
                return true;
            }
        }
        return false;
    }
}
