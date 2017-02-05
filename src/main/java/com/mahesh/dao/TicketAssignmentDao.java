package com.mahesh.dao;

import java.util.List;

import com.mahesh.model.Employee;
import com.mahesh.model.Solution;
import com.mahesh.model.Ticket;


public class TicketAssignmentDao {
	
	TicketDao ticketDao=new TicketDao();
	SolutionDao solutionDao=new SolutionDao();
	
	
	public void reassignTicket(Ticket ticket){
		
		ticketDao.ticketReassign(ticket);
		
	}
		
	public List<Ticket> viewEmployeeTicket(Employee employee)
	{

		 return ticketDao.selectByEmployeeId(employee);
	}
	
	public void solutionUpdate(Solution solution,Ticket ticket){
		
		solutionDao.update(solution);
		ticketDao.updateSolution(ticket);
	}

}
