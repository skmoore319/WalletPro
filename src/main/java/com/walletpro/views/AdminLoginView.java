package com.walletpro.views;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.walletpro.beans.Admin;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class AdminLoginView extends LoginView implements View {

	private UserDao userDao = new UserSerializer();
	private boolean session;
	private Scanner scan = new Scanner(System.in);
	private List<User> everybody;
	
	public AdminLoginView(List<User> everybody) {
		super(everybody);
		this.everybody = everybody;
		// TODO Auto-generated constructor stub
	}
	
	public View run(boolean session) {
		
		System.out.println("Please enter your Employee ID.");
		System.out.println("[X] Exit");
		String employeeID = scan.nextLine();
		if (employeeID.equalsIgnoreCase("X")) {
			this.session = false;
			return this;
		}
		
		List<User> admins = everybody.stream().filter(e -> e.isAdmin()).collect(Collectors.toList());
		
		if (containsID(admins, employeeID)) {
//			System.out.println("Username entered");
//			System.out.println(this.matchToPassword(everybody, username).getAccounts());
			System.out.println("You have entered the secure area.");
			Admin currentAdmin = (Admin) admins.stream().filter(e -> e.getEmployeeID().equals(employeeID)).findFirst().get();
			List<User> normies = everybody.stream().filter(e -> !(e.isAdmin())).collect(Collectors.toList());
			return new UserIndexView(currentAdmin, normies).run(session);
		} else {
			System.out.println("That ID number does not exist. Please contact HR for further information about hiring.");
			System.out.println("[Any Key] OK");
			System.out.println("[X] Exit");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("X")) this.session = false;
			return new SignUpView(everybody).run(this.session);
		}
	}
	
	public boolean containsID(List<User> administrators, String inputID) {
		return administrators.stream().filter(e -> ((Admin) e).getEmployeeID().equals(inputID)).findFirst().isPresent();
	}
}
