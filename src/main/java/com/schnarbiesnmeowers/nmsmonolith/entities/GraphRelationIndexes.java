package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationIndexesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "graph_relation_indexes")
public class GraphRelationIndexes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "graph_relation_index_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer graphRelationIndexId;

	/**
	 * "should be table_name or (parent table) --> (child table)" 
	 */
	@Column(name = "index_desc")
	private String indexDesc;

	/**
	 * "is this relation active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public GraphRelationIndexes() {
		super();
	}

	public GraphRelationIndexes(Integer graphRelationIndexId, String indexDesc, String actv) {
		super();
		this.graphRelationIndexId = graphRelationIndexId;
		this.indexDesc = indexDesc;
		this.actv = actv;
	}

	public Integer getGraphRelationIndexId() {
		return graphRelationIndexId;
	}

	public void setGraphRelationIndexId(Integer graphRelationIndexId) {
		this.graphRelationIndexId=graphRelationIndexId;
	}

	public String getIndexDesc() {
		return indexDesc;
	}

	public void setIndexDesc(String indexDesc) {
		this.indexDesc=indexDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "GraphRelationIndexes [graphRelationIndexId=" + graphRelationIndexId + ", indexDesc=" + indexDesc + ", actv=" + actv + "]";
	}

	public static GraphRelationIndexes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GraphRelationIndexes.class );
	}
	public GraphRelationIndexesDTO toDTO() {
		return new GraphRelationIndexesDTO(this.getGraphRelationIndexId(),this.getIndexDesc(),this.getActv());
	}
}
