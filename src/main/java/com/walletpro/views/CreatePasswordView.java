package com.walletpro.views;

import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class CreatePasswordView extends SignUpView implements View {
	
	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private List<User> everybody;
	private String newUsername;
	
	public CreatePasswordView(List<User> everybody, String userInput) {
		super(everybody);
		this.everybody = everybody;
		this.newUsername = userInput;
	}
	
	public View run(boolean session) {
		
		System.out.println("Almost finished -- your username will be " + this.newUsername);
		System.out.println("Please choose a name for your primary checking account.");
		String acctName = scan.nextLine();
		System.out.println("You have named your primary checking account: " + acctName);
		System.out.println("Please enter your last name.");
		String lastName = scan.nextLine();
		System.out.println("Your last name is " + lastName);
		System.out.println("Please enter your first name.");
		String firstName = scan.nextLine();
		System.out.println("Your full name is " + firstName + " " + lastName);
		System.out.println("Please choose a password to log in with.");
		String newPassword = scan.nextLine();
		
		User newCustomer = new User(firstName, lastName, this.newUsername, newPassword);
		new CheckingAccount(acctName, newCustomer);
//		newCustomer.addAccount(new CheckingAccount(acctName, newCustomer));
		everybody.add(newCustomer);
		userDao.save(everybody, "User Test.txt");
		
		System.out.println("Success! Welcome the WalletPro community!");
		
		return this;
	}
	
}
