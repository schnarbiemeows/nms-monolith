package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftMuscleDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lift_muscle")
public class LiftMuscle implements Serializable {

    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     *
     */
    @Column(name = "lift_muscle_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer liftMuscleId;

    @Column(name = "lift_id")
    private Integer liftId;

    @Column(name = "muscle_id")
    private Integer muscleId;
    @Column(name = "actv")
    private String actv;

    public LiftMuscle() {
    }

    public LiftMuscle(Integer liftMuscleId, Integer liftId, Integer muscleId, String actv) {
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

    public LiftMuscleDTO toDTO() {
        return new LiftMuscleDTO(this.liftMuscleId, this.liftId, this.muscleId, this.actv);
    }
}
