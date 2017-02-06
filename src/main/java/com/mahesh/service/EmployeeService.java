package com.mahesh.service;

import com.mahesh.dao.DepartmentDao;
import com.mahesh.dao.EmployeeDao;
import com.mahesh.dao.LoginDao;
import com.mahesh.dao.PriorityDao;
import com.mahesh.dao.SolutionDao;
import com.mahesh.dao.TicketAssignmentDao;
import com.mahesh.dao.TicketCreationDao;
import com.mahesh.dao.TicketDao;
import com.mahesh.exception.PersistenceException;
import com.mahesh.exception.ServiceException;
import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Priority;
import com.mahesh.model.Role;
import com.mahesh.model.Solution;
import com.mahesh.model.Ticket;
import com.mahesh.validator.EmployeeServiceValidator;

public class EmployeeService {
	
	Ticket ticket=new Ticket();
	Department department=new Department();
	Employee employee=new Employee();
	Priority priority=new Priority();
	Solution solution=new Solution();
	Role role=new Role();
	EmployeeDao employeeDao=new EmployeeDao();
	TicketDao ticketDao=new TicketDao();
	LoginDao loginDao=new LoginDao();
	SolutionDao solutionDao=new SolutionDao();
	DepartmentDao departmentDao=new DepartmentDao();
	PriorityDao priorityDao=new PriorityDao();
	EmployeeServiceValidator employeeServiceValidator=new EmployeeServiceValidator();
	TicketAssignmentDao ticketAssignmentDao=new TicketAssignmentDao();
	TicketCreationDao ticketCreationDao=new TicketCreationDao();
	
	public void registration(String name,String emailId,String password,int mobileNumber,int departmentId,int roleId) throws ServiceException,PersistenceException, ValidatorException{
		
		employee.setName(name);
		employee.setEmailId(emailId);
		employee.setPassword(password);
		employee.setMobileNumber(mobileNumber);
		department.setId(departmentId);
		employee.setDepartmentId(department);
		role.setId(roleId);
		employee.setRoleId(role);
		employeeDao.save(employee);
	}
	
	public void ticketReassignmnet(String emailId,String password,int ticketId,int employeeId) throws ServiceException, PersistenceException{
		
		try {
			employee.setEmailId(emailId);
			employee.setPassword(password);
			employeeServiceValidator.ticketReassignment(emailId, password, ticketId, employeeId);
			if(loginDao.EmployeeLogin(employee))
			{
				int id=employeeDao.findEmployeeId(emailId).getId();
				if(id!=employeeId)	
				{
					int existingEmployee=(employeeDao.findEmployeeDepartmentId(id).getDepartmentId().getId());
					int newEmployee=(employeeDao.findEmployeeDepartmentId(employeeId).getDepartmentId().getId());
					if(existingEmployee==newEmployee)
					{
						if(newEmployee==(ticketDao.findDepartmentId(ticketId).getDepartmentId().getId())){
					ticket.setId(ticketId);
					employee.setId(employeeId);
					ticket.setEmployeeId(employee);
					ticketAssignmentDao.reassignTicket(ticket);
					}
					}
				}
			}
			}catch (ValidatorException e) {
				throw new ServiceException("Cannot Reassign Ticket", e);
			}
		
	}
	
	public void updateTicket(String emailId,String password,int ticketId,String status) throws ServiceException, PersistenceException{
		
		try {
			employee.setEmailId(emailId);
			employee.setPassword(password);
			employeeServiceValidator.updateTicket(emailId, password, ticketId, status);
			if(loginDao.EmployeeLogin(employee))
			{
				int employeeId=employeeDao.findEmployeeId(emailId).getId();
				if(employeeId==(ticketDao.findEmployeeId(ticketId).getEmployeeId().getId())){
					ticket.setId(ticketId);
					employee.setId(employeeId);
					ticket.setEmployeeId(employee);
					ticket.setStatus(status);
					ticketDao.employeeUpdate(ticket);
				}
				}
			}catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Ticket", e);
			}
			
		
	}
	
	public void updateSolution(String emailId,String password,int ticketId,String solutionText) throws ServiceException, PersistenceException{
		try {
			employee.setEmailId(emailId);
			employee.setPassword(password);
			employeeServiceValidator.updateSolution(emailId, password, ticketId, solutionText);
			if(loginDao.EmployeeLogin(employee))
			{
				int employeeId=employeeDao.findEmployeeId(emailId).getId();
				if(employeeId==(ticketDao.findEmployeeId(ticketId).getEmployeeId().getId())){
				ticket.setId(ticketId);
				solution.setTicketId(ticket);
				solution.setSolution(solutionText);
				ticketAssignmentDao.solutionUpdate(solution);
				}
				}
			}catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Solution", e);
			}
	}
	
	public void showEmployeeTicket(String emailId,String password)throws ServiceException,PersistenceException
	{
		try {
			employee.setEmailId(emailId);
			employee.setPassword(password);
			employeeServiceValidator.showEmployeeTicket(emailId, password);
			if(loginDao.EmployeeLogin(employee))
			{
			int employeeId=employeeDao.findEmployeeId(emailId).getId();
			employee.setId(employeeId);
			ticketAssignmentDao.ViewEmployeeTicket(employee);
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Show Ticket", e);
			}
	}
	
	public void deleteTicket(String emailId,String password,int ticketId) throws ServiceException, PersistenceException{
		
		try {
			employee.setEmailId(emailId);
			employee.setPassword(password);
			employeeServiceValidator.deleteTicket(emailId, password, ticketId);
			if(loginDao.EmployeeLogin(employee))
			{
			int employeeId=employeeDao.findEmployeeId(emailId).getId();
			if((employeeDao.findEmployeeRoleId(employeeId).getRoleId().getId())==2){
				int existingEmployee=(employeeDao.findEmployeeDepartmentId(employeeId).getDepartmentId().getId());
				if(existingEmployee==(ticketDao.findDepartmentId(ticketId).getDepartmentId().getId())){
				solutionDao.delete(ticketId);
				ticketDao.delete(ticketId);
				}
			}
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Delete Ticket", e);
			}
	}


}
