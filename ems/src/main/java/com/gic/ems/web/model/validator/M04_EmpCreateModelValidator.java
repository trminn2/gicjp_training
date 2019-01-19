package com.gic.ems.web.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class M04_EmpCreateModelValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "employeeId", "field.required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstname", "field.required");
	}
	
}