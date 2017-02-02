package com.mahesh.model;

import java.time.LocalDate;

public class TestTicket {

	public static void main(String[] args) {

	
		Ticket ticket = new Ticket();
		ticket.setId(1);
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
		Employee employee = new Employee();
		employee.setId(1);
		ticket.setEmployeeId(employee);
		ticket.setCreatedDate(LocalDate.parse("2017-02-02"));
		ticket.setClosedDate(LocalDate.parse("2017-02-03"));
		ticket.setStatus("Closed");

		System.out.println(ticket);


	}

}
