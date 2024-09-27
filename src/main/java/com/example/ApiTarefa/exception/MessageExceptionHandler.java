package com.example.ApiTarefa.exception;

import java.util.Date;

// Objeto de mensagem de erro 
public class MessageExceptionHandler {

	private Date timestamp;
	private Integer status;
	private String message;
	
	
	public MessageExceptionHandler() {
	}

	public MessageExceptionHandler(Date timestamp, Integer status, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
