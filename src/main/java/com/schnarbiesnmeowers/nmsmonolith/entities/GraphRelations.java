package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "graph_relations")
public class GraphRelations implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "graph_relations_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer graphRelationsId;

	/**
	 * "parent relation(for all tables that have a mediumint pk)" 
	 */
	@Column(name = "parent_node")
	private Integer parentNode;

	/**
	 * "child relation(for all tables that have a mediumint pk)" 
	 */
	@Column(name = "child_node")
	private Integer childNode;

	/**
	 * "if we want to use weighted edges&!@ or if we want each edge to have some value" 
	 */
	@Column(name = "edge_val")
	private String edgeVal;

	/**
	 * "if we want to use a table record reference that contains the edge data" 
	 */
	@Column(name = "edge_fk")
	private Integer edgeFk;

	/**
	 * "child relation(for all tables that have a mediumint pk)" 
	 */
	@Column(name = "graph_relation_index_id")
	private Integer graphRelationIndexId;

	/**
	 * "is this relation active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public GraphRelations() {
		super();
	}

	public GraphRelations(Integer graphRelationsId, Integer parentNode, Integer childNode, String edgeVal, Integer edgeFk, Integer graphRelationIndexId, String actv) {
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
		return "GraphRelations [graphRelationsId=" + graphRelationsId + ", parentNode=" + parentNode + ", childNode=" + childNode + ", edgeVal=" + edgeVal + ", edgeFk=" + edgeFk + ", graphRelationIndexId=" + graphRelationIndexId + ", actv=" + actv + "]";
	}

	public static GraphRelations fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GraphRelations.class );
	}
	public GraphRelationsDTO toDTO() {
		return new GraphRelationsDTO(this.getGraphRelationsId(),this.getParentNode(),this.getChildNode(),this.getEdgeVal(),this.getEdgeFk(),this.getGraphRelationIndexId(),this.getActv());
	}
}
