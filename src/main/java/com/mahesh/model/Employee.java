package com.mahesh.model;

import lombok.Data;

@Data
public class Employee {

	
	private int id;
	private String name;
	private Department departmentId;
	private Role roleId;
	private String emailId;
	private String password;
	private long mobileNumber;
	private int active;


}
