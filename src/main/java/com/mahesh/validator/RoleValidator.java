package com.mahesh.validator;
import com.mahesh.exception.ValidatorException;
import com.mahesh.model.Role;
import com.mahesh.util.Validator;



public final class RoleValidator {
	
	Validator validator=new Validator();
	public void save(Role role) throws ValidatorException{
		validator.isInvalid(role.getName(), "NAME");
}
}
