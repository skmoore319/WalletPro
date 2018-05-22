package com.walletpro.views;

import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class SignUpView extends LoginView implements View {

	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private List<User> everybody;
	
	public SignUpView(List<User> everybody) {
		// TODO Auto-generated constructor stub
		super(everybody);
		this.everybody = everybody;
	}
	
	public View run(boolean session) {
		
		System.out.println("Please choose your username.");
		
		String input = scan.nextLine();
		
		if (this.containsUsername(everybody, input)) {
			System.out.println("Sorry! This username already exists!");
			return new SignUpView(everybody).run(session);
		} else {
			return new CreatePasswordView(everybody, input).run(session);
		}
	}

}
