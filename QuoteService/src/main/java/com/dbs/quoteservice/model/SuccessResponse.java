package com.dbs.quoteservice.model;

public class SuccessResponse {
	
	private Object response;

	public SuccessResponse() {
		super();
	}

	public SuccessResponse(Object response) {
		super();
		this.response = response;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
