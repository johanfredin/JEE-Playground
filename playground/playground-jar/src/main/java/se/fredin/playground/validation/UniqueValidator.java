package se.fredin.playground.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.services.PersonService;
import se.fredin.playground.validation.annotations.Unique;

public class UniqueValidator implements ConstraintValidator<Unique, Person> {
	
	@Inject
	private PersonService personService;
	
	@Override
	public boolean isValid(Person value, ConstraintValidatorContext context) {
		return !personService.getAllPersons().contains(value);
	}

	@Override
	public void initialize(Unique constraintAnnotation) {}

}
