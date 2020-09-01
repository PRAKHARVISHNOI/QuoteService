package com.dbs.quoteservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbs.quoteservice.model.Quote;

/**
 * @author pvishnoi
 *
 */
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

	@Query("SELECT q.symbol FROM Quote q WHERE q.timestamp >= ?1")
	List<String> findSymbols(LocalDateTime localDateTime);

}
