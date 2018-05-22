package com.walletpro.views;

import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.Admin;
import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class MainMenuView implements View {
	
	private UserDao userDao = new UserSerializer();
	private boolean session;
	Scanner scan = new Scanner(System.in);

	public MainMenuView() {
//		this.session = session;
	}
	
	@Override
	public View run(boolean session) {
		// TODO Auto-generated method stub
		this.session = session;
//		System.out.println(this.session);
		System.out.println("Welcome to WalletPro! How can we help you?\n");
		System.out.println("[1] Log In");
		System.out.println("[2] Sign Up");
		System.out.println("[3] I'm An Administrator");
		System.out.println("[X] Exit.\n");
		
		List<User> everybody = userDao.open("User Test.txt");
		Admin.updateAdminNumber(everybody);
		CheckingAccount.updateNumOfAccounts(everybody);
		
//		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
//			System.out.println(this.session);
			return new LoginView(everybody).run(this.session);
			
		case "2":
			
			return new SignUpView(everybody).run(this.session);
			
		case "3":
			
			return new AdminLoginView(everybody).run(this.session);
		case "X":
			this.session = false;
			System.out.println("Exiting...");
			break;
		case "x":
			this.session = false;
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid input. Please select a different option.");
			break;
		}
		
		return this;
	}
	
	public boolean getSession() {
		return this.session;
	}

}
