package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.User;

public class TestUserDao {

	public static void main(String[] args) {

		UserDao userDao=new UserDao();
		
		User user=new User();
		/*user.setName("Arun");
		user.setEmailId("arun@gmail.com");
		user.setPassword("arunkumar");
		user.setMobileNumber(852682870);
		userDao.save(user);*/
		
		
		user.setName("Arunkumar");
		user.setMobileNumber(774455668);
		user.setId(4);
		userDao.update(user);
		
		List<User> list = userDao.list();
		Iterator<User> i = list.iterator();
		while (i.hasNext()) {
			User users=(User) i.next();
			System.out.println(users.getId()+"\t"+users.getName()+"\t"+users.getEmailId()+"\t"+users.getPassword()
			+"\t"+users.getMobileNumber()+"\t"+users.getActive());
		}

	}

}
