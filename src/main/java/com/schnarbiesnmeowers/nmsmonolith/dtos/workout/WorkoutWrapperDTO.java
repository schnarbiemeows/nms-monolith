package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

public class WorkoutWrapperDTO {

    private Integer workoutType;

    private WorkoutWeightsFormDTO workoutWeightsFormDTO = null;

    private WorkoutStepsFormDTO workoutStepsFormDTO = null;

    private WorkoutCardioFormDTO workoutCardioFormDTO = null;

    public WorkoutWrapperDTO() {
    }

    public WorkoutWrapperDTO(Integer workoutType, WorkoutWeightsFormDTO workoutWeightsFormDTO, WorkoutStepsFormDTO workoutStepsFormDTO, WorkoutCardioFormDTO workoutCardioFormDTO) {
        this.workoutType = workoutType;
        this.workoutWeightsFormDTO = workoutWeightsFormDTO;
        this.workoutStepsFormDTO = workoutStepsFormDTO;
        this.workoutCardioFormDTO = workoutCardioFormDTO;
    }

    public Integer getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(Integer workoutType) {
        this.workoutType = workoutType;
    }

    public WorkoutWeightsFormDTO getWorkoutWeightsFormDTO() {
        return workoutWeightsFormDTO;
    }

    public void setWorkoutWeightsFormDTO(WorkoutWeightsFormDTO workoutWeightsFormDTO) {
        this.workoutWeightsFormDTO = workoutWeightsFormDTO;
    }

    public WorkoutStepsFormDTO getWorkoutStepsFormDTO() {
        return workoutStepsFormDTO;
    }

    public void setWorkoutStepsFormDTO(WorkoutStepsFormDTO workoutStepsFormDTO) {
        this.workoutStepsFormDTO = workoutStepsFormDTO;
    }

    public WorkoutCardioFormDTO getWorkoutCardioFormDTO() {
        return workoutCardioFormDTO;
    }

    public void setWorkoutCardioFormDTO(WorkoutCardioFormDTO workoutCardioFormDTO) {
        this.workoutCardioFormDTO = workoutCardioFormDTO;
    }

    @Override
    public String toString() {
        return "WorkoutWrapperDTO{" +
                "workoutType=" + workoutType +
                ", weightWorkout=" + workoutWeightsFormDTO +
                ", stepWorkout=" + workoutStepsFormDTO +
                ", cardioWorkout=" + workoutCardioFormDTO +
                '}';
    }
}
