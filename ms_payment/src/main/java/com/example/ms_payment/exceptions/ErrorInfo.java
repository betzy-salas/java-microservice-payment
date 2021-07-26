package com.example.ms_payment.exceptions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {

    /*@JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("uri")
    private String uriRequested;

    public ErrorInfo(int statusCode, String message, String uriRequested) {
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getUriRequested() {
        return uriRequested;
    }*/
	
	@JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("status")
    private int status;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("invalidParameters")
    private List<ErrorInfoDetails> invalidParameters;
    
    
    
	public ErrorInfo(String type, String title, int status, String uri, List<ErrorInfoDetails> invalidParameters) {
		this.type = type;
		this.title = title;
		this.status = status;
		this.uri = uri;
		this.invalidParameters = invalidParameters;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public List<ErrorInfoDetails> getInvalidParameters() {
		return invalidParameters;
	}
	public void setInvalidParameters(List<ErrorInfoDetails> invalidParameters) {
		this.invalidParameters = invalidParameters;
	}
    
    
	
}
