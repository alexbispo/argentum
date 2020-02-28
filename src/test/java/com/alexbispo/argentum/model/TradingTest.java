package com.alexbispo.argentum.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

public class TradingTest {

	@Test
	public void testTradingDateShouldBeImutable1() {
		Calendar someDate = Calendar.getInstance();
		someDate.set(Calendar.DAY_OF_MONTH, 15);
		
		Trading trading = new Trading(BigDecimal.TEN, 5, someDate);
		trading.getDate().set(Calendar.DAY_OF_MONTH, 20);
		
		assertEquals(15, trading.getDate().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void testTradingDateShouldBeImutable2() {
		Calendar someDate = Calendar.getInstance();
		someDate.set(Calendar.DAY_OF_MONTH, 15);
		
		Trading trading = new Trading(BigDecimal.TEN, 5, someDate);
		someDate.set(Calendar.DAY_OF_MONTH, 20);
		
		assertEquals(15, trading.getDate().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSouldNotCreateTradingWithNullDate() {
		new Trading(BigDecimal.TEN, 5, null);
	}

}
