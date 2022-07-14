package com.shoes_store.lenhan.dto;

import java.time.LocalDateTime;

public class AuditLogDTO {
	private String message;
	private LocalDateTime datetime;
	public AuditLogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuditLogDTO(String message, LocalDateTime datetime) {
		super();
		this.message = message;
		this.datetime = datetime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
}
