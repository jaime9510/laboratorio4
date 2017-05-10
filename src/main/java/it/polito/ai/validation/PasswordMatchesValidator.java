package it.polito.ai.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import it.polito.ai.web.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches arg0) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());   
	}
	
	

}
