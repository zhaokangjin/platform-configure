package com.platform.configure.env;

import java.io.Serializable;

public class RedisConfigure implements Serializable {
	private static final long serialVersionUID = 5863424476478833531L;
	private String ip;
	private String port;
	private String userName;
	private String password;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}