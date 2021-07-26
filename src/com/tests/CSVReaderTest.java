package com.tests;
import com.bankmanagement.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class CSVReaderTest {
	@Test
	void test() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/udaysree/Desktop/EC-WS/BankManagement/src/records.csv"))) {
		    String line;
		    try {
				while ((line = br.readLine()) != null) {
				    String[] values = line.split(",");
				    transactions.add(new Transaction(values));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Assert.assertEquals(5, transactions.size());
	}

}
