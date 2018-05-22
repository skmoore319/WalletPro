package com.walletpro.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class AccountIndexView extends EnterPasswordView implements View {

	private UserDao userDao = new UserSerializer();
	private Scanner scan = new Scanner(System.in);
	private boolean session;
	private User currentUser;
	private List<User> everybody;
	
	
	public AccountIndexView(User currentUser, List<User> everybody) {
		super(currentUser, everybody);
		this.currentUser = currentUser;
		this.everybody = everybody;
//		System.out.println(this.currentUser);
	}
	
	@Override
	public View run(boolean session) {
		// TODO Auto-generated method stub
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println("Here is a list of all accounts to which you have access.");
		List<CheckingAccount> accounts = this.currentUser.getAccounts();
		for (CheckingAccount e: accounts) {
			System.out.println("[" + (accounts.indexOf(e)+1) + "] -- " + e.getAccountName() + " -- Current Balance: $"
					+ formatter.format(e.getBalance()));
		}
		System.out.println("[X] Exit\n");
//		System.out.println(this.currentUser);
		String input = scan.nextLine();
		if (input.equalsIgnoreCase("x")) {
			this.session = false;
			return this;
		} else if(Integer.parseInt(input)-1 < accounts.size()) {
			return new AccountStatusView(currentUser, accounts.get(Integer.parseInt(input)-1), everybody).run(this.session);
		} else {
			System.out.println("Invalid input. Please try again.");
		}
		
		
		
		
//		currentUser = this.matchToPassword(everybody, currentUser.getCredentials().getUsername());
//		System.out.println(everybody.toString());
//		System.out.println(this.currentUser.getAccounts());
		
		return this;
	}

//	@Override
//	public boolean getSession() {
//		// TODO Auto-generated method stub
//		return this.session;
//	}

}
