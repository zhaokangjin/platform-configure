package com.platform.configure.env;

import java.io.Serializable;

public class LogConfigure implements Serializable{

	private static final long serialVersionUID = 9097026710057996212L;
	private String maxDay;
	private String fileSize;
	private String pattern;
	private String logPath;
	private String fileNamePattern;
	public String getMaxDay() {
		return maxDay;
	}
	public void setMaxDay(String maxDay) {
		this.maxDay = maxDay;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	public String getFileNamePattern() {
		return fileNamePattern;
	}
	public void setFileNamePattern(String fileNamePattern) {
		this.fileNamePattern = fileNamePattern;
	}
}
