package com.mahesh.validator;

import com.mahesh.exception.ValidatorException;
import com.mahesh.util.Validator;

public class EmployeeServiceValidator {
	
	Validator validator=new Validator();
	
	public void ticketReassignment(String emailId,String password,int ticketId,int employeeId) throws ValidatorException{
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(ticketId, "TICKETID");
		validator.isInvalid(employeeId, "EMPLOYEEID");
	}
	
	public void updateTicket(String emailId,String password,int ticketId,String status) throws ValidatorException{
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(ticketId, "TICKETID");
		validator.isInvalid(status, "STATUS");
	}
	
	public void showEmployeeTicket(String emailId,String password) throws ValidatorException{
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");

	}
	public void updateSolution(String emailId,String password,int ticketId,int solutionId,String solutionText) throws ValidatorException{
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(ticketId, "TICKETID");
		validator.isInvalid(solutionId, "SOLUTIONID");
		validator.isInvalid(solutionText, "SOLUTION");

	}
	public void deleteTicket(String emailId,String password,int ticketId) throws ValidatorException{
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(ticketId, "TICKETID");
	}

}
