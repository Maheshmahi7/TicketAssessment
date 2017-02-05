package com.mahesh.dao;

import com.mahesh.model.Employee;
import com.mahesh.model.Ticket;


public class TicketAssignment {
	
	TicketDao ticketDao=new TicketDao();
	public void reassignTicket(Employee employee,Ticket ticket){
		
		employee.setId(employee.getId());
		ticket.setEmployeeId(employee);
		ticketDao.ticketReassign(ticket);
		
	}
	
	public void updateTicket(Ticket ticket){
		
		ticketDao.employeeUpdate(ticket);
		
	}

}
