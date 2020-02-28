package com.alexbispo.argentum.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickTest {

	public static void main(String[] args) {
		testCandlestickFactory();
		
		System.out.println("\n");
		
		testCandlestickFactoryWithJustOneTrading();
		
		System.out.println("\n");
		
		testCandlestickFactoryWithoutTrading();
	}
	
	public static void testCandlestickFactory() {
		System.out.println("=================== testCandlestickFactory ===================");
		
		Calendar today = Calendar.getInstance();
		
		Trading trading1 = new Trading(new BigDecimal("40.5"), 100, today);
		Trading trading2 = new Trading(new BigDecimal("45.0"), 100, today);
		Trading trading3 = new Trading(new BigDecimal("39.8"), 100, today);
		Trading trading4 = new Trading(new BigDecimal("42.3"), 100, today);

		List<Trading> tradingList = Arrays.asList(trading1, trading2, trading3, trading4);

		CandlestickFactory candlestickFactory = new CandlestickFactory();
		Candlestick candlestick = candlestickFactory.getInstanceAt(today, tradingList);

		System.out.println(candlestick);
	}
	
	public static void testCandlestickFactoryWithJustOneTrading() {
		System.out.println("=================== testCandlestickFactoryWithJustOneTrading ===================");
		
		Calendar today = Calendar.getInstance();
		
		Trading trading1 = new Trading(new BigDecimal("40.5"), 100, today);

		List<Trading> tradingList = Arrays.asList(trading1);

		CandlestickFactory candlestickFactory = new CandlestickFactory();
		Candlestick candlestick = candlestickFactory.getInstanceAt(today, tradingList);

		System.out.println(candlestick);
		
	}
	
	public static void testCandlestickFactoryWithoutTrading() {
		System.out.println("=================== testCandlestickFactoryWithoutTrading ===================");
		
		Calendar today = Calendar.getInstance();
		
		List<Trading> tradingList = Collections.emptyList();

		CandlestickFactory candlestickFactory = new CandlestickFactory();
		Candlestick candlestick = candlestickFactory.getInstanceAt(today, tradingList);

		System.out.println(candlestick);
	}

}
