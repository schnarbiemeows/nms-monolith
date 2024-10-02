package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelationIndexes;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GraphRelationIndexesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer graphRelationIndexId;

	/**
	 * "should be table_name or (parent table) --> (child table)" 
	 */
	private String indexDesc;

	/**
	 * "is this relation active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public GraphRelationIndexesDTO() {
		super();
	}

	public GraphRelationIndexesDTO(Integer graphRelationIndexId, String indexDesc, String actv) {
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
		return "GraphRelationIndexesDTO [graphRelationIndexId=" + graphRelationIndexId + ", indexDesc=" + indexDesc + ", actv=" + actv + "]";
	}

	public static GraphRelationIndexesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GraphRelationIndexesDTO.class );
	}
	public GraphRelationIndexes toEntity() {
		return new GraphRelationIndexes(this.getGraphRelationIndexId(),this.getIndexDesc(),this.getActv());
	}
}
