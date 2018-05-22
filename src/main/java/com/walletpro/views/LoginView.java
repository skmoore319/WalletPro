package com.walletpro.views;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class LoginView extends MainMenuView implements View {
	
	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private List<User> everybody;

	public LoginView(List<User> everybody) {
		super();
		this.everybody = everybody;
	}
	
	@Override
	public View run(boolean session) {
		// TODO Auto-generated method stub
//		List<User> everybody = userDao.open("User Test.txt");
//		System.out.println(everybody);
		System.out.println("Please enter your username.");
		System.out.println("[X] Exit");
		String username = scan.nextLine();
		if (username.equalsIgnoreCase("X")) {
			this.session = false;
			return this;
		}
		
		if (containsUsername(everybody, username)) {
//			System.out.println("Username entered");
//			System.out.println(this.matchToPassword(everybody, username).getAccounts());
			return new EnterPasswordView(this.matchToPassword(everybody, username), everybody).run(session);
		} else {
			System.out.println("That username does not exist. Please create a profile first.");
			System.out.println("[Any Key] OK");
			System.out.println("[X] Exit");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("X")) this.session = false;
			return new SignUpView(everybody).run(this.session);
		}
	}

//	@Override
//	public boolean getSession() {
//		// TODO Auto-generated method stub
//		return this.session;
//	}
	
	// Checks to see if a username already exists in the database
	public boolean containsUsername(List<User> all, String inputUserName) {
		// Given a list of users, of arbitrary length...
		// Stream that list, and filter it such that...
		// It would pull all elements whose usernames match the input username...
		// And in that new filtered list, it finds the first instance...
		// And checks to see if even a first instance exists
		return all.stream().filter(e -> e.getCredentials().getUsername().equals(inputUserName)).findFirst().isPresent();
	}
	
	public boolean isAdmin() {
		return this.getClass().getName().equals("com.walletpro.beans.Admin");
	}
	
	
	public User matchToPassword(List<User> all, String inputUserName) {
		return all.stream().filter(e -> e.getCredentials().getUsername().equals(inputUserName)).findFirst().get();
	}

}
