package com.bankmanagement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * 
 * Data storage class for transaction
 * 
 */

public class Transaction {
	private String transactionID;
    private String fromAccountID;
    private String toAccountID;
    private LocalDateTime createdAt;
    private double amount;
    private TransactionTypes transactionType;
    private String relatedTransaction;
    
    public Transaction(String[] transaction) {
    	this.transactionID = transaction[0];
        this.fromAccountID = transaction[1];
        this.toAccountID = transaction[2];
        this.createdAt = Helper.parseDateTime(transaction[3]);
        this.amount = Double.valueOf(transaction[4].trim());
        this.transactionType = TransactionTypes.valueOf(transaction[5].trim());
        if(this.transactionType.equals(TransactionTypes.REVERSAL)) {
            this.relatedTransaction = transaction[6];
        }
    }
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getFromAccountID() {
		return fromAccountID;
	}
	public void setFromAccountID(String fromAccountID) {
		this.fromAccountID = fromAccountID;
	}
	public String getToAccountID() {
		return toAccountID;
	}
	public void setToAccountID(String toAccountID) {
		this.toAccountID = toAccountID;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public TransactionTypes getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionTypes transactionType) {
		this.transactionType = transactionType;
	}
	public String getRelatedTransaction() {
		return relatedTransaction;
	}
	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
}
