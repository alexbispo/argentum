package com.alexbispo.argentum.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Trading {
	
	private final BigDecimal price;
	private final Integer quantity;
	private final Calendar date;
	
	public Trading(BigDecimal price, Integer quantity, Calendar date) {
		if (date == null) {
			throw new IllegalArgumentException("date must not be null");
		}
		
		this.price = price;
		this.quantity = quantity;
		this.date = (Calendar) date.clone();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Calendar getDate() {
		return (Calendar) date.clone();
	}
	
	public BigDecimal getAmount() {
		return price.multiply(new BigDecimal(quantity));
	}
	
}
