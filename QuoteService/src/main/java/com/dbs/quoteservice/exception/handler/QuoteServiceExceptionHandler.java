package com.dbs.quoteservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dbs.quoteservice.exception.QuoteServiceException;
import com.dbs.quoteservice.model.ErrorResponse;

/**
 * @author pvishnoi
 *
 */
@ControllerAdvice(basePackages = "com.dbs.quoteservice")
public class QuoteServiceExceptionHandler {

	/**
	 * @param ex
	 * @return
	 * Handling exception and returning response as error code
	 */
	@ExceptionHandler(QuoteServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleException(QuoteServiceException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
		return errorResponse;
	}

}
