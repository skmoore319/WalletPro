package com.walletpro.beans;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.walletpro.helpers.Authenticator;

public class CheckingAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7229169979532625566L;
	private static int numberOfAccounts = 0;
	private int accountNumber;
	private String accountName;
	private double balance;
	private LocalDateTime creationDate;
	private User primaryUser;
	private List<Authenticator> sharedUsers;
	private List<Transaction> history;
	private NumberFormat doubleFormatter = new DecimalFormat("#0.00");
//	private TransactionSerializer tranSave;
	
	// Creates a checking account with only one primary user and starting balance of $0.00
	public CheckingAccount(String accountName, User primaryUser) {
		super();
		numberOfAccounts++;
		this.accountNumber = numberOfAccounts;
		this.accountName = accountName;
		this.balance = 0;
		this.creationDate = LocalDateTime.now();
		this.sharedUsers = new ArrayList<>();
		this.primaryUser = primaryUser;
		this.history = new ArrayList<>();
		primaryUser.addAccount(this);
		
	}

	// Creates a checking account with only one primary user and a positive starting balance
	public CheckingAccount(String accountName, double balance, User primaryUser) {
		super();
		numberOfAccounts++;
		this.accountNumber = numberOfAccounts;
		this.accountName = accountName;
		this.balance = balance;
		this.creationDate = LocalDateTime.now();
		this.sharedUsers = new ArrayList<>();
		this.primaryUser = primaryUser;
		this.history = new ArrayList<>();
		primaryUser.addAccount(this);
	}

	// Creates a checking account with up to 5 other shared users and starting balance of $0.00
	public CheckingAccount(String accountName, User primaryUser, List<Authenticator> sharedUsers) {
		super();
		numberOfAccounts++;
		this.accountNumber = numberOfAccounts;
		this.accountName = accountName;
		this.balance = 0;
		this.creationDate = LocalDateTime.now();
		this.primaryUser = primaryUser;
		this.sharedUsers = sharedUsers;
		this.history = new ArrayList<>();
		primaryUser.addAccount(this);
	}

	// Creates a checking account with up to 5 other shared users and a positive starting balance
	public CheckingAccount(String accountName, double balance, User primaryUser,
			List<Authenticator> sharedUsers) {
		super();
		numberOfAccounts++;
		this.accountNumber = numberOfAccounts;
		this.accountName = accountName;
		this.balance = balance;
		this.creationDate = LocalDateTime.now();
		this.primaryUser = primaryUser;
		this.sharedUsers = sharedUsers;
		this.history = new ArrayList<>();
		primaryUser.addAccount(this);
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public User getPrimaryUser() {
		return primaryUser;
	}

	public void setPrimaryUser(User primaryUser) {
		this.primaryUser = primaryUser;
	}

	public List<Authenticator> getSharedUsers() {
		return sharedUsers;
	}

	public void setSharedUsers(List<Authenticator> sharedUsers) {
		this.sharedUsers = sharedUsers;
	}

	public double getBalance() {
		return Double.parseDouble(doubleFormatter.format(balance));
	}
	
	public void deposit(double amount) {
		
		// This balance operation was intended to prevent users from
		// depositing negative amounts -- but I need to alter it to
		// reject the transaction and display a message instead.
		// Otherwise, if somebody "deposits" -$1,000,000, then the
		// absolute value operator would demand money the user doesn't
		// actually have.
		balance += Math.abs(amount);
		history.add(new Transaction("Bank Deposit", amount, this));
		System.out.println("$" + doubleFormatter.format(amount) + " was deposited into your account.");
	}
	
	public void withdraw(double amount) {
		if (Math.abs(amount) > balance) {
			System.out.println("Insufficient funds! Transaction rejected!");
		}
		else {
			balance -= Math.abs(amount);
			System.out.println("$" + doubleFormatter.format(amount) + " was withdrawn from your account.");
			history.add(new Transaction("Bank Withdrawal", -1*amount, this));
		}
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public List<Transaction> getHistory() {
		return history;
	}

	@Override
	public String toString() {
		// It's all formatting.
		String shared;
		
		if (sharedUsers.size() > 0) {
			shared = sharedUsers.toString();
		} else {
			shared = "There are no other users sharing this account.";
		}
		
		return primaryUser.getCredentials().getUsername() + "\n" + accountName + "\nAccount Number "
				+ accountNumber + " -- created on " + creationDate
				+ "\nPrimary User: " + primaryUser.getFirstName() + " " + primaryUser.getLastName()
				+ "\n\n" + shared + "\n\nYour current balance is: $" + doubleFormatter.format(balance);
	}
	
	// Call this in the prompts to ensure that CheckingAccount keeps issuing unique
	// account numbers between sessions, when the file has been opened.
	public static void updateNumOfAccounts(List<User> users) {
		numberOfAccounts = users.size() - 1;
	}
	
	public String viewTransactions() {
		
		String transactionHistory = "";
				
		if (history.size() > 0) {
			for (Transaction e : history) {
				transactionHistory = transactionHistory + "\n" + e.toString();
			}
		} else {
			transactionHistory = "No transactions have been made yet.";
		}
		
		return transactionHistory;
		
	}
	
	public String toStringWithHistory() {

		return this.toString() + "\n\n" + this.viewTransactions();
	}
	
}
