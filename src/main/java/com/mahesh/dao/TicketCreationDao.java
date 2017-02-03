package com.mahesh.dao;

import java.util.List;

import com.mahesh.model.Department;
import com.mahesh.model.Priority;
import com.mahesh.model.Ticket;
import com.mahesh.model.User;

public class TicketCreationDao {
	
	TicketDao ticketDao=new TicketDao();
	LoginDao loginDao=new LoginDao();
	Ticket ticket = new Ticket();
	
	public void createTicket(User user,Department departmentId,String subject,String description,Priority priorityId)
	{
		
		TicketDao ticketDao=new TicketDao();
		Ticket ticket = new Ticket();
		user.getId();		
		ticket.setUserId(user);
		ticket.setDepartmentId(departmentId);
		ticket.setSubject(subject);
		ticket.setDescription(description);
		ticket.setPriorityId(priorityId);
		ticketDao.save(ticket);
				
	}
	
	public void updateTicket(int id,User user,String description)
	{
		if((ticketDao.findStatus(id,user)).getStatus()!="CLOSED")
		{
		ticket.setDescription(description);
		ticket.setId(id);
		ticket.setUserId(user);
		ticketDao.update(ticket);
		}
	}
	
	public List<Ticket> viewTicket(User user)
	{
		if(loginDao.UserLogin(user))
		{
		 return ticketDao.selectByUserId(user);
		}
		return null;
	}
	
	public void closeTicket(int id,User user)
	{
		if(ticketDao.findStatus(id,user).getStatus()!="CLOSED")
		{
		ticket.setStatus("CLOSED");
		ticket.setId(id);
		ticket.setUserId(user);
		ticketDao.close(ticket);
		}
			
	}
	

}
