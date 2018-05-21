package com.walletpro.beans;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;

/* A transaction is an object that holds an amount of money moved,
 * the name of the entity that made the charge or credit, the balance
 * of the associated account after the transaction, and the
 * time stamp of the transaction.
 * 
 * It is not enough to simply update a bank account with a new balance.
 * Every change must be treated like an object, and added to a list,
 * so the user can view their transaction history.
 * 
 */
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = -1076138508446580000L;
	private final LocalDateTime timestamp;
	private final String name;
	private final double amount;
	
	// A CheckingAccount object constructs a new transaction, and passes itself
	// as a parameter, every time a deposit or withdrawal is made.
	private final CheckingAccount associatedAccount;
	private final double storedBalance;
	private NumberFormat formatter = new DecimalFormat("#0.00");
	

	public Transaction(String name, double amount, CheckingAccount associatedAccount) {
		super();
		// The time stamp is automatic. User are not allowed to set time stamps.
		this.timestamp = LocalDateTime.now();
		this.name = name;
		this.amount = amount;
		this.associatedAccount = associatedAccount;
		storedBalance = associatedAccount.getBalance(); // Take a snapshot of the updated balance
	}

	// No setters. Once a Transaction is created, the fields cannot be altered.
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		// This is all just formatting.
		String creditOrDebit;
		String sign;
		if (amount > 0) {
			creditOrDebit = "Credit";
			sign = "";
		} else {
			creditOrDebit = "Debit";
			sign = "-";
		}
		return "On: " + timestamp + " |   Item: " + name + " |  " + creditOrDebit + ": " + sign + "$"
				+ formatter.format(Math.abs(amount)) + " |  Current Balance: $" + formatter.format(storedBalance);
	}
	
	
}
