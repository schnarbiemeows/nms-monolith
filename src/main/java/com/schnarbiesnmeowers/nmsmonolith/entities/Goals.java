package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalsDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "goals")
public class Goals implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "goal_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer goalId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "short name of the goal" 
	 */
	@Column(name = "goal_name")
	private String goalName;

	/**
	 * "fk to the goal_categories.gc_id field" 
	 */
	@Column(name = "gc_id")
	private Integer gcId;

	/**
	 * "eq = equals&!@ lt = less than&!@ leq = less than or equals&!@ gt&!@ gte&!@ etc..." 
	 */
	@Column(name = "comparator")
	private String comparator;

	/**
	 * "what field(weight&!@ calories) or stat are we comparing to?" 
	 */
	@Column(name = "comp_fld")
	private String compFld;

	/**
	 * "how many times do we need to satisfy the comparison for the goal to be reached?" 
	 */
	@Column(name = "num_times")
	private Integer numTimes;

	/**
	 * "how many times have we currently stisfied the comparison?" 
	 */
	@Column(name = "times_met")
	private Integer timesMet;

	/**
	 * "y or n&!@ do we have to meet this comparison num_times in a row&!@ or just num_times total times?" 
	 */
	@Column(name = "conseq")
	private String conseq;

	/**
	 * "y or n&!@ should we renew this goal once it's met?" 
	 */
	@Column(name = "renew")
	private String renew;

	/**
	 * "y or n&!@ have we achieved this goal?" 
	 */
	@Column(name = "achieved")
	private String achieved;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Goals() {
		super();
	}

	public Goals(Integer goalId, Integer userId, String goalName, Integer gcId, String comparator, String compFld, Integer numTimes, Integer timesMet, String conseq, String renew, String achieved, String actv) {
		super();
		this.goalId = goalId;
		this.userId = userId;
		this.goalName = goalName;
		this.gcId = gcId;
		this.comparator = comparator;
		this.compFld = compFld;
		this.numTimes = numTimes;
		this.timesMet = timesMet;
		this.conseq = conseq;
		this.renew = renew;
		this.achieved = achieved;
		this.actv = actv;
	}

	public Integer getGoalId() {
		return goalId;
	}

	public void setGoalId(Integer goalId) {
		this.goalId=goalId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName=goalName;
	}

	public Integer getGcId() {
		return gcId;
	}

	public void setGcId(Integer gcId) {
		this.gcId=gcId;
	}

	public String getComparator() {
		return comparator;
	}

	public void setComparator(String comparator) {
		this.comparator=comparator;
	}

	public String getCompFld() {
		return compFld;
	}

	public void setCompFld(String compFld) {
		this.compFld=compFld;
	}

	public Integer getNumTimes() {
		return numTimes;
	}

	public void setNumTimes(Integer numTimes) {
		this.numTimes=numTimes;
	}

	public Integer getTimesMet() {
		return timesMet;
	}

	public void setTimesMet(Integer timesMet) {
		this.timesMet=timesMet;
	}

	public String getConseq() {
		return conseq;
	}

	public void setConseq(String conseq) {
		this.conseq=conseq;
	}

	public String getRenew() {
		return renew;
	}

	public void setRenew(String renew) {
		this.renew=renew;
	}

	public String getAchieved() {
		return achieved;
	}

	public void setAchieved(String achieved) {
		this.achieved=achieved;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "Goals [goalId=" + goalId + ", userId=" + userId + ", goalName=" + goalName + ", gcId=" + gcId + ", comparator=" + comparator + ", compFld=" + compFld + ", numTimes=" + numTimes + ", timesMet=" + timesMet + ", conseq=" + conseq + ", renew=" + renew + ", achieved=" + achieved + ", actv=" + actv + "]";
	}

	public static Goals fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Goals.class );
	}
	public GoalsDTO toDTO() {
		return new GoalsDTO(this.getGoalId(),this.getUserId(),this.getGoalName(),this.getGcId(),this.getComparator(),this.getCompFld(),this.getNumTimes(),this.getTimesMet(),this.getConseq(),this.getRenew(),this.getAchieved(),this.getActv());
	}
}
