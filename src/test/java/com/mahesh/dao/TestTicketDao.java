package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Ticket;

public class TestTicketDao {

	public static void main(String[] args) {
		TicketDao ticketDao=new TicketDao();
		
		/*		Ticket ticket = new Ticket();
				User user = new User();
				user.setId(1);
				ticket.setUserId(user);
				Department department = new Department();
				department.setId(1);
				ticket.setDepartmentId(department);
				ticket.setSubject("Reg Mobile");
				ticket.setDescription("Black Mobile");
				Priority priority=new Priority();
				priority.setId(2);
				ticket.setPriorityId(priority);
				ticketDao.save(ticket);
				
				Employee employee=new Employee();
				employee.setId(2);
				ticket.setEmployeeId(employee);
				ticket.setId(5);
				ticketDao.update(ticket);
				

				ticketDao.delete(5);
			*/	
				List<Ticket> list = ticketDao.list();
				Iterator<Ticket> i = list.iterator();
				while (i.hasNext()) {
					Ticket tickets=(Ticket) i.next();
					System.out.println(tickets.getId()+"\t"+tickets.getUserId().getId()+"\t"+tickets.getDepartmentId().getId()+"\t"+tickets.getSubject()+"\t\t"+tickets.getDescription()
					+"\t"+tickets.getPriorityId().getId()+"\t"+tickets.getEmployeeId().getId()+"\t"+tickets.getCreatedDate()+"\t"+tickets.getClosedDate()+"\t"+tickets.getStatus());
				}



	}

}
