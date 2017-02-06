package com.mahesh.dao;

import java.util.List;
import java.util.logging.Logger;

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
	
	public void solutionUpdate(Solution solution){
		
		solutionDao.update(solution);
	}
	public void ViewEmployeeTicket(Employee employee){
	Logger logger = Logger.getLogger(TicketAssignmentDao.class.getName());
	List<Ticket> list = ticketDao.selectByEmployeeId(employee);
	for (Ticket ticket : list) {
		logger.info(ticket.getId() + "\t" + ticket.getUserId().getId()  + "\t" + ticket.getDepartmentId().getId()  + "\t" + ticket.getSubject() + "\t" + ticket.getDescription()  + "\t" + ticket.getPriorityId().getId() 
				 + "\t" + ticket.getEmployeeId().getId() + "\t"+ ticket.getCreatedDate() + "\t" + ticket.getStatus());
	}
	}


}
