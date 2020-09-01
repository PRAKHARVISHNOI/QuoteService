package com.dbs.quoteservice.model;

public class QuoteRequestDto {
	private String timestamp;
	private String symbol;
	private String sharesTraded;
	private Float priceTraded;
	private String changeDirection;
	private Float changeAmount;

	public QuoteRequestDto() {
		super();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
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
		return "QuoteRequestDto [timestamp=" + timestamp + ", symbol=" + symbol + ", sharesTraded=" + sharesTraded
				+ ", priceTraded=" + priceTraded + ", changeDirection=" + changeDirection + ", changeAmount="
				+ changeAmount + "]";
	}

}
