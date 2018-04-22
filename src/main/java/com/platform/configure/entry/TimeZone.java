package com.platform.configure.entry;

import java.io.Serializable;
import java.util.List;

public class TimeZone implements Serializable {
	private static final long serialVersionUID = -532219243250637213L;
	private String utc;
	private String gmt;
	private List<Country> countryList;
	public String getUtc() {
		return utc;
	}
	public void setUtc(String utc) {
		this.utc = utc;
	}
	public List<Country> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	public String getGmt() {
		return gmt;
	}
	public void setGmt(String gmt) {
		this.gmt = gmt;
	}
	@Override
	public String toString() {
		return "TimeZone [utc=" + utc + ", gmt=" + gmt + ", countryList=" + countryList + "]";
	}
}
