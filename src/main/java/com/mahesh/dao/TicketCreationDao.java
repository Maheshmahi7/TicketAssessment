package com.mahesh.dao;

import com.mahesh.model.Department;
import com.mahesh.model.Priority;
import com.mahesh.model.Ticket;
import com.mahesh.model.User;

public class TicketCreationDao {
	
	TicketDao ticketDao=new TicketDao();
	Ticket ticket = new Ticket();
	
	public void createTicket(User userId,Department departmentId,String subject,String description,Priority priorityId)
	{
		TicketDao ticketDao=new TicketDao();
		Ticket ticket = new Ticket();
		ticket.setUserId(userId);
		ticket.setDepartmentId(departmentId);
		ticket.setSubject(subject);
		ticket.setDescription(description);
		ticket.setPriorityId(priorityId);
		ticketDao.save(ticket);
		
		
	}
	
	public void updateTicket(int id,User userId,String description)
	{
		if(ticketDao.findStatus(id,userId).getStatus()!="CLOSED")
		{
		ticket.setDescription(description);
		ticket.setId(id);
		ticket.setUserId(userId);
		ticketDao.update(ticket);
		}
	}
	
	public void viewTicket(User userId)
	{
		ticketDao.selectByUserId(userId);
	}
	
	public void closeTicket(int id,User userId){
		if(ticketDao.findStatus(id,userId).getStatus()!="CLOSED")
		{
		ticket.setStatus("CLOSED");
		ticket.setId(id);
		ticket.setUserId(userId);
		ticketDao.close(ticket);
		}
		
	}
	

}
