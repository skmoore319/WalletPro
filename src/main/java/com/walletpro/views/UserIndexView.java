package com.walletpro.views;

import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.Admin;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class UserIndexView extends AdminLoginView implements View {

	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private List<User> normies;
	private Admin currentAdmin;
	
	public UserIndexView(Admin currentAdmin, List<User> normies) {
		super(normies);
		this.normies = normies;
		this.currentAdmin = currentAdmin;
		// TODO Auto-generated constructor stub
	}
	
	public View run(boolean session) {
		
		System.out.println("Select a user to view the transaction histories of any of their accounts.");
		for (User e: normies) {
			System.out.println("[" + (normies.indexOf(e)+1) + "] - " + e.getCredentials().getUsername() + " -- "
					+ e.getFirstName() + " " + e.getLastName() + " -- "
					+ e.getAccounts().size() + " Accounts");
		}
		
		System.out.println("[X] Exit\n");
		
		String input = scan.nextLine();
		if (input.equalsIgnoreCase("x")) {
			this.session = false;
			return this;
		} else if(Integer.parseInt(input)-1 < normies.size()) {
			return new AdminAccountIndexView(currentAdmin, normies.get(Integer.parseInt(input)-1), normies).run(this.session);
		} else {
			System.out.println("Invalid input. Please try again.");
		}
		
		return this;
	}

}
