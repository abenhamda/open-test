package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import com.astrelya.kata.bank.IProduct;
import org.apache.commons.lang3.NotImplementedException;


public class LDD implements IProduct {

	private Double rate;
	private Double amount;
	public static String TYPE= "LDD";
	
	public LDD(Double amount) {
		this.rate = 1.0;
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
