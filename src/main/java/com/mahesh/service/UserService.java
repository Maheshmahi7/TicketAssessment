package com.mahesh.service;

import com.mahesh.dao.DepartmentDao;
import com.mahesh.dao.LoginDao;
import com.mahesh.dao.PriorityDao;
import com.mahesh.dao.SolutionDao;
import com.mahesh.dao.TicketCreationDao;
import com.mahesh.dao.TicketDao;
import com.mahesh.dao.UserDao;
import com.mahesh.exception.PersistenceException;
import com.mahesh.exception.ServiceException;
import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Priority;
import com.mahesh.model.Solution;
import com.mahesh.model.Ticket;
import com.mahesh.model.User;
import com.mahesh.validator.UserServiceValidator;


public class UserService {
	
	Ticket ticket=new Ticket();
	User user=new User();
	Department department=new Department();
	Employee employee=new Employee();
	Priority priority=new Priority();
	Solution solution=new Solution();
	UserDao userDao=new UserDao();
	SolutionDao solutionDao=new SolutionDao();
	TicketDao ticketDao=new TicketDao();
	LoginDao loginDao=new LoginDao();
	DepartmentDao departmentDao=new DepartmentDao();
	PriorityDao priorityDao=new PriorityDao();
	UserServiceValidator userServiceValidator=new UserServiceValidator();
	TicketCreationDao ticketCreationDao=new TicketCreationDao();

	
	public void registration(String name,String emailId,String password,int mobileNumber) throws ServiceException,PersistenceException, ValidatorException{
	
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setMobileNumber(mobileNumber);
		userDao.save(user);
	}
	
	
	public void newTicket(String emailId,String password,String subject,String description,String departmentName,String priorityName) throws ServiceException, PersistenceException
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
		switch(departmentId){
		case 1: employee.setId(1);
				break;
		case 2: employee.setId(2);
				break;
		}
		ticketCreationDao.createTicket(user,department,subject,description,priority,employee);
		int ticketId=ticketDao.findTicketId(user).getId();
		ticket.setId(ticketId);
		solutionDao.save(ticket);
		
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
			if(ticketDao.findStatus(ticketId,user).getStatus()!="CLOSED")
			{
			ticketCreationDao.updateTicket(ticketId, user, description);
			}
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
			if((ticketDao.findStatus(ticketId,user)).getStatus()!="CLOSED")
			{
			ticketCreationDao.closeTicket(ticketId, user);
			}
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
			ticketCreationDao.ViewTicket(user);
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Ticket", e);
			}
	}

}
