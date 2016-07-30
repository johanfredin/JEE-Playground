package se.fredin.playground.domain.entity;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.domain.entitiy.Pet;
import se.fredin.playground.domain.entitiy.PetType;

public class PersonTest {
	
	@Test
	public void testEmptyConstructor() {
		Person person = new Person();
		assertEquals("Id should be 0", 0, person.getId());
		assertNull("First name should be null", person.getFirstName());
		assertNull("Last name should be null", person.getLastName());
		assertNull("email should be null", person.getEmail());
		assertNull("phone nr should be null", person.getPhoneNr());
	}
	
	@Test
	public void testConstructor() {
		Person person = TestFixture.getValidPerson("Jon", "Doe", "", "", null, null);
		assertEquals("Id should be 0", 0, person.getId());
		assertEquals("First name should be", "Jon", person.getFirstName());
		assertEquals("Last name should be", "Doe", person.getLastName());
		assertEquals("email should be", "", person.getEmail());
		assertEquals("phone nr should be", "", person.getPhoneNr());
	}
	
	@Test
	public void testRoleAndEmail() {
		Pet pet = TestFixture.getValidPet();
		Address address = TestFixture.getValidAddress();
		Person person = TestFixture.getValidPerson("", "", "JonDoe@doeman.com", "", address, pet);
		assertEquals("Email should be JonDoe@doeman.com", "JonDoe@doeman.com", person.getEmail());
		assertEquals("Pet type should be CAT", PetType.DOG, person.getPet().getType());
	}
	
	@Test
	public void testPhoneNumber() {
		
		Person person = TestFixture.getValidPerson();
		person.setEmail("");
		person.setPhoneNr("abct");
		Validator validator = getValidator();
		Set<ConstraintViolation<Person>> violations = validator.validate(person);
		assertFalse(violations.isEmpty());
	}
	
	protected Validator getValidator() {
		Configuration<?> configure = Validation.byDefaultProvider().configure();
		return configure.buildValidatorFactory().getValidator();
	}
	
	
}
