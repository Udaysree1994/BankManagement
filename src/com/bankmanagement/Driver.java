package com.bankmanagement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * Driver class to do drive the program, has the main method
 * 
 */

public class Driver {
	
	private static List<Transaction> transactions = new ArrayList<Transaction>();
	
	public static void main(String args[]) {
	
		//read csv file
		Helper.parseCsvToTransaction();

		//scanner to get user input
		Scanner scan = new Scanner(System.in).useDelimiter("\n");
		
		System.out.println("Account");
		String s = scan.nextLine();
		
		System.out.println("From");
		String from = scan.nextLine();
		
		System.out.println("To");
		String to = scan.nextLine();

		LocalDateTime fromDate = Helper.parseDateTime(from);
		LocalDateTime toDate = Helper.parseDateTime(to);
		
		ICalculator calc = new Calculator();
		//get the balance string from calculator
		String balance = calc.getRelativeBalance(transactions, s, fromDate, toDate);
		
		System.out.println(balance);
	}
	
}

