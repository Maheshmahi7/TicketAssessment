package com.mahesh.validator;

import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Department;
import com.mahesh.util.Validator;

public class DepartmentValidator {
	
	Validator validator=new Validator();
	public void save(Department department) throws ValidatorException{
		validator.isInvalid(department.getName(), "NAME");
}

}
