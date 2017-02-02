package com.mahesh.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaction {

	private int id;
	private User userId;
	private Department departmentId;
	private String subject;
	private String description;
	private Priority priorityId;
	private Employee employeeId;
	private LocalDate createdDate;
	private LocalDate closedDate;
	private String status;


}
