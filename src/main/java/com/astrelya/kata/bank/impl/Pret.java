package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import com.astrelya.kata.bank.IProduct;
import org.apache.commons.lang3.NotImplementedException;


public class Pret implements IProduct {

	private Double rate;
	private Double amount;
	public static String TYPE= "Pret";
	
	public Pret(Double amount) {
		this.rate = 2.0;
		this.amount = amount;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public Double getRate() {
		return rate;
	}
	
	public BigDecimal getMonthlyValue() {
		return BigDecimal.valueOf(-amount * (rate/100) / 12);
	}

	@Override
	public String getType() {
		return TYPE;
	}
}
