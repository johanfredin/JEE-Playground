package se.fredin.playground.domain.entity;



import org.junit.Test;

import junit.framework.TestCase;
import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Person;

public class PersonTest extends TestCase {
	
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
		Person person = TestFixture.getValidContactPerson(1, "Jon", "Doe");
		assertEquals("Id should be 1", 1, person.getId());
		assertEquals("First name should be", "Jon", person.getFirstName());
		assertEquals("Last name should be", "Doe", person.getLastName());
		assertEquals("email should be", "", person.getEmail());
		assertEquals("phone nr should be", "", person.getPhoneNr());
	}
	
	@Test
	public void testRoleAndEmail() {
		Person person = TestFixture.getValidContactPerson(1, "JonDoe@doeman.com");
		assertEquals("Email should be JonDoe@doeman.com", "JonDoe@doeman.com", person.getEmail());
	}
	
	
}
