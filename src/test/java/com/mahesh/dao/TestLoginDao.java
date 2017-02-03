package com.mahesh.dao;

import com.mahesh.model.User;

public class TestLoginDao {

	public static void main(String[] args) {
		
		LoginDao loginDao=new LoginDao();
		User user=new User();
		user.setEmailId("mahesh11317@gmail.com");
		user.setPassword("maheshkumar");
		
		System.out.println(loginDao.UserLogin(user));

	}

}
