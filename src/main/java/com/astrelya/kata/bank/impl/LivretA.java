package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IProduct;

import java.math.BigDecimal;


public class LivretA implements IProduct {

	private Double rate;
	private Double amount;
	public static String TYPE= "LivretA";
	
	public LivretA(Double amount) {
		this.rate = 0.75;
		this.amount = amount;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public Double getRate() {
		return rate;
	}
	
	public BigDecimal getMonthlyValue() {
		return BigDecimal.valueOf(amount * (rate/100) / 12);
	}

	@Override
	public String getType() {
		return TYPE;
	}
}
