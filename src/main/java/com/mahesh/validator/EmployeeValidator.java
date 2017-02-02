package com.mahesh.validator;

import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Employee;
import com.mahesh.util.Validator;

public class EmployeeValidator {
	
	Validator validator=new Validator();
	public void save(Employee employee) throws ValidatorException{
		validator.isInvalid(employee.getName(), "NAME");
		validator.isInvalid(employee.getEmailId(),"EMAIL_ID");
		validator.isInvalid(employee.getPassword(),"PASSWORD");
}


}
