package com.alexbispo.argentum.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick getInstanceAt(Calendar date, List<Trading> tradingList) {
		if (tradingList.isEmpty()) {
			return new CandlestickBuilder().build();
		}
		
		BigDecimal maximumPrice = BigDecimal.ZERO;
		BigDecimal minimumPrice = new BigDecimal(Double.MAX_VALUE);
		BigDecimal openingPrice = tradingList.get(0).getPrice();
		BigDecimal closingPrice = tradingList.get(tradingList.size() - 1).getPrice();
		BigDecimal amount = BigDecimal.ZERO;
	
		for (Trading trading : tradingList) {
			amount = amount.add(trading.getAmount());

			if (trading.getPrice().compareTo(maximumPrice) > 0) {
				maximumPrice = trading.getPrice();
			}

			if (trading.getPrice().compareTo(minimumPrice) < 0) {
				minimumPrice = trading.getPrice();
			}
		}

		return new CandlestickBuilder().atDate(date)
					.withOpeningPrice(openingPrice)
					.and().withClosingPrice(closingPrice)
					.and().withMaximumPrice(maximumPrice)
					.and().withMinimumPrice(minimumPrice)
					.and().withAmount(amount)
					.and().build();
	}
}
