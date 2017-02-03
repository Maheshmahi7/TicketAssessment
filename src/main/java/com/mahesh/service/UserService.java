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
	
	Ticket ticket=new Ticket();
	User user=new User();
	Department department=new Department();
	Priority priority=new Priority();
	UserDao userDao=new UserDao();
	LoginDao loginDao=new LoginDao();
	DepartmentDao departmentDao=new DepartmentDao();
	PriorityDao priorityDao=new PriorityDao();
	UserServiceValidator userServiceValidator=new UserServiceValidator();
	TicketCreationDao ticketCreationDao=new TicketCreationDao();
	
	
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
	
	public void ticketUpdate(String emailId,String password,String description,int ticketId)throws ServiceException,PersistenceException
	{
		try {
			user.setEmailId(emailId);
			user.setPassword(password);
			userServiceValidator.updateTicket(emailId, password, ticketId, description);
			if(loginDao.UserLogin(user))
			{
			int userId=userDao.findUserId(emailId).getId();
			user.setId(userId);
			ticketCreationDao.updateTicket(ticketId, user, description);
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Ticket", e);
			}
	}
	
	public void ticketClose(String emailId,String password,int ticketId)throws ServiceException,PersistenceException
	{
		try {
			user.setEmailId(emailId);
			user.setPassword(password);
			userServiceValidator.updateClose(emailId, password, ticketId);
			if(loginDao.UserLogin(user))
			{
			int userId=userDao.findUserId(emailId).getId();
			user.setId(userId);
			ticketCreationDao.closeTicket(ticketId, user);
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Ticket", e);
			}
		
	}
	
	public void viewTicket(String emailId,String password)throws ServiceException,PersistenceException
	{
		try {
			user.setEmailId(emailId);
			user.setPassword(password);
			userServiceValidator.viewTicket(emailId, password);
			if(loginDao.UserLogin(user))
			{
			int userId=userDao.findUserId(emailId).getId();
			user.setId(userId);
			ticketCreationDao.viewTicket(user);
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Ticket", e);
			}
	}

}
