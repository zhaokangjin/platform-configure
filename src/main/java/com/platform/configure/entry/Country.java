package com.platform.configure.entry;

import java.io.Serializable;

public class Country implements Serializable{
	private static final long serialVersionUID = -6001631830791253548L;
	private String cnName;
	private String enName;
	private String enFullName;
	private String code;
	private String codeThree;
	private String tel;
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getEnFullName() {
		return enFullName;
	}
	public void setEnFullName(String enFullName) {
		this.enFullName = enFullName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeThree() {
		return codeThree;
	}
	public void setCodeThree(String codeThree) {
		this.codeThree = codeThree;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Country [cnName=" + cnName + ", enName=" + enName + ", enFullName=" + enFullName + ", code=" + code + ", codeThree=" + codeThree + ", tel=" + tel + "]";
	}

}
