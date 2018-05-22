package com.walletpro.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class AccountStatusView extends AccountIndexView implements View {

	private UserDao userDao = new UserSerializer();
	private Scanner scan = new Scanner(System.in);
	private boolean session;
	private User currentUser;
	private List<User> everybody;
	private CheckingAccount account;
	
//	public AccountStatusView(User currentUser) {
//		super(currentUser);
//		// TODO Auto-generated constructor stub
//	}
	
	public AccountStatusView(User currentUser, CheckingAccount checkingAccount, List<User> everybody) {
		// TODO Auto-generated constructor stub
		super(currentUser, everybody);
		this.currentUser = currentUser;
		this.account = checkingAccount;
		this.everybody = everybody;
	}

	public View run(boolean session) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println(account.toString());
		System.out.println("What would you like to do?");
		System.out.println("[D]eposit     |     [W]ithdrawal     |     View [H]istory");
		
		String input = scan.nextLine();
		boolean valid = true;
		// All the characters on a Latin keyboard that are not numerical digits
		String check = "qwertyuiopasdfghklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"
				+ "`~!@#$%^&*()-_=+[]{}\\|;:\'\",./<>?";
		switch (input) {
		case "D":
		case "d":
			System.out.println("How much would you like to deposit?");
			input = scan.nextLine();
			for (int i = 0; i < check.length(); i++) {
				if (input.contains(Character.toString(check.charAt(i)))) {
					valid = false;
				}
			}
			
			if (!valid) {
				System.out.println("Invalid input. Please try again.");
			} else {
				account.deposit(Double.parseDouble(input));
				userDao.save(everybody, "User Test.txt");
				System.out.println("Your new balance is: " + account.getBalance());
			}
			
			break;
		case "W":
		case "w":
			System.out.println("How much would you like to withdraw?");
			input = scan.nextLine();
			for (int i = 0; i < check.length(); i++) {
				if (input.contains(Character.toString(check.charAt(i)))) {
					valid = false;
				}
			}
			
			if (!valid) {
				System.out.println("Invalid input. Please try again.");
			} else {
				account.withdraw(Double.parseDouble(input));
				userDao.save(everybody, "User Test.txt");
				System.out.println("Your new balance is: " + account.getBalance());
			}
			
			break;
		case "H":
		case "h":
			return new TransactionHistoryView(currentUser, account, everybody).run(session);
		default:
			System.out.println("Invalid input. Please try again.");
		}
		return this;
	}

}
