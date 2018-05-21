package com.walletpro.dao;

import java.io.Serializable;
import java.util.List;

import com.walletpro.beans.User;

public interface UserDao extends Serializable{
	
	List<User> open(String fileName);
	
	void save(List<User> updatedUser, String fileName);

}
