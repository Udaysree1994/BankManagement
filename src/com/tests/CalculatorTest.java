package com.tests;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bankmanagement.Calculator;
import com.bankmanagement.Driver;
import com.bankmanagement.Helper;
import com.bankmanagement.Transaction;

import junit.framework.Assert;

class CalculatorTest {

	private Calculator calc = new Calculator();
	List<Transaction> transactions = Helper.parseCsvToTransaction();
	
	@Test
	void test() {
		String s = calc.getRelativeBalance(transactions, "ACC334455", Helper.parseDateTime("20/10/2018 12:00:00"), Helper.parseDateTime("20/10/2018 19:00:00"));
		Assert.assertEquals(s, "Relative balance for the period is: -25.0\n" + 
				"Number of transactions included is: 1");
	}
	
}
