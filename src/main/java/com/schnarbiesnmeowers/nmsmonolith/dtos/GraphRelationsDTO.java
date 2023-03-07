package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.GraphRelations;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GraphRelationsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer graphRelationsId;

	/**
	 * "parent relation(for all tables that have a mediumint pk)" 
	 */
	private Integer parentNode;

	/**
	 * "child relation(for all tables that have a mediumint pk)" 
	 */
	private Integer childNode;

	/**
	 * "if we want to use weighted edges&!@ or if we want each edge to have some value" 
	 */
	private String edgeVal;

	/**
	 * "if we want to use a table record reference that contains the edge data" 
	 */
	private Integer edgeFk;

	/**
	 * "child relation(for all tables that have a mediumint pk)" 
	 */
	private Integer graphRelationIndexId;

	/**
	 * "is this relation active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public GraphRelationsDTO() {
		super();
	}

	public GraphRelationsDTO(Integer graphRelationsId, Integer parentNode, Integer childNode, String edgeVal, Integer edgeFk, Integer graphRelationIndexId, String actv) {
		super();
		this.graphRelationsId = graphRelationsId;
		this.parentNode = parentNode;
		this.childNode = childNode;
		this.edgeVal = edgeVal;
		this.edgeFk = edgeFk;
		this.graphRelationIndexId = graphRelationIndexId;
		this.actv = actv;
	}

	public Integer getGraphRelationsId() {
		return graphRelationsId;
	}

	public void setGraphRelationsId(Integer graphRelationsId) {
		this.graphRelationsId=graphRelationsId;
	}

	public Integer getParentNode() {
		return parentNode;
	}

	public void setParentNode(Integer parentNode) {
		this.parentNode=parentNode;
	}

	public Integer getChildNode() {
		return childNode;
	}

	public void setChildNode(Integer childNode) {
		this.childNode=childNode;
	}

	public String getEdgeVal() {
		return edgeVal;
	}

	public void setEdgeVal(String edgeVal) {
		this.edgeVal=edgeVal;
	}

	public Integer getEdgeFk() {
		return edgeFk;
	}

	public void setEdgeFk(Integer edgeFk) {
		this.edgeFk=edgeFk;
	}

	public Integer getGraphRelationIndexId() {
		return graphRelationIndexId;
	}

	public void setGraphRelationIndexId(Integer graphRelationIndexId) {
		this.graphRelationIndexId=graphRelationIndexId;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "GraphRelationsDTO [graphRelationsId=" + graphRelationsId + ", parentNode=" + parentNode + ", childNode=" + childNode + ", edgeVal=" + edgeVal + ", edgeFk=" + edgeFk + ", graphRelationIndexId=" + graphRelationIndexId + ", actv=" + actv + "]";
	}

	public static GraphRelationsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GraphRelationsDTO.class );
	}
	public GraphRelations toEntity() {
		return new GraphRelations(this.getGraphRelationsId(),this.getParentNode(),this.getChildNode(),this.getEdgeVal(),this.getEdgeFk(),this.getGraphRelationIndexId(),this.getActv());
	}
}
