package com.walletpro.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.Admin;
import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class AdminAccountIndexView extends UserIndexView implements View {
	
	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private List<User> normies;
	private Admin currentAdmin;
	private User target;
	
	public AdminAccountIndexView(Admin currentAdmin, User target, List<User> normies) {
		super(currentAdmin, normies);
		this.normies = normies;
		this.currentAdmin = currentAdmin;
		this.target = target;
	}
	
	public View run(boolean session) {
		
		System.out.println("Select one of this user's accounts.");
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		List<CheckingAccount> accounts = this.target.getAccounts();
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
			CheckingAccount targetsAccount = accounts.get(Integer.parseInt(input)-1);
			System.out.println(targetsAccount.toStringWithHistory());
//			return new AccountStatusView(currentUser, accounts.get(Integer.parseInt(input)-1), everybody).run(this.session);
		} else {
			System.out.println("Invalid input. Please try again.");
		}
		
		return this;
	}
}
