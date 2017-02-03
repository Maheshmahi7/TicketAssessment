package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Ticket;
//import com.mahesh.model.Department;
//import com.mahesh.model.Priority;
import com.mahesh.model.User;

public class TestTicketCreationDao {

	public static void main(String[] args) {
		
		TicketCreationDao ticketCreationDao=new TicketCreationDao();
		User user=new User();
		user.setId(1);
		/*Department department=new Department();
		department.setId(2);
		Priority priority=new Priority();
		priority.setId(2);
		ticketCreationDao.createTicket(user, department, "Reg Issues", "Laptop is funtioning properly", priority);
*/
		//ticketCreationDao.updateTicket(3, user, "Laptop is not starting properly");
		
		
		List<Ticket> list = ticketCreationDao.viewTicket(user);
		Iterator<Ticket> i = list.iterator();
		while (i.hasNext()) {
			Ticket tickets=(Ticket) i.next();
			System.out.println(tickets.getId()+"\t"+tickets.getUserId().getId()+"\t"+tickets.getDepartmentId().getId()+"\t"+tickets.getSubject()
			+"\t"+tickets.getDescription()+"\t"+tickets.getEmployeeId().getId()+"\t"+tickets.getCreatedDate()+"\t"+tickets.getClosedDate()+"\t"+tickets.getStatus());
		}
		
	}

}
