package com.mahesh.dao;

import com.mahesh.model.Employee;
import com.mahesh.model.User;

public class LoginDao {

	UserDao userDao=new UserDao();
	EmployeeDao employeeDao=new EmployeeDao();
	
	public boolean UserLogin(User user)
	{
		String result=userDao.checkPassword(user);
		if(result.equals(user.getPassword()))
				{
			return true;
				}
		return false;		
		
	}
	public boolean EmployeeLogin(Employee employee)
	{
		String result=employeeDao.checkPassword(employee);
		if(result.equals(employee.getPassword()))
		{
			return true;
		}
		return false;
	}

}
