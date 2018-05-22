package com.walletpro.views;

import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class EnterPasswordView extends LoginView implements View {

	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private User currentUser;
	private List<User> everybody;
	
	public EnterPasswordView(User currentUser, List<User> everybody) {
		super(everybody);
		this.currentUser = currentUser;
		this.everybody = everybody;
	}
	
	@Override
	public View run(boolean session) {
		// TODO Auto-generated method stub
//		System.out.println(this.session);
		System.out.println("Please enter your password.");
		System.out.println("[X] Exit");
		String input = scan.nextLine();
//		System.out.println(input);
		if (input.equalsIgnoreCase("X")) {
			this.session = false;
			return this;
		}
//		System.out.println("Exit check passed");
		if (currentUser.getCredentials().verify(input)) {
			System.out.println("Password accepted!");
//			System.out.println(currentUser);
			return new AccountIndexView(this.currentUser, everybody).run(session);
		}
		else {
//			System.out.println(this.session);
			System.out.println("This password is not correct. Please try again.");
			System.out.println("[X] Exit");
			input = scan.nextLine();
//			System.out.println(this.session);
			if (input.equalsIgnoreCase("x")) {
				this.session = false;
//				return this;
			}
			
		}
		
		return this;
	}

//	@Override
//	public boolean getSession() {
//		// TODO Auto-generated method stub
//		return this.session;
//	}

}
