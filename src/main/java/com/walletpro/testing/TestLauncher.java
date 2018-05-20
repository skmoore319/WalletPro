package com.walletpro.testing;

import com.walletpro.beans.CheckingAccount;
import com.walletpro.helpers.Authenticator;

public class TestLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Test the creation of a Transaction
//		System.out.println(new Transaction("Deposit", 10.77).toString());
//		System.out.println(new Transaction("Paycheck from Revature LLC", 500).toString());
//		System.out.println(new Transaction("Amazon shipment", -45.38));
//		System.out.println(new Transaction("Rightstuf Purchase", -120.98));
		
		// Test the creation of an Authenticator
		Authenticator myCred = new Authenticator("skmoore", "123123");
//		System.out.println(myCred.getUsername());
//		System.out.println(myCred.getPassword());
//		myCred.setPassword("pass123socleverlol");
//		System.out.println(myCred.getPassword());
//		
//		System.out.println("Logging myself in...");
//		String tryThis = "123123";
//		System.out.println("Let's try... " + tryThis);
//		System.out.println(myCred.verify(tryThis));
//		
//		tryThis = "Pass123socleverlol";
//		System.out.println("Let's try... " + tryThis);
//		System.out.println(myCred.verify(tryThis));
//		
//		tryThis = "pass123socleverlol";
//		System.out.println("Let's try... " + tryThis);
//		System.out.println(myCred.verify(tryThis));
		
		//System.out.println(CheckingAccount.getNumberOfAccounts());
		CheckingAccount myAccount = new CheckingAccount("Scott's Main Account", myCred);
		//System.out.println(myAccount.toString());
//		System.out.println(myAccount.viewTransactions());
//		System.out.println(myAccount.toStringWithHistory());
		myAccount.deposit(750);
		myAccount.withdraw(200);
		System.out.println(myAccount.toStringWithHistory());
		
	}

}
