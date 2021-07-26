package com.bankmanagement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Helper class to parse csv and date time
 * 
 */
public class Helper {
	
	private static List<Transaction> transactions = new ArrayList<Transaction>();
	
	public static List<Transaction> parseCsvToTransaction() {
		
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
		
		return transactions;
	}
	
	public static LocalDateTime parseDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
		//System.out.println(date);
		return LocalDateTime.parse(date, formatter);
	}
}
