package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.ExerciseType;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Integer> {


	/**
	 * get Iterable<ExerciseType> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<ExerciseType>
	*/
	public Iterable<ExerciseType> findExerciseTypeByImageLoc(int imageLoc);
}
