package se.fredin.playground.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;
import se.fredin.playground.validation.annotations.Unique;

public class UniqueValidator implements ConstraintValidator<Unique, String> {
	
	@Inject
	private PersonRepository personRepository;
	
	private static Set<String> existingVals = new HashSet<>();
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !existingVals.contains(value);
	}

	@Override
	public void initialize(Unique constraintAnnotation) {
		List<Person> allPersons = personRepository.getAllPersons();
		for(Person person : allPersons) {
			existingVals.add(person.getEmail() + "_" + person.getPhoneNr());
		}
	}

}
