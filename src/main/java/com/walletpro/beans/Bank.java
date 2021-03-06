package com.walletpro.beans;

import java.io.Serializable;
import java.util.List;

/*
 * A class to place list of users as they create new bank accounts.
 */
public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1545107612706940051L;
	public static List<User> users;
	public static List<Admin> admins;
	
	public static void addUser(User signup) {
		users.add(signup);
	}
	
	public static List<User> getUsers() {
		return users;
	}
}
