package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

public class WorkoutStepsFormDTO {

    private WorkoutsDTO workout;

    private Integer steps;

    public WorkoutStepsFormDTO() {
    }

    public WorkoutStepsFormDTO(WorkoutsDTO workout, Integer steps) {
        this.workout = workout;
        this.steps = steps;
    }

    public WorkoutsDTO getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutsDTO workout) {
        this.workout = workout;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "WorkoutStepsFormDTO{" +
                "workout=" + workout +
                ", steps=" + steps +
                '}';
    }
}
