package com.mahesh.validator;

import com.mahesh.exception.ValidatorException;
import com.mahesh.util.Validator;

public class UserServiceValidator {
	Validator validator=new Validator();
	
	public void registration(String name,String emailId,String password,Integer mobileNumber) throws ValidatorException{
		
		validator.isInvalid(name, "NAME");
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(mobileNumber, "MOBILENUMBER");
	}
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws ValidatorException{
	
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(subject, "SUBJECT");
		validator.isInvalid(description, "DESCRIPTION");
		validator.isInvalid(department, "DEPARTMENT");
		validator.isInvalid(priority, "PRIORITY");
	}
	public void updateTicket(String emailId,String password,int ticketId,String updateDescription) throws ValidatorException{
		
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(ticketId, "ISSUE_ID");
		validator.isInvalid(updateDescription, "DESCRIPTION");
	}
	
	public void updateClose(String emailId,String password,int issueId) throws ValidatorException{
		
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(issueId, "ISSUE_ID");
		
	}
	
	public void viewTicket(String emailId,String password) throws ValidatorException{
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
	}

}
