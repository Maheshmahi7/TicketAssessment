package com.mahesh.validator;

import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Priority;
import com.mahesh.util.Validator;

public class PriorityValidator {
	Validator validator=new Validator();
	public void save(Priority priority) throws ValidatorException{
		validator.isInvalid(priority.getName(), "NAME");
}

}
