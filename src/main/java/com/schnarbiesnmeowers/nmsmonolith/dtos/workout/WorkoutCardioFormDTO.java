package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

public class WorkoutCardioFormDTO {

    private WorkoutsDTO workout;

    private Integer cardioType;

    public WorkoutCardioFormDTO() {
    }

    public WorkoutCardioFormDTO(WorkoutsDTO workout, Integer cardioType) {
        this.workout = workout;
        this.cardioType = cardioType;
    }

    public WorkoutsDTO getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutsDTO workout) {
        this.workout = workout;
    }

    public Integer getCardioType() {
        return cardioType;
    }

    public void setCardioType(Integer cardioType) {
        this.cardioType = cardioType;
    }

    @Override
    public String toString() {
        return "WorkoutStepsFormDTO{" +
                "workout=" + workout +
                ", steps=" + cardioType +
                '}';
    }
}
