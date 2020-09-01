package com.dbs.quoteservice.exception;

/**
 * @author pvishnoi
 *
 */
public class QuoteServiceException extends RuntimeException {

	private static final long serialVersionUID = -680501124211226752L;

	public QuoteServiceException() {
	}

	public QuoteServiceException(String message) {
		super(message);
	}

	public QuoteServiceException(Throwable cause) {
		super(cause);
	}

	public QuoteServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuoteServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
