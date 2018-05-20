package com.walletpro.testing;

import com.walletpro.beans.Admin;
import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
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
		
//		System.out.println(myCred.getUsername());
//		System.out.println(myCred.getPassword());
//		myCred.setPassword("pass123socleverlol");
//		System.out.println(myCred.getPassword());
//		
//		System.out.println("Logging myself in...");
		String tryThis = "123123";
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
		User scott = new User("Scott", "Moore", "skmoore", "123123");
		User scott2 = new User("Scott", "Moore", "skm319", "111111");
		User john = new User("John", "Smith", "js321", "password");
		
		
		CheckingAccount myAccount = new CheckingAccount("Scott's Main Account", scott);
//		System.out.println(myAccount.toString());
//		System.out.println(myAccount.viewTransactions());
//		System.out.println(myAccount.toStringWithHistory());
//		myAccount.deposit(750);
//		myAccount.withdraw(200);
//		System.out.println(myAccount.toStringWithHistory());
//		System.out.println(myAccount.toString());
//		System.out.println(scott.getFirstName());
//		System.out.println(scott.getLastName());
//		System.out.println(scott.getTimeJoined());
//		System.out.println(scott.getCredentials());
//		System.out.println(scott.getCredentials().getUsername());
//		System.out.println(scott.getCredentials().getPassword());
		System.out.println(scott.listAccounts());
//		System.out.println("Scott Moore is the primary user? " + scott.isPrimary(myAccount));
//		System.out.println("John Smith is the primary user? " + john.isPrimary(myAccount));
//		System.out.println("This person's name is also " + scott2.getFirstName() + " " + scott2.getLastName()
//		+ ". Is he the primary user of " + myAccount.getAccountName() + "? " + scott2.isPrimary(myAccount));
		Admin scott3 = new Admin("Scott", "M", "scottkmooreAdmin", "555555");
		System.out.println("Verifying Administrative Credentials: " + scott3.getEmployeeID() + " " + tryThis
				+ ": " + scott3.getCredentials().verifyAdmin(tryThis, scott3.getEmployeeID()));
		System.out.println("Verifying Administrative Credentials: " + scott3.getEmployeeID() + " " + scott3.getCredentials().getPassword()
				+ ": " + scott3.getCredentials().verifyAdmin("555555", "1000000"));
		
	}

}
