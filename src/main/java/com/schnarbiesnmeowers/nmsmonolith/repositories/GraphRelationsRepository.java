package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelations;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GraphRelationsRepository extends JpaRepository<GraphRelations, Integer>{


	/**
	 * get Iterable<GraphRelations> by foreign key : graphRelationIndexId
	 * @param graphRelationIndexId
	 * @return Iterable<GraphRelations>
	*/
	public Iterable<GraphRelations> findGraphRelationsByGraphRelationIndexId(int graphRelationIndexId);

	@Query(value = "select * from graph_relations gr where gr.graph_relation_index_id = ?1 and gr.parent_node is null", nativeQuery = true)
	public Iterable<GraphRelations> findRootRelations(int graphRelationIndexId);
}
