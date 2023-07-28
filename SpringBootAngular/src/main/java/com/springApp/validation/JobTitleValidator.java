package com.springApp.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class JobTitleValidator implements ConstraintValidator<ValidateJobTitle, String> {

	@Override
	public boolean isValid(String title, ConstraintValidatorContext context) {
		List<String> jobTitles = Arrays.asList("Team-Lead","Developer","Tester");
		
		return jobTitles.contains(title);
	}

}
