package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.LimitterSettings;
import jakarta.validation.constraints.*;
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
public class LimitterSettingsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer settingId;

	/**
	 * 'url' 
	 */
	private String url;

	/**
	 * 'domain' 
	 */
	private String domain;

	/**
	 * 'permissions' 
	 */
	private String permissions;

	/**
	 * 'total number of requests per second' 
	 */
	private Integer totnumreqpersec;

	/**
	 * 'total window for rate limit in milliseconds' 
	 */
	private Integer wndwforratelmtinms;

	/**
	 * 'totalmaxbucketsize' 
	 */
	private Integer totalmaxbucketsize;

	/**
	 * 'number of requests per second per ip address' 
	 */
	private Integer iptotnumreqpersec;

	/**
	 * 'window for rate limit in milliseconds per ip address' 
	 */
	private Integer ipwndwrtlmt;

	/**
	 * 'max bucket size per ip address' 
	 */
	private Integer ipmaxwndw;

	/**
	 * 'what environment is this for?') 
	 */
	private String environment;

	/**
	 * default constructor
	 */
	public LimitterSettingsDTO() {
		super();
	}

	public LimitterSettingsDTO(Integer settingId, String url, String domain, String permissions, Integer totnumreqpersec, Integer wndwforratelmtinms, Integer totalmaxbucketsize, Integer iptotnumreqpersec, Integer ipwndwrtlmt, Integer ipmaxwndw, String environment) {
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
		return "LimitterSettingsDTO [settingId=" + settingId + ", url=" + url + ", domain=" + domain + ", permissions=" + permissions + ", totnumreqpersec=" + totnumreqpersec + ", wndwforratelmtinms=" + wndwforratelmtinms + ", totalmaxbucketsize=" + totalmaxbucketsize + ", iptotnumreqpersec=" + iptotnumreqpersec + ", ipwndwrtlmt=" + ipwndwrtlmt + ", ipmaxwndw=" + ipmaxwndw + ", environment=" + environment + "]";
	}

	public static LimitterSettingsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LimitterSettingsDTO.class );
	}
	public LimitterSettings toEntity() {
		return new LimitterSettings(this.getSettingId(),this.getUrl(),this.getDomain(),this.getPermissions(),this.getTotnumreqpersec(),this.getWndwforratelmtinms(),this.getTotalmaxbucketsize(),this.getIptotnumreqpersec(),this.getIpwndwrtlmt(),this.getIpmaxwndw(),this.getEnvironment());
	}
}
