package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.MuscleGroups;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface MuscleGroupsRepository extends JpaRepository<MuscleGroups, Integer> {

    @Query(value = "select mg.* from muscle_groups mg where mg.muscle_grp_name in(" +
            "'legs','Chest-Triceps','Back-Biceps','Shoulders-Traps-Forearms'); ",nativeQuery = true)
    public Iterable<MuscleGroups> getWeightWorkoutTypes();
}
