package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.IProductStrategy;

public class LivretAStrategyI implements IProductStrategy
{
    @Override
    public boolean canAdd(IProduct product, Client client) {
        return client.getProductList().stream()
                .noneMatch(p -> p.getType().equals(LivretA.TYPE));
    }

    @Override
    public IProduct createProduct(Double amount) {
        return new LivretA(amount);
    }

}
