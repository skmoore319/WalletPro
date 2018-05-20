package com.walletpro.helpers;

import com.walletpro.beans.Admin;
import com.walletpro.beans.User;

/* This class is meant to authenticate a 
 * password supplied by the user, against a given
 * username.
 * 
 */
public class Authenticator {
	
	private String username;
	private String password;
	private String adminID;
	
//	public Authenticator(String username, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//		adminID = null;
//	}
	
	public Authenticator(String username, String password, User administrator) {
		super();
		this.username = username;
		this.password = password;
		
		if (administrator.getClass().getName().equals("com.walletpro.beans.Admin")) {
			
			this.adminID =  ((Admin) administrator).getEmployeeID();
			
		} else {
			adminID = null;
		}
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public boolean verify(String passInput) {
		return passInput.equals(password);
	}
	
	public boolean verifyAdmin(String passInput, String adminIDInput) {
		// 
		return adminIDInput.equals(adminID) && passInput.equals(password);
	}
	
}
