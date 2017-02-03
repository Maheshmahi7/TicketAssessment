package com.mahesh.dao;

import com.mahesh.model.User;

public class LoginDao {

	UserDao userDao=new UserDao();
	
	public boolean UserLogin(User user)
	{
		String result=userDao.checkPassword(user);
		if(result.equals(user.getPassword()))
				{
			return true;
				}
		return false;		
		
	}

}
