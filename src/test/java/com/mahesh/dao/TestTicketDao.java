package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Ticket;
import com.mahesh.model.User;

public class TestTicketDao {

	public static void main(String[] args) {
		
		TicketDao ticketDao=new TicketDao();
		
				Ticket ticket = new Ticket();
				User user = new User();
				user.setId(1);
				user.setEmailId("mahesh11317@gmail.com");
		/*		ticket.setUserId(user);
				Department department = new Department();
				department.setId(1);
				ticket.setDepartmentId(department);
				ticket.setSubject("Reg Mobile");
				ticket.setDescription("Black Mobile");
				Priority priority=new Priority();
				priority.setId(2);
				ticket.setPriorityId(priority);
				ticketDao.save(ticket);
				*/
				ticket.setDescription("Changing");
				ticket.setUserId(user);
				ticket.setId(1);
				ticketDao.update(ticket);
				

			//	ticketDao.delete(5);
				
				List<Ticket> list = ticketDao.selectByUserId(user);
				Iterator<Ticket> i = list.iterator();
				while (i.hasNext()) {
					Ticket tickets=(Ticket) i.next();
					System.out.println(tickets.getId()+"\t"+tickets.getUserId().getId()+"\t"+tickets.getDepartmentId().getId()+"\t"+tickets.getSubject()+"\t\t"+tickets.getDescription()
					+"\t"+tickets.getPriorityId().getId()+"\t"+tickets.getEmployeeId().getId()+"\t"+tickets.getCreatedDate()+"\t"+tickets.getClosedDate()+"\t"+tickets.getStatus());
				}



	}

}
