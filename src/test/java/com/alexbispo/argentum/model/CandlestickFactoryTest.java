package com.alexbispo.argentum.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CandlestickFactoryTest {
	
	@Test
	public void testSimpleTradingSequence() {
		Calendar today = Calendar.getInstance();
		
		Trading trading1 = new Trading(new BigDecimal("40.5"), 100, today);
		Trading trading2 = new Trading(new BigDecimal("45.0"), 100, today);
		Trading trading3 = new Trading(new BigDecimal("39.8"), 100, today);
		Trading trading4 = new Trading(new BigDecimal("42.3"), 100, today);

		List<Trading> tradingList = Arrays.asList(trading1, trading2, trading3, trading4);

		CandlestickFactory candlestickFactory = new CandlestickFactory();
		Candlestick candlestick = candlestickFactory.getInstanceAt(today, tradingList);
		
		assertEquals(today, candlestick.getDate());
		assertEquals(new BigDecimal("40.5"), candlestick.getOpeningPrice());
		assertEquals(new BigDecimal("42.3"), candlestick.getClosingPrice());
		assertEquals(new BigDecimal("39.8"), candlestick.getMinimumPrice());
		assertEquals(new BigDecimal("45.0"), candlestick.getMaximumPrice());
		assertEquals(new BigDecimal("16760.0"), candlestick.getAmount());
	}
	
	@Test
	public void testCandlestickFactoryWithoutTrading() {
		Calendar today = Calendar.getInstance();
		
		List<Trading> tradingList = Collections.emptyList();

		CandlestickFactory candlestickFactory = new CandlestickFactory();
		Candlestick candlestick = candlestickFactory.getInstanceAt(today, tradingList);
		
		assertEquals(BigDecimal.ZERO, candlestick.getOpeningPrice());
		assertEquals(BigDecimal.ZERO, candlestick.getClosingPrice());
		assertEquals(BigDecimal.ZERO, candlestick.getMaximumPrice());
		assertEquals(BigDecimal.ZERO, candlestick.getMinimumPrice());
		assertEquals(BigDecimal.ZERO, candlestick.getAmount());
	}
	
	@Test
	public void testCandlestickFactoryWithJustOneTrading() {
		Calendar today = Calendar.getInstance();
		
		Trading trading1 = new Trading(new BigDecimal("40.5"), 100, today);

		List<Trading> tradingList = Arrays.asList(trading1);

		CandlestickFactory candlestickFactory = new CandlestickFactory();
		Candlestick candlestick = candlestickFactory.getInstanceAt(today, tradingList);

		assertEquals(new BigDecimal("40.5"), candlestick.getOpeningPrice());
		assertEquals(new BigDecimal("40.5"), candlestick.getClosingPrice());
		assertEquals(new BigDecimal("40.5"), candlestick.getMinimumPrice());
		assertEquals(new BigDecimal("40.5"), candlestick.getMaximumPrice());
		assertEquals(new BigDecimal("4050.0"), candlestick.getAmount());
	}

}
