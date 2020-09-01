package com.dbs.quoteservice.model;

public class ErrorResponse {

	private String error;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
