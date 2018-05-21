package com.walletpro.beans;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.walletpro.helpers.Authenticator;

/*
 * A user will have a first and last name,
 * as well as a list of bank accounts. They also have a
 * username and a password, which, when passed into
 * the authenticator, will create a session for them,
 * and allow them to access all of their bank accounts
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6530937686106188623L;
	private String firstName;
	private String lastName;
	protected Authenticator credentials; // Protected is not ideal, but necessary for this implementation to support the creation of admins.
	private List<CheckingAccount> accounts;
	private LocalDateTime timeJoined;
	private NumberFormat formatter = new DecimalFormat("#0.00");
	
	public User(String firstName, String lastName, String userID, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentials = new Authenticator(userID, password, this);
		this.accounts = new ArrayList<>();
		this.timeJoined = LocalDateTime.now();
	}

	// Users are free to change their given names
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Gets the authenticator so that the user can view their
	// username or change their password
	public Authenticator getCredentials() {
		return credentials;
	}

	// Get a list of checking accounts that the person has.
	// No setters.
	public List<CheckingAccount> getAccounts() {
		return accounts;
	}
	
	public void addAccount(CheckingAccount newAccount) {
		accounts.add(newAccount);
	}
	
	public String listAccounts() {
		String accountIndex = "";
		for (CheckingAccount e: accounts) {
			accountIndex = accountIndex + "[" + (accounts.indexOf(e)+1) + "] |   Account Name: " + e.getAccountName()
					+ " |   Account Number: " + e.getAccountNumber() + " |   Created: " + e.getCreationDate()
					+ " |   Current Balance: $" + formatter.format(e.getBalance()) + "\n";
		}
		return accountIndex;
	}

	// Simply returns the date that the user joined. No setter
	public LocalDateTime getTimeJoined() {
		return timeJoined;
	}
	
	public boolean isPrimary(CheckingAccount testAccount) {
		return this.equals(testAccount.getPrimaryUser());
	}
	
	
}
