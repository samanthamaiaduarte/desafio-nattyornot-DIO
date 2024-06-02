package com.smd.exceptions;

import java.time.LocalDateTime;

public class ExceptionMessage {
	private LocalDateTime timestamp;
	private String status;
	private String error;
	
	public ExceptionMessage(LocalDateTime timestamp, String status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}
}
