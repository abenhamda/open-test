package com.astrelya.kata.bank;

import java.math.BigDecimal;
import java.util.Collection;

public interface IClient {

	public String getEmail();
	
	public Collection<IProduct> getProductList();
	
	public BigDecimal getMonthlyBalance();
	
	public void addProduct(IProductStrategy strategy, Double amount);
}
