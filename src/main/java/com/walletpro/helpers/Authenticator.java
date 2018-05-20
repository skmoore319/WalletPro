package com.walletpro.helpers;

/* This class is meant to authenticate a 
 * password supplied by the user, against a given
 * username.
 * 
 */
public class Authenticator {
	
	private String username;
	private String password;
	
	public Authenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
}
