package com.pylonmusic.gigmanager.domain.entity;

import org.junit.Test;

import com.pylonmusic.gigmanager.TestFixture;
import com.pylonmusic.gigmanager.domain.entitiy.ContactPerson;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.ContactPersonRole;

import junit.framework.TestCase;

public class ContactPersonTest extends TestCase {
	
	@Test
	public void testEmptyConstructor() {
		ContactPerson contactPerson = new ContactPerson();
		assertEquals("Id should be 0", 0, contactPerson.getId());
		assertNull("First name should be null", contactPerson.getFirstName());
		assertNull("Last name should be null", contactPerson.getLastName());
		assertNull("email should be null", contactPerson.getEmail());
		assertNull("phone nr should be null", contactPerson.getPhoneNr());
		assertNull("role should be null", contactPerson.getRole());
		assertNull("venue should be null", contactPerson.getVenue());
	}
	
	@Test
	public void testConstructor() {
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1, "Jon", "Doe");
		assertEquals("Id should be 1", 1, contactPerson.getId());
		assertEquals("First name should be", "Jon", contactPerson.getFirstName());
		assertEquals("Last name should be", "Doe", contactPerson.getLastName());
		assertEquals("email should be", "", contactPerson.getEmail());
		assertEquals("phone nr should be", "", contactPerson.getPhoneNr());
		assertEquals("role should be NOT_SET", ContactPersonRole.NOT_SET, contactPerson.getRole());
		assertEquals("role should be No role chosen", "No role chosen", contactPerson.getRole().getRole());
	}
	
	@Test
	public void testRoleAndEmail() {
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1, "JonDoe@doeman.com", ContactPersonRole.BARTENDER);
		assertEquals("Email should be JonDoe@doeman.com", "JonDoe@doeman.com", contactPerson.getEmail());
		assertEquals("Role should be Bartender", "Bartender", contactPerson.getRole().getRole());
	}
	
	@Test
	public void testAlteringRole() {
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1, "JonDoe@doeman.com", ContactPersonRole.NOT_SET);
		assertEquals("Role should be NOT_SET", ContactPersonRole.NOT_SET, contactPerson.getRole());
		assertEquals("display Role should be \"No role chosen\"", "No role chosen", contactPerson.getRole().getRole());
		contactPerson.setContactPersonRole(ContactPersonRole.MANAGER);
		assertEquals("Role should now be", ContactPersonRole.MANAGER, contactPerson.getRole());
	}
	
	@Test
	public void testVenueRelation() {
		ContactPerson contactPerson = TestFixture.getValidContactPerson();
		assertNotNull("Venue should not be null", contactPerson.getVenue());
		assertEquals("Name of Venue connected to Contact Person should be \"The Whiskey\"", "The Whiskey", contactPerson.getVenue().getName());
	}
	
	
}
