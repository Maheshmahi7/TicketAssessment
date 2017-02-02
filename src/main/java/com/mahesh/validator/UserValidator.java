package com.mahesh.validator;

import com.mahesh.exception.ValidatorException;
import com.mahesh.model.User;
import com.mahesh.util.Validator;

public class UserValidator {
	
	Validator validator=new Validator();
	public void save(User user) throws ValidatorException{
		validator.isInvalid(user.getName(), "NAME");
		validator.isInvalid(user.getEmailId(),"EMAIL_ID");
		validator.isInvalid(user.getPassword(), "PASSWORD");

}

}
