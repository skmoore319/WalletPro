package com.walletpro.views;

public interface View {
	View run(boolean session);
	
	boolean getSession();
}
