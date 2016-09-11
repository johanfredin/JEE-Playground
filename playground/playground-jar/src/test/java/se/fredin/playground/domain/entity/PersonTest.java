package se.fredin.playground.domain.entity;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.domain.entitiy.Person;

public class PersonTest {
	
	@Test
	public void testEmptyConstructor() {
		Person person = new Person();
		assertEquals("Id should be 0", 0, person.getId());
		assertTrue("First name should be empty", person.getFirstName().isEmpty());
		assertTrue("Last name should be empty", person.getLastName().isEmpty());
		assertTrue("email should be empty", person.getEmail().isEmpty());
		assertTrue("phone nr should be empty", person.getPhoneNr().isEmpty());
	}
	
	@Test
	public void testConstructor() {
		Person person = TestFixture.getValidPerson("Jon", "Doe", "", "", null);
		assertEquals("Id should be 0", 0, person.getId());
		assertEquals("First name should be", "Jon", person.getFirstName());
		assertEquals("Last name should be", "Doe", person.getLastName());
		assertEquals("email should be", "", person.getEmail());
		assertEquals("phone nr should be", "", person.getPhoneNr());
	}
	
	@Test
	public void testRoleAndEmail() {
		Address address = TestFixture.getValidAddress();
		Person person = TestFixture.getValidPerson("", "", "JonDoe@doeman.com", "", address);
		assertEquals("Email should be JonDoe@doeman.com", "JonDoe@doeman.com", person.getEmail());
	}
	
//	@Test
//	public void testPhoneNumber() {
//		
//		Person person = TestFixture.getValidPerson();
//		person.setEmail("");
//		person.setPhoneNr("abct");
//		Validator validator = getValidator();
//		Set<ConstraintViolation<Person>> violations = validator.validate(person);
//		assertFalse(violations.isEmpty());
//	}
	
	protected Validator getValidator() {
		Configuration<?> configure = Validation.byDefaultProvider().configure();
		return configure.buildValidatorFactory().getValidator();
	}
	
}
