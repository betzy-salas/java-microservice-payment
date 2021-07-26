package com.example.ms_payment.exceptions;

public class ErrorInfoDetails {
	private String name;
	private String reason;
	
	public ErrorInfoDetails(String name, String reason) {
		super();
		this.name = name;
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
