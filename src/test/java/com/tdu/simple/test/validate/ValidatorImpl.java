package com.tdu.simple.test.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorImpl implements ConstraintValidator<TValidator, Object> {

	boolean required;
	String maxLength;
	String minLength;
	String minValue;
	String maxValue;
	String pattren;
	String[] list;
	String type;

	@Override
	public void initialize(TValidator constraintAnnotation) {
		required = constraintAnnotation.required();
		maxLength = constraintAnnotation.maxLength();
		minLength = constraintAnnotation.minLength();
		minValue = constraintAnnotation.minValue();
		maxValue = constraintAnnotation.maxValue();
		pattren = constraintAnnotation.pattren();
		list = constraintAnnotation.list();
		type = constraintAnnotation.type();
		constraintAnnotation.groups();
		//System.err.println(constraintAnnotation.payload());
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		//context.disableDefaultConstraintViolation();
		//context.buildConstraintViolationWithTemplate("ddddd").addConstraintViolation();
		return false;
	}

}
