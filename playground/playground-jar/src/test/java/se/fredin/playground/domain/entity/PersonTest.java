package se.fredin.playground.domain.entity;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
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
	
	@Test
	public void testPhoneNumber() {
		
		Person person = TestFixture.getValidPerson();
		person.setEmail("");
		person.setPhoneNr("abct");
		Validator validator = getValidator();
		Set<ConstraintViolation<Person>> violations = validator.validate(person);
		assertFalse(violations.isEmpty());
	}
	
	@Test
	public void testEquals() {
		Address address1 = TestFixture.getValidAddress();
		Address address2 = TestFixture.getValidAddress();
		
		address2.setId(2L);
		address2.setZipCode("Zip2");
		address2.setStateOrRegion("Region2");
		
		assertTrue("Address1 should still equal Address2", address1.equals(address2));
		
		address2.setCity("Another City");
		assertFalse("Address1 should no longer equal Address2", address1.equals(address2));
		
		address2.setCity(address1.getCity());
		assertTrue("Address1 should now equal Address2", address1.equals(address2));
		
		address2.setCountry("Another Country");
		assertFalse("Address1 should no longer equal Address2", address1.equals(address2));
	}
	
	protected Validator getValidator() {
		Configuration<?> configure = Validation.byDefaultProvider().configure();
		return configure.buildValidatorFactory().getValidator();
	}
	
}
