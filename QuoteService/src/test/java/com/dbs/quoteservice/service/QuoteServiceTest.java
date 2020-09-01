package com.dbs.quoteservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbs.quoteservice.QuoteServiceApplication;
import com.dbs.quoteservice.exception.QuoteServiceException;
import com.dbs.quoteservice.model.Quote;
import com.dbs.quoteservice.model.QuoteRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuoteServiceApplication.class)
public class QuoteServiceTest {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
			.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

	@Autowired
	private QuoteService quoteService;

	@Test
	@Order(1)
	public void shouldThrowExceptionIfSymbolIsNullOrBlank() {

		QuoteRequestDto dto = new QuoteRequestDto();
		dto.setSymbol("");
		dto.setSharesTraded("5k");
		dto.setPriceTraded(30.45f);
		dto.setChangeDirection("up");
		dto.setChangeAmount(0.19f);
		dto.setTimestamp("2020-08-31T18:25:43.515Z");

		try {
			quoteService.addQuote(dto);
		} catch (QuoteServiceException ex) {
			assertEquals("Symbol can't be NULL or empty...", ex.getMessage());
		}
	}

	@Test
	@Order(2)
	public void shouldThrowExceptionIfTimestampFormatIsNotCorrect() {

		QuoteRequestDto dto = new QuoteRequestDto();
		dto.setSymbol("D05.SI");
		dto.setSharesTraded("5k");
		dto.setPriceTraded(30.45f);
		dto.setChangeDirection("up");
		dto.setChangeAmount(0.19f);
		dto.setTimestamp("2020-08-31T18:25.515Z");

		try {
			quoteService.addQuote(dto);
		} catch (QuoteServiceException ex) {
			assertEquals("Quote can't be submitted...", ex.getMessage());
		}
	}

	@Test
	@Order(3)
	public void testMessageWithNoSymblosInLast10Mins() {
		String message = (String) quoteService.getMostUsedTickerSymbols();
		assertEquals("No quotes submitted in last 10 mins...", message);
	}

	@Test
	@Order(4)
	public void testAddQuote() {

		QuoteRequestDto dto = new QuoteRequestDto();
		dto.setSymbol("D05.SI");
		dto.setSharesTraded("5k");
		dto.setPriceTraded(30.45f);
		dto.setChangeDirection("up");
		dto.setChangeAmount(0.19f);
		dto.setTimestamp(LocalDateTime.now().format(DATE_TIME_FORMATTER) + "Z");

		Quote quote = quoteService.addQuote(dto);
		assertEquals("D05.SI", quote.getSymbol());
	}

	@Test
	@Order(5)
	public void testAddAnotherQuote() {

		QuoteRequestDto dto = new QuoteRequestDto();
		dto.setSymbol("D05.SP");
		dto.setSharesTraded("5k");
		dto.setPriceTraded(30.45f);
		dto.setChangeDirection("up");
		dto.setChangeAmount(0.19f);
		dto.setTimestamp(LocalDateTime.now().minusMinutes(9L).format(DATE_TIME_FORMATTER) + "Z");

		Quote quote = quoteService.addQuote(dto);
		assertEquals("D05.SP", quote.getSymbol());
	}

	@Test
	@Order(6)
	public void testAddAnotherQuote2() {

		QuoteRequestDto dto = new QuoteRequestDto();
		dto.setSymbol("D05.SP");
		dto.setSharesTraded("5k");
		dto.setPriceTraded(30.45f);
		dto.setChangeDirection("up");
		dto.setChangeAmount(0.19f);
		dto.setTimestamp(LocalDateTime.now().minusMinutes(9L).format(DATE_TIME_FORMATTER) + "Z");

		Quote quote = quoteService.addQuote(dto);
		assertEquals("D05.SP", quote.getSymbol());
	}

	@SuppressWarnings("unchecked")
	@Test
	@Order(7)
	public void testMostUsedSymbols() {
		List<String> symbols = (List<String>) quoteService.getMostUsedTickerSymbols();
		assertEquals(2, symbols.size());
	}

}
