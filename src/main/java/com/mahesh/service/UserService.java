package com.mahesh.service;

import com.mahesh.dao.DepartmentDao;
import com.mahesh.dao.LoginDao;
import com.mahesh.dao.PriorityDao;
import com.mahesh.dao.TicketCreationDao;
import com.mahesh.dao.UserDao;
import com.mahesh.exception.PersistenceException;
import com.mahesh.exception.ServiceException;
import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Department;
import com.mahesh.model.Priority;
import com.mahesh.model.Ticket;
import com.mahesh.model.User;
import com.mahesh.validator.UserServiceValidator;


public class UserService {
	
	TicketCreationDao ticketCreationDao=new TicketCreationDao();
	Ticket ticket=new Ticket();
	User user=new User();
	Department department=new Department();
	Priority priority=new Priority();
	UserDao userDao=new UserDao();
	LoginDao loginDao=new LoginDao();
	DepartmentDao departmentDao=new DepartmentDao();
	PriorityDao priorityDao=new PriorityDao();
	UserServiceValidator userServiceValidator=new UserServiceValidator();
	
	
	public void newTicket(String emailId,String password,String subject,String description,String departmentName,String priorityName) throws ServiceException,PersistenceException
	{
		try {
		user.setEmailId(emailId);
		user.setPassword(password);
		userServiceValidator.createTicket(emailId,password,subject,description,departmentName,priorityName);
		if(loginDao.UserLogin(user))
		{
		int userId=userDao.findUserId(emailId).getId();
		user.setId(userId);
		int departmentId=departmentDao.findDepartmentId(departmentName).getId();
		department.setId(departmentId);
		int priorityId=priorityDao.findPriorityId(priorityName).getId();
		priority.setId(priorityId);
		ticketCreationDao.createTicket(user,department,subject,description,priority);
		}
		} catch (ValidatorException e) {
			throw new ServiceException("Cannot Create Ticket", e);
		}
	}

}
