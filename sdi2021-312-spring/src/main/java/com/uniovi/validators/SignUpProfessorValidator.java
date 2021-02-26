package com.uniovi.validators;


import com.uniovi.entities.*;
import com.uniovi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class SignUpProfessorValidator implements Validator {

	@Autowired
	private ProfessorsService profService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Professor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Professor prof = (Professor) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		if (prof.getDni().length() != 9 && !isText(prof.getDni().charAt(prof.getDni().length()-1))) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
		if (profService.getUserByDni(prof.getDni()) != null) {
			errors.rejectValue("dni", "Error.signup.dni.duplicate");
		}
		if (prof.getName().length() < 5 || prof.getName().length() > 24) {
			errors.rejectValue("name", "Error.signup.name.length");
		}
		if (prof.getSurname().length() < 5 || prof.getSurname().length() > 24) {
			errors.rejectValue("surname", "Error.signup.lastName.length");
		}
	}

	private boolean isText(char c) {
		if(Character.isDigit(c))
			return false;
		return true;
	}

}
