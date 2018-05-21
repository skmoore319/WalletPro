package com.walletpro.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.walletpro.beans.User;

public class UserSerializer implements UserDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6449599107818805181L;

	@Override
	public List<User> open(String fileName) {
		// TODO Auto-generated method stub
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(fileName))) {
			
			List<User> all = (List<User>) inStream.readObject();
			return all;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(List<User> updatedUser, String fileName) {
		// TODO Auto-generated method stub
		
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			
			outStream.writeObject(updatedUser);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
