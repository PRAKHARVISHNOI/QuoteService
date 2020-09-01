package com.dbs.quoteservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUOTES")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "timestamp")
	private LocalDateTime timestamp;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "shares_traded")
	private String sharesTraded;

	@Column(name = "price_traded")
	private Float priceTraded;

	@Column(name = "change_direction")
	private String changeDirection;

	@Column(name = "change_amount")
	private Float changeAmount;

	public Quote() {
		super();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSharesTraded() {
		return sharesTraded;
	}

	public void setSharesTraded(String sharesTraded) {
		this.sharesTraded = sharesTraded;
	}

	public Float getPriceTraded() {
		return priceTraded;
	}

	public void setPriceTraded(Float priceTraded) {
		this.priceTraded = priceTraded;
	}

	public String getChangeDirection() {
		return changeDirection;
	}

	public void setChangeDirection(String changeDirection) {
		this.changeDirection = changeDirection;
	}

	public Float getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(Float changeAmount) {
		this.changeAmount = changeAmount;
	}

	@Override
	public String toString() {
		return "Quote [timestamp=" + timestamp + ", symbol=" + symbol + ", sharesTraded=" + sharesTraded
				+ ", priceTraded=" + priceTraded + ", changeDirection=" + changeDirection + ", changeAmount="
				+ changeAmount + "]";
	}

}
