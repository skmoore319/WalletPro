package com.walletpro.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.walletpro.beans.CheckingAccount;
import com.walletpro.beans.User;
import com.walletpro.dao.UserDao;
import com.walletpro.dao.UserSerializer;

public class TransactionHistoryView extends AccountStatusView implements View {

	private UserDao userDao = new UserSerializer();
	private Scanner scan = new Scanner(System.in);
	private boolean session;
	private User currentUser;
	private CheckingAccount account;
	private List<User> everybody;
	
	public TransactionHistoryView(User currentUser, CheckingAccount checkingAccount, List<User> everybody) {
		super(currentUser, checkingAccount, everybody);
		// TODO Auto-generated constructor stub
		this.currentUser = currentUser;
		this.account = checkingAccount;
		this.everybody = everybody;
	}
	
	public View run(boolean session) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println(this.account.viewTransactions());
		return this;
	}

}
