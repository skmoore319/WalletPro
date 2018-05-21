package com.walletpro.beans;

import java.io.Serializable;

import com.walletpro.helpers.Authenticator;

/*
 * An administrator is like a user, but also has an ID number, which they are
 * required to supply in order to do privileged things such as view any user's
 * transaction history
 */
public class Admin extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2425181879377099585L;
	// As more administrators join the team, different ID numbers will be generated
	private static int adminNumber = 1000000;
	private String employeeID;
	
	public Admin(String firstName, String lastName, String userID, String password) {
		super(firstName, lastName, userID, password);
		// TODO Auto-generated constructor stub
		employeeID = Integer.toString(adminNumber);
		this.credentials = new Authenticator(userID, password, this);
		adminNumber++;
	}

	public String getEmployeeID() {
		
		return employeeID;
	}

	public static int getAdminNumber() {
		return adminNumber;
	}

}
