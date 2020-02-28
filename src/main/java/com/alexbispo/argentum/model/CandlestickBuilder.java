package com.alexbispo.argentum.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class CandlestickBuilder {

	private BigDecimal openingPrice = BigDecimal.ZERO;
	private BigDecimal closingPrice = BigDecimal.ZERO;
	private BigDecimal minimumPrice = BigDecimal.ZERO;
	private BigDecimal maximumPrice = BigDecimal.ZERO;
	private BigDecimal amount = BigDecimal.ZERO;
	private Calendar date;
	
	public CandlestickBuilder and() {
		return this;
	}

	public CandlestickBuilder withOpeningPrice(BigDecimal openingPrice) {
		this.openingPrice = openingPrice;
		return this;
	}

	public CandlestickBuilder withClosingPrice(BigDecimal closingPrice) {
		this.closingPrice = closingPrice;
		return this;
	}

	public CandlestickBuilder withMinimumPrice(BigDecimal minimumPrice) {
		this.minimumPrice = minimumPrice;
		return this;
	}

	public CandlestickBuilder withMaximumPrice(BigDecimal maximumPrice) {
		this.maximumPrice = maximumPrice;
		return this;
	}

	public CandlestickBuilder withAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public CandlestickBuilder atDate(Calendar date) {
		this.date = date;
		return this;
	}

	public Candlestick build() {
		return new Candlestick(openingPrice, closingPrice, minimumPrice, maximumPrice, amount, date);
	}

}
