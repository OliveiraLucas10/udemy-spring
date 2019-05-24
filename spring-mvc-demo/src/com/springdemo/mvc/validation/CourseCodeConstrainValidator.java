package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String>
{

	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation)
	{
		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext)
	{

		boolean result = theCode == null || theCode.startsWith(coursePrefix);

		return result;
	}

}
