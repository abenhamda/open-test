package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IBank;
import com.astrelya.kata.bank.IClient;

import java.math.BigDecimal;
import java.util.*;

public class KataBank implements IBank {

    private final Set<IClient> clientList;

    public KataBank() {
        this.clientList = new HashSet<>();
    }

    @Override
    public Set<IClient> getClientList() {
        return clientList;
    }

    @Override
    public void addClient(IClient client) {
        if (clientList.contains(client)) {
            throw new IllegalArgumentException("Client " + client.getEmail() + " already exists");
        }
        clientList.add(client);
    }

    @Override
    public Optional<IClient> searchClient(String email) {
        return clientList.stream().filter(client -> client.getEmail().equals(email)).findFirst();
    }

    @Override
    public BigDecimal getMonthlyPNL() {
        return clientList.stream().map(IClient::getMonthlyBalance).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
