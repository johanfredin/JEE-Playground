package se.fredin.playground.domain.entity;



import org.junit.Test;

import junit.framework.TestCase;
import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.ContactPerson;

public class ContactPersonTest extends TestCase {
	
	@Test
	public void testEmptyConstructor() {
		ContactPerson contactPerson = new ContactPerson();
		assertEquals("Id should be 0", 0, contactPerson.getId());
		assertNull("First name should be null", contactPerson.getFirstName());
		assertNull("Last name should be null", contactPerson.getLastName());
		assertNull("email should be null", contactPerson.getEmail());
		assertNull("phone nr should be null", contactPerson.getPhoneNr());
	}
	
	@Test
	public void testConstructor() {
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1, "Jon", "Doe");
		assertEquals("Id should be 1", 1, contactPerson.getId());
		assertEquals("First name should be", "Jon", contactPerson.getFirstName());
		assertEquals("Last name should be", "Doe", contactPerson.getLastName());
		assertEquals("email should be", "", contactPerson.getEmail());
		assertEquals("phone nr should be", "", contactPerson.getPhoneNr());
	}
	
	@Test
	public void testRoleAndEmail() {
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1, "JonDoe@doeman.com");
		assertEquals("Email should be JonDoe@doeman.com", "JonDoe@doeman.com", contactPerson.getEmail());
	}
	
	
}
