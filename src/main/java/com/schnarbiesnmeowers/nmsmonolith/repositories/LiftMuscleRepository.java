package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.LiftMuscle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiftMuscleRepository extends JpaRepository<LiftMuscle, Integer> {

    /**
     * get Iterable<LiftMuscle> by foreign key : liftId
     * @param liftId
     * @return Iterable<LiftMuscle>
     */
    public Iterable<LiftMuscle> findLiftMuscleByLiftId(int liftId);

    /**
     * get Iterable<LiftMuscle> by foreign key : muscleId
     * @param muscleId
     * @return Iterable<LiftMuscle>
     */
    public Iterable<LiftMuscle> findLiftMuscleByMuscleId(int muscleId);
}
