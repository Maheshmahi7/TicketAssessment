package com.mahesh.model;

public class TestUser {

	public static void main(String[] args) {


		User user=new User();
		user.setId(1);
		user.setName("Mahesh");
		user.setEmailId("mahesh11317@gmail.com");
		user.setPassword("maheshkumar");
		user.setMobileNumber(909504440);
		user.setActive(1);
		
		System.out.println(user);


	}

}
