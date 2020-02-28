package com.alexbispo.argentum.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Candlestick {

	private final BigDecimal openingPrice;
	private final BigDecimal closingPrice;
	private final BigDecimal minimumPrice;
	private final BigDecimal maximumPrice;
	private final BigDecimal amount;
	private final Calendar date;

	public Candlestick(BigDecimal openingPrice, BigDecimal closingPrice, BigDecimal minimumPrice,
			BigDecimal maximumPrice, BigDecimal amount, Calendar date) {
		this.openingPrice = openingPrice;
		this.closingPrice = closingPrice;
		this.minimumPrice = minimumPrice;
		this.maximumPrice = maximumPrice;
		this.amount = amount;
		this.date = date;
	}

	public BigDecimal getOpeningPrice() {
		return openingPrice;
	}

	public BigDecimal getClosingPrice() {
		return closingPrice;
	}

	public BigDecimal getMinimumPrice() {
		return minimumPrice;
	}

	public BigDecimal getMaximumPrice() {
		return maximumPrice;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Calendar getDate() {
		return date;
	}

	public boolean isHigh() {
		return this.closingPrice.compareTo(this.openingPrice) > 0;
	}

	public boolean isLow() {
		return this.closingPrice.compareTo(this.openingPrice) < 0;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String textDate = dateFormat.format(this.date.getTime());

		Locale customLocale = new Locale("pt", "PT");
		DecimalFormat decimalFormat = new DecimalFormat("€#,##0.00", DecimalFormatSymbols.getInstance(customLocale));

		return String.format("[Opening: %s; Closing: %s; Minimum: %s; Maximum: %s; Amount: %s; Date: %s]",
				decimalFormat.format(openingPrice), decimalFormat.format(closingPrice),
				decimalFormat.format(minimumPrice), decimalFormat.format(maximumPrice), decimalFormat.format(amount),
				textDate);
	}

}
