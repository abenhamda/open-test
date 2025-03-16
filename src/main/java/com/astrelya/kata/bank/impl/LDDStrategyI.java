package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.IProductStrategy;

public class LDDStrategyI implements IProductStrategy
{
    @Override
    public boolean canAdd(IProduct product, Client client) {
        return client.getProductList().stream()
                .noneMatch(p -> p.getType().equals(LDD.TYPE));
    }

    @Override
    public IProduct createProduct(Double amount) {
        return new LDD(amount);
    }

}
