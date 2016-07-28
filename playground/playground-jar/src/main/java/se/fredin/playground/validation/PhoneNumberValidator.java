package se.fredin.playground.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import se.fredin.playground.validation.annotations.PhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

	private final String VALID_CONTENT = "0123456789+() -";
	
	@Override
	public void initialize(PhoneNumber constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.isEmpty()) {
			return true; // Phone nr is not mandatory!
		}
		
		char firstChar = value.charAt(0);
		char lastChar = value.charAt(value.length() -1);
		
		if((!Character.isDigit(firstChar) || firstChar != '+') && Character.isDigit(lastChar)) {
			return false;
		}
		
		for(Character c : value.toCharArray()) {
			if(!VALID_CONTENT.contains(c.toString())) {
				return false;
			}
		}
		return true;
	}

}
