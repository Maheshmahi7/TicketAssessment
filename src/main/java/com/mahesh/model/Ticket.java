package com.mahesh.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Ticket {
 
	private int id;
	private User userId;
	private Department DepartmentId;
	private String subject;
	private String description;
	private Priority priorityId;
	private Employee employeeId;
	private LocalDate createdDate;
	private Solution solutionId;
	private LocalDate closedDate;
	private String status;

}
