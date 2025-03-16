package com.astrelya.kata.bank.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Optional;

import com.astrelya.kata.bank.impl.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.astrelya.kata.bank.IBank;
import com.astrelya.kata.bank.IClient;

public class TestThirdStep {
	
	IBank bank;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		bank = new KataBank();
		bank.addClient(new Client("client1@test.com"));
		bank.addClient(new Client("client2@test.com"));
		bank.addClient(new Client("client3@test.com"));
	}

	@Test
	public void if_we_lend_15000_we_get_minus_25() {
		Optional<IClient> clientOpt = bank.searchClient("client1@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}
		
		IClient client = clientOpt.get();
		client.addProduct(new PretStrategyI(),15000.0);
		assertEquals(0,BigDecimal.valueOf(-25.0).compareTo(client.getMonthlyBalance()));
		
	}
	
	@Test
	public void monthly_should_be() {
		Optional<IClient> clientOpt = bank.searchClient("client2@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client2@test.com should exist");
		}
		
		IClient client2 = clientOpt.get();
		clientOpt = bank.searchClient("client1@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}
		
		IClient client1 = clientOpt.get();
		clientOpt = bank.searchClient("client3@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client3@test.com should exist");
		}
		
		IClient client3 = clientOpt.get();
		
		client1.addProduct(new LivretAStrategyI(),1000.0);
		client1.addProduct(new PretStrategyI(),42000.0);
		
		assertEquals(0,BigDecimal.valueOf(-69.375).compareTo(client1.getMonthlyBalance()));
		
		client2.addProduct(new LivretAStrategyI(),1000.0);
		client2.addProduct(new LDDStrategyI(),2100.0);
		client2.addProduct(new CompteAVueStrategyI(),6000.0);
		
		assertEquals(0,BigDecimal.valueOf(4.875).compareTo(client2.getMonthlyBalance()));
		
		client3.addProduct(new LivretAStrategyI(),2400.0);
		client3.addProduct(new LDDStrategyI(),9000.0);
		client3.addProduct(new CompteAVueStrategyI(),3000.0);
		client3.addProduct(new PretStrategyI(),12000.0);
		
		assertEquals(0,BigDecimal.valueOf(-9.75).compareTo(client3.getMonthlyBalance()));
		
		assertEquals(0,BigDecimal.valueOf(-74.25).compareTo(bank.getMonthlyPNL()));
		
	}
	
}
