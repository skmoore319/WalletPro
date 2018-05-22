package com.walletpro.launchers;

import com.walletpro.views.MainMenuView;
import com.walletpro.views.View;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean session = true;
//		View currentView = new MainMenuView(session);
		
		while (session) {
			View currentView = new MainMenuView().run(session);
			session = currentView.getSession();
			if (!session) System.out.println("Thank you for choosing WalletPro!");
		}
	}

}
