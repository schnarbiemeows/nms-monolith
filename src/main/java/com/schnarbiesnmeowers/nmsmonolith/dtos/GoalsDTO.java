package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Goals;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GoalsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer goalId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "short name of the goal" 
	 */
	private String goalName;

	/**
	 * "fk to the goal_categories.gc_id field" 
	 */
	private Integer gcId;

	/**
	 * "eq = equals&!@ lt = less than&!@ leq = less than or equals&!@ gt&!@ gte&!@ etc..." 
	 */
	private String comparator;

	/**
	 * "what field(weight&!@ calories) or stat are we comparing to?" 
	 */
	private String compFld;

	/**
	 * "how many times do we need to satisfy the comparison for the goal to be reached?" 
	 */
	private Integer numTimes;

	/**
	 * "how many times have we currently stisfied the comparison?" 
	 */
	private Integer timesMet;

	/**
	 * "y or n&!@ do we have to meet this comparison num_times in a row&!@ or just num_times total times?" 
	 */
	private String conseq;

	/**
	 * "y or n&!@ should we renew this goal once it's met?" 
	 */
	private String renew;

	/**
	 * "y or n&!@ have we achieved this goal?" 
	 */
	private String achieved;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public GoalsDTO() {
		super();
	}

	public GoalsDTO(Integer goalId, Integer userId, String goalName, Integer gcId, String comparator, String compFld, Integer numTimes, Integer timesMet, String conseq, String renew, String achieved, String actv) {
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
		return "GoalsDTO [goalId=" + goalId + ", userId=" + userId + ", goalName=" + goalName + ", gcId=" + gcId + ", comparator=" + comparator + ", compFld=" + compFld + ", numTimes=" + numTimes + ", timesMet=" + timesMet + ", conseq=" + conseq + ", renew=" + renew + ", achieved=" + achieved + ", actv=" + actv + "]";
	}

	public static GoalsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalsDTO.class );
	}
	public Goals toEntity() {
		return new Goals(this.getGoalId(),this.getUserId(),this.getGoalName(),this.getGcId(),this.getComparator(),this.getCompFld(),this.getNumTimes(),this.getTimesMet(),this.getConseq(),this.getRenew(),this.getAchieved(),this.getActv());
	}
}
