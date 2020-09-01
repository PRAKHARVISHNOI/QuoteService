package com.dbs.quoteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.quoteservice.model.Quote;
import com.dbs.quoteservice.model.QuoteRequestDto;
import com.dbs.quoteservice.model.SuccessResponse;
import com.dbs.quoteservice.service.QuoteService;

/**
 * @author pvishnoi
 *
 */
@RestController
@RequestMapping(path = "/quote")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;

	/**
	 * @param quoteRequestDto
	 * @return
	 * 
	 * Method to submit quote
	 */
	@PostMapping(consumes = "application/json")
	public SuccessResponse submitQuote(@RequestBody QuoteRequestDto quoteRequestDto) {
		Quote quote = quoteService.addQuote(quoteRequestDto);
		return new SuccessResponse("Quote with Symbol " + quote.getSymbol() + " has been submitted successfully.");
	}

	/**
	 * @return
	 * 
	 * Method to get Quote
	 */
	@GetMapping
	public SuccessResponse getQuotes() {
		return new SuccessResponse(quoteService.getMostUsedTickerSymbols());
	}
}
