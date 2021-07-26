package com.bankmanagement;
import java.time.LocalDateTime;
import java.util.List;

/*
 * Interface for calculator class
 * 
 */
public interface ICalculator {
	String omitReversalTransactions(List<Transaction> list);
	String getRelativeBalance(List<Transaction> list, String accountID, LocalDateTime from, LocalDateTime to);
}
