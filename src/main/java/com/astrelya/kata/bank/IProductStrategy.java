package com.astrelya.kata.bank;

import com.astrelya.kata.bank.impl.Client;

public interface IProductStrategy {
    boolean canAdd(IProduct product, Client client); // Validation
    IProduct createProduct(Double amount);

}
