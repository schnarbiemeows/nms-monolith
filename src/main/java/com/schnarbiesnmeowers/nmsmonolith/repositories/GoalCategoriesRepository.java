package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalCategories;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GoalCategoriesRepository extends JpaRepository<GoalCategories, Integer> {


	/**
	 * get Iterable<GoalCategories> by foreign key : goalTypeId
	 * @param goalTypeId
	 * @return Iterable<GoalCategories>
	*/
	public Iterable<GoalCategories> findGoalCategoriesByGoalTypeId(int goalTypeId);
}
