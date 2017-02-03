package com.mahesh.dao;

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
		ticketCreationDao.updateTicket(3, user, "Laptop is not starting properly");
		
	}

}
