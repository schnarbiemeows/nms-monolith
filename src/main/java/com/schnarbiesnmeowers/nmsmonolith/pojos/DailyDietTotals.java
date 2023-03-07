package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "daily_diet_totals")
public class DailyDietTotals implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "daily_diet_total_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dailyDietTotalId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * "fk to the bldst_table.bldst_table_id field" 
	 */
	@Column(name = "bldst_id")
	private Integer bldstId;

	/**
	 * "total killocalories" 
	 */
	@Column(name = "kcalories")
	private BigDecimal kcalories;

	/**
	 * "total fat in grams" 
	 */
	@Column(name = "tot_fat")
	private BigDecimal totFat;

	/**
	 * "total saturated fat in grams" 
	 */
	@Column(name = "sat_fat")
	private BigDecimal satFat;

	/**
	 * "total trans fat in grams" 
	 */
	@Column(name = "trans_fat")
	private BigDecimal transFat;

	/**
	 * "total polyunsaturated fat in grams" 
	 */
	@Column(name = "poly_fat")
	private BigDecimal polyFat;

	/**
	 * "total monounsaturated fat in grams" 
	 */
	@Column(name = "mono_fat")
	private BigDecimal monoFat;

	/**
	 * "total cholesterol in milligrams" 
	 */
	@Column(name = "choles")
	private BigDecimal choles;

	/**
	 * "total sodium in milligrams" 
	 */
	@Column(name = "sodium")
	private Integer sodium;

	/**
	 * "total carbohydrates in grams" 
	 */
	@Column(name = "tot_carbs")
	private BigDecimal totCarbs;

	/**
	 * "total fiber in grams" 
	 */
	@Column(name = "tot_fiber")
	private BigDecimal totFiber;

	/**
	 * "total sugars in grams" 
	 */
	@Column(name = "tot_sugars")
	private BigDecimal totSugars;

	/**
	 * "total protein in grams") 
	 */
	@Column(name = "tot_protein")
	private BigDecimal totProtein;

	/**
	 * default constructor
	 */
	public DailyDietTotals() {
		super();
	}

	public DailyDietTotals(Integer dailyDietTotalId, Integer userId, Date calendarDate, Integer bldstId,
		BigDecimal kcalories, BigDecimal totFat, BigDecimal satFat, BigDecimal transFat, BigDecimal polyFat,
		BigDecimal monoFat, BigDecimal choles, Integer sodium, BigDecimal totCarbs, BigDecimal totFiber,
		BigDecimal totSugars, BigDecimal totProtein) {
		super();
		this.dailyDietTotalId = dailyDietTotalId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.bldstId = bldstId;
		this.kcalories = kcalories;
		this.totFat = totFat;
		this.satFat = satFat;
		this.transFat = transFat;
		this.polyFat = polyFat;
		this.monoFat = monoFat;
		this.choles = choles;
		this.sodium = sodium;
		this.totCarbs = totCarbs;
		this.totFiber = totFiber;
		this.totSugars = totSugars;
		this.totProtein = totProtein;
	}

	public Integer getDailyDietTotalId() {
		return dailyDietTotalId;
	}

	public void setDailyDietTotalId(Integer dailyDietTotalId) {
		this.dailyDietTotalId=dailyDietTotalId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Date getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(Date calendarDate) {
		this.calendarDate=calendarDate;
	}

	public Integer getBldstId() {
		return bldstId;
	}

	public void setBldstId(Integer bldstId) {
		this.bldstId=bldstId;
	}

	public BigDecimal getKcalories() {
		return kcalories;
	}

	public void setKcalories(BigDecimal kcalories) {
		this.kcalories=kcalories;
	}

	public BigDecimal getTotFat() {
		return totFat;
	}

	public void setTotFat(BigDecimal totFat) {
		this.totFat=totFat;
	}

	public BigDecimal getSatFat() {
		return satFat;
	}

	public void setSatFat(BigDecimal satFat) {
		this.satFat=satFat;
	}

	public BigDecimal getTransFat() {
		return transFat;
	}

	public void setTransFat(BigDecimal transFat) {
		this.transFat=transFat;
	}

	public BigDecimal getPolyFat() {
		return polyFat;
	}

	public void setPolyFat(BigDecimal polyFat) {
		this.polyFat=polyFat;
	}

	public BigDecimal getMonoFat() {
		return monoFat;
	}

	public void setMonoFat(BigDecimal monoFat) {
		this.monoFat=monoFat;
	}

	public BigDecimal getCholes() {
		return choles;
	}

	public void setCholes(BigDecimal choles) {
		this.choles=choles;
	}

	public Integer getSodium() {
		return sodium;
	}

	public void setSodium(Integer sodium) {
		this.sodium=sodium;
	}

	public BigDecimal getTotCarbs() {
		return totCarbs;
	}

	public void setTotCarbs(BigDecimal totCarbs) {
		this.totCarbs=totCarbs;
	}

	public BigDecimal getTotFiber() {
		return totFiber;
	}

	public void setTotFiber(BigDecimal totFiber) {
		this.totFiber=totFiber;
	}

	public BigDecimal getTotSugars() {
		return totSugars;
	}

	public void setTotSugars(BigDecimal totSugars) {
		this.totSugars=totSugars;
	}

	public BigDecimal getTotProtein() {
		return totProtein;
	}

	public void setTotProtein(BigDecimal totProtein) {
		this.totProtein=totProtein;
	}

	@Override
	public String toString() {
		return "DailyDietTotals [dailyDietTotalId=" + dailyDietTotalId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", bldstId=" + bldstId + ", kcalories=" + kcalories + ", totFat=" + totFat + ", satFat=" + satFat + ", transFat=" + transFat + ", polyFat=" + polyFat + ", monoFat=" + monoFat + ", choles=" + choles + ", sodium=" + sodium + ", totCarbs=" + totCarbs + ", totFiber=" + totFiber + ", totSugars=" + totSugars + ", totProtein=" + totProtein + "]";
	}

	public static DailyDietTotals fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDietTotals.class );
	}
	public DailyDietTotalsDTO toDTO() {
		return new DailyDietTotalsDTO(this.getDailyDietTotalId(),this.getUserId(),
		this.getCalendarDate(),this.getBldstId(),this.getKcalories(),this.getTotFat(),this.getSatFat(),
		this.getTransFat(),this.getPolyFat(),this.getMonoFat(),this.getCholes(),this.getSodium(),
		this.getTotCarbs(),this.getTotFiber(),this.getTotSugars(),this.getTotProtein());
	}
}
