package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IClient;
import com.astrelya.kata.bank.IClientValidator;
import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.IProductStrategy;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Client implements IClient {
    private final String email;
    private Collection<IProduct> productList;
    private BigDecimal monthlyBalance;

    private final IClientValidator clientValidator;

    public Client(String email) {
        clientValidator = new ClientEmailValidator();
        if (!clientValidator.isValidEmail(email)) {
            throw new IllegalArgumentException( email + " is not a valid email");
        }
        this.email = email;
        this.productList= new HashSet<>();
        this.monthlyBalance= BigDecimal.ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Collection<IProduct> getProductList() {
        return productList;
    }

    @Override
    public BigDecimal getMonthlyBalance() {
        return monthlyBalance;
    }

    @Override
    public void addProduct(IProductStrategy strategy, Double amount) throws IllegalStateException{
        IProduct product = strategy.createProduct(amount);

        if (!strategy.canAdd(product, this)) {
            throw new IllegalArgumentException(email + " cannot have two "+product.getType());
        }

        productList.add(product);
        monthlyBalance = monthlyBalance.add(product.getMonthlyValue());
    }
}
