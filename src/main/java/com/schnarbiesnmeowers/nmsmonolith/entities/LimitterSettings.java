package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LimitterSettingsDTO;
import jakarta.persistence.*;
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
@Entity
@Table(name = "limitter_settings", uniqueConstraints={@UniqueConstraint( columnNames = {"url","domain"})})
public class LimitterSettings implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "setting_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer settingId;

	/**
	 * 'url' 
	 */
	@Column(name = "url")
	private String url;

	/**
	 * 'domain' 
	 */
	@Column(name = "domain")
	private String domain;

	/**
	 * 'permissions' 
	 */
	@Column(name = "permissions")
	private String permissions;

	/**
	 * 'total number of requests per second' 
	 */
	@Column(name = "totNumReqPerSec")
	private Integer totnumreqpersec;

	/**
	 * 'total window for rate limit in milliseconds' 
	 */
	@Column(name = "wndwForRateLmtInMs")
	private Integer wndwforratelmtinms;

	/**
	 * 'totalmaxbucketsize' 
	 */
	@Column(name = "totalMaxBucketSize")
	private Integer totalmaxbucketsize;

	/**
	 * 'number of requests per second per ip address' 
	 */
	@Column(name = "ipTotNumReqPerSec")
	private Integer iptotnumreqpersec;

	/**
	 * 'window for rate limit in milliseconds per ip address' 
	 */
	@Column(name = "ipWndwRtLmt")
	private Integer ipwndwrtlmt;

	/**
	 * 'max bucket size per ip address' 
	 */
	@Column(name = "ipMaxWndw")
	private Integer ipmaxwndw;

	/**
	 * 'what environment is this for?') 
	 */
	@Column(name = "environment")
	private String environment;

	/**
	 * default constructor
	 */
	public LimitterSettings() {
		super();
	}

	public LimitterSettings(Integer settingId, String url, String domain, String permissions, Integer totnumreqpersec, Integer wndwforratelmtinms, Integer totalmaxbucketsize, Integer iptotnumreqpersec, Integer ipwndwrtlmt, Integer ipmaxwndw, String environment) {
		super();
		this.settingId = settingId;
		this.url = url;
		this.domain = domain;
		this.permissions = permissions;
		this.totnumreqpersec = totnumreqpersec;
		this.wndwforratelmtinms = wndwforratelmtinms;
		this.totalmaxbucketsize = totalmaxbucketsize;
		this.iptotnumreqpersec = iptotnumreqpersec;
		this.ipwndwrtlmt = ipwndwrtlmt;
		this.ipmaxwndw = ipmaxwndw;
		this.environment = environment;
	}

	public Integer getSettingId() {
		return settingId;
	}

	public void setSettingId(Integer settingId) {
		this.settingId=settingId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url=url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain=domain;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions=permissions;
	}

	public Integer getTotnumreqpersec() {
		return totnumreqpersec;
	}

	public void setTotnumreqpersec(Integer totnumreqpersec) {
		this.totnumreqpersec=totnumreqpersec;
	}

	public Integer getWndwforratelmtinms() {
		return wndwforratelmtinms;
	}

	public void setWndwforratelmtinms(Integer wndwforratelmtinms) {
		this.wndwforratelmtinms=wndwforratelmtinms;
	}

	public Integer getTotalmaxbucketsize() {
		return totalmaxbucketsize;
	}

	public void setTotalmaxbucketsize(Integer totalmaxbucketsize) {
		this.totalmaxbucketsize=totalmaxbucketsize;
	}

	public Integer getIptotnumreqpersec() {
		return iptotnumreqpersec;
	}

	public void setIptotnumreqpersec(Integer iptotnumreqpersec) {
		this.iptotnumreqpersec=iptotnumreqpersec;
	}

	public Integer getIpwndwrtlmt() {
		return ipwndwrtlmt;
	}

	public void setIpwndwrtlmt(Integer ipwndwrtlmt) {
		this.ipwndwrtlmt=ipwndwrtlmt;
	}

	public Integer getIpmaxwndw() {
		return ipmaxwndw;
	}

	public void setIpmaxwndw(Integer ipmaxwndw) {
		this.ipmaxwndw=ipmaxwndw;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment=environment;
	}

	@Override
	public String toString() {
		return "LimitterSettings [settingId=" + settingId + ", url=" + url + ", domain=" + domain + ", permissions=" + permissions + ", totnumreqpersec=" + totnumreqpersec + ", wndwforratelmtinms=" + wndwforratelmtinms + ", totalmaxbucketsize=" + totalmaxbucketsize + ", iptotnumreqpersec=" + iptotnumreqpersec + ", ipwndwrtlmt=" + ipwndwrtlmt + ", ipmaxwndw=" + ipmaxwndw + ", environment=" + environment + "]";
	}

	public static LimitterSettings fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LimitterSettings.class );
	}
	public LimitterSettingsDTO toDTO() {
		return new LimitterSettingsDTO(this.getSettingId(),this.getUrl(),this.getDomain(),this.getPermissions(),this.getTotnumreqpersec(),this.getWndwforratelmtinms(),this.getTotalmaxbucketsize(),this.getIptotnumreqpersec(),this.getIpwndwrtlmt(),this.getIpmaxwndw(),this.getEnvironment());
	}
}
