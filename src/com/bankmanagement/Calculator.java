package com.bankmanagement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * This class calculates the balance by omitting reversals 
 * currently works for one reversal, can be extended to multiple reversals in future
 * 
 */

public class Calculator implements ICalculator {
	
	//omit a transaction if it has a reversal though it is outside the given time window
	public String omitReversalTransactions(List<Transaction> list) {
		
		for(Transaction t: list) {
			if(t.getRelatedTransaction()!=null) {
				if(t.getRelatedTransaction().length()>0) {
					return t.getRelatedTransaction();
				}
			}
		}
		return "";
	}
	
	//calculate relative balance by excluding reversal transactions
	public String getRelativeBalance(List<Transaction> list, String accountID, LocalDateTime from, LocalDateTime to){
		
		List<Transaction> accountList = new ArrayList<Transaction>();
		
		for(Transaction t : list) {
			if(t.getFromAccountID().equals(accountID)) {
				accountList.add(t);
			}
		}
		
		//currently getting only one reverse transaction. this can be looped for including all reversals
		String reversedTransaction = this.omitReversalTransactions(accountList);
		
		double sum = 0;
		int numberOfTransactions = 0;
		
		for(Transaction t: accountList) {
			if(!t.getTransactionID().equals(reversedTransaction)) {
				if(t.getCreatedAt().isAfter(from) && t.getCreatedAt().isBefore(to)) {
					sum += t.getAmount();
					numberOfTransactions++;
				}
			}
		}
		
		StringBuilder balanceString = new StringBuilder();
		
		balanceString.append("Relative balance for the period is: -" + sum +"\n"
						+ "Number of transactions included is: " + numberOfTransactions);
		
		return balanceString.toString();
		
	}
	
}
