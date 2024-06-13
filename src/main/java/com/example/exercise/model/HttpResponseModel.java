package com.example.exercise.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class HttpResponseModel {

	private boolean result;
	
	@JsonInclude(Include.NON_NULL)
	private String message;
	
	@JsonInclude(Include.NON_NULL)
	private String msgCode;
	

	@JsonInclude(Include.NON_NULL)
	private Object body;


	public boolean isResult() {
		return result;
	}


	public void setResult(boolean result) {
		this.result = result;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getMsgCode() {
		return msgCode;
	}


	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}


	public Object getBody() {
		return body;
	}


	public void setBody(Object body) {
		this.body = body;
	}
	
	
}