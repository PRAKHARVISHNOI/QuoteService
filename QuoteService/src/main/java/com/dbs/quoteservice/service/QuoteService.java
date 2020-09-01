package com.dbs.quoteservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.dbs.quoteservice.exception.QuoteServiceException;
import com.dbs.quoteservice.model.Quote;
import com.dbs.quoteservice.model.QuoteRequestDto;
import com.dbs.quoteservice.repository.QuoteRepository;
import com.dbs.quoteservice.util.HelperUtils;

/**
 * @author pvishnoi
 *
 */
@Service
@Transactional
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;

	/**
	 * @param dto
	 * @return
	 */
	public Quote addQuote(QuoteRequestDto dto) {

		if (StringUtils.isEmpty(dto.getSymbol())) {
			throw new QuoteServiceException("Symbol can't be NULL or empty...");
		}

		Quote quote = new Quote();
		quote.setSymbol(dto.getSymbol());
		quote.setSharesTraded(dto.getSharesTraded());
		quote.setPriceTraded(dto.getPriceTraded());
		quote.setChangeAmount(dto.getChangeAmount());
		quote.setChangeDirection(dto.getChangeDirection());

		try {
			quote.setTimestamp(LocalDateTime.parse(dto.getTimestamp(), HelperUtils.DATE_TIME_FORMATTER));
			return quoteRepository.save(quote);
		} catch (Exception ex) {
			throw new QuoteServiceException("Quote can't be submitted...");
		}
	}

	/**
	 * @return
	 */
	public Object getMostUsedTickerSymbols() {
		List<String> allSymbols;
		
		try {
			allSymbols = quoteRepository.findSymbols(LocalDateTime.now().minusMinutes(10l));
		} catch(Exception ex) {
			throw new QuoteServiceException("Unable to fetch symbols...");
		}

		if(CollectionUtils.isEmpty(allSymbols)) {
			return "No quotes submitted in last 10 mins...";
		}
		
		return allSymbols.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(HelperUtils.SORT_BY_VALUE.thenComparing(HelperUtils.SORT_BY_KEY))
				.limit(5)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

}