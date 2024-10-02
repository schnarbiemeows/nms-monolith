package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.google.gson.Gson;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftMuscle;

public class LiftMuscleDTO {

    private Integer liftMuscleId;

    private Integer liftId;

    private Integer muscleId;
    private String actv;

    public LiftMuscleDTO() {
    }

    public LiftMuscleDTO(Integer liftMuscleId, Integer liftId, Integer muscleId, String actv) {
        this.liftMuscleId = liftMuscleId;
        this.liftId = liftId;
        this.muscleId = muscleId;
        this.actv = actv;
    }

    public Integer getLiftMuscleId() {
        return liftMuscleId;
    }

    public void setLiftMuscleId(Integer liftMuscleId) {
        this.liftMuscleId = liftMuscleId;
    }

    public Integer getLiftId() {
        return liftId;
    }

    public void setLiftId(Integer liftId) {
        this.liftId = liftId;
    }

    public Integer getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(Integer muscleId) {
        this.muscleId = muscleId;
    }

    public String getActv() {
        return actv;
    }

    public void setActv(String actv) {
        this.actv = actv;
    }

    @Override
    public String toString() {
        return "LiftMuscle{" +
                "liftMuscleId=" + liftMuscleId +
                ", liftId=" + liftId +
                ", muscleId=" + muscleId +
                ", actv='" + actv + '\'' +
                '}';
    }

    public static LiftMuscleDTO fromJson(String input) {
        Gson gson = new Gson();
        return gson.fromJson(input, LiftMuscleDTO.class);
    }

    public LiftMuscle toEntity() {
        return new LiftMuscle(this.liftMuscleId, this.liftId, this.muscleId, this.actv);
    }
}
