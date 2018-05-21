package com.walletpro.testing;

import java.util.ArrayList;
import java.util.List;

import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

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
//		User scott = new User("Scott", "Moore", "skmoore", "123123");
//		User scott2 = new User("Scott", "Moore", "skm319", "111111");
//		User john = new User("John", "Smith", "js321", "password");
		
		// Time to test FileIO, at the user level.
		UserDao userSave = new UserSerializer();
		String pathName = "User Test.txt";
		
//		CheckingAccount myAccount = new CheckingAccount("Scott's Main Account", scott);
//		CheckingAccount myOtherAccount = new CheckingAccount("Fun Stuff", scott);
//		CheckingAccount otherScott = new CheckingAccount("Munny", scott2);
//		CheckingAccount johnAccount = new CheckingAccount("John Account", john);
//		
//		myAccount.deposit(1000);
//		myAccount.withdraw(40);
//		myAccount.withdraw(57.63);
//		myAccount.withdraw(500.10);
//		myAccount.deposit(800);
//		
//		myOtherAccount.deposit(70);
//		myOtherAccount.deposit(32.67);
//		myOtherAccount.deposit(49.73);
//		myOtherAccount.deposit(35.02);
//		
//		otherScott.deposit(650.42);
//		otherScott.deposit(120.44);
//		otherScott.withdraw(93.51);
//		
//		johnAccount.deposit(89);
//		johnAccount.deposit(728.84);
//		johnAccount.withdraw(45.70);
//		
//		List<User> everybody = new ArrayList<>();
//		everybody.add(scott);
//		everybody.add(scott2);
//		everybody.add(john);
		
//		userSave.save(everybody, pathName);
//		--------------------------------------------------------------------------
//		End phase of output test. Comment out the above, except for UserSerializer and pathName
		
		// Begin input test. Reading a previously outputted file should return the original objects.
		List<User> everybody = userSave.open(pathName);
		System.out.println(CheckingAccount.getNumberOfAccounts());
		System.out.println(everybody);
		CheckingAccount.updateNumOfAccounts(everybody);
		System.out.println(CheckingAccount.getNumberOfAccounts());
		
//		TransactionSerializer tranSzr = new TransactionSerializer();
//		CheckingAccount second = new CheckingAccount("Scott 2", scott);
//		second.deposit(1000);
//		second.withdraw(40);
//		Transaction first = new Transaction("Initial", 0, second);
//		Transaction two = new Transaction("Paycheck", 1000, second);
//		Transaction three = new Transaction("Withdrawal", 40, second);
//		tranSzr.save(second.getHistory(), "transactionTest.txt");
//		List<Transaction> history = tranSzr.open("transactionTest.txt");
//		System.out.println(history.toString());
		
//		List<Transaction> history = tranSzr.open("transactionTest.txt");
//		System.out.println(history);
//		CheckingAccount nextAccount = new CheckingAccount("Scott's Account", new User("Scott", "Moore", "skmoore", "123123"));
//		Transaction payCheck = new Transaction("Paycheck", 1000, nextAccount);
//		tranSzr.save(payCheck, nextAccount);
//		System.out.println(myAccount.getHistory());
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
//		System.out.println(scott.listAccounts());
//		System.out.println("Scott Moore is the primary user? " + scott.isPrimary(myAccount));
//		System.out.println("John Smith is the primary user? " + john.isPrimary(myAccount));
//		System.out.println("This person's name is also " + scott2.getFirstName() + " " + scott2.getLastName()
//		+ ". Is he the primary user of " + myAccount.getAccountName() + "? " + scott2.isPrimary(myAccount));
//		Admin scott3 = new Admin("Scott", "M", "scottkmooreAdmin", "555555");
//		System.out.println("Verifying Administrative Credentials: " + scott3.getEmployeeID() + " " + tryThis
//				+ ": " + scott3.getCredentials().verifyAdmin(tryThis, scott3.getEmployeeID()));
//		System.out.println("Verifying Administrative Credentials: " + scott3.getEmployeeID() + " " + scott3.getCredentials().getPassword()
//				+ ": " + scott3.getCredentials().verifyAdmin("555555", "1000000"));
		
	}

}
