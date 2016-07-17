package com.pylonmusic.gigmanager.domain.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.pylonmusic.gigmanager.TestFixture;
import com.pylonmusic.gigmanager.domain.entitiy.Address;
import com.pylonmusic.gigmanager.domain.entitiy.ContactPerson;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;

public class VenueTest {

	@Test
	public void testEmptyConstructor() {
		Venue venue = new Venue();
		assertEquals("Id should be 0", 0L, venue.getId());
		assertNull("Venue should have no contact person yet", venue.getContactPersons());
		assertNull("Venue should have no adress yet", venue.getAddress());
		assertNull("Venue should have no name yet", venue.getName());
	}
	
	@Test
	public void testSecondConstructor() {
		Address address = TestFixture.getValidAddress("Streetir", "Citish", "666", "");
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1L, "Kalle", "Hokkanen");
		Venue venue = new Venue(0L, contactPerson, address);
		assertEquals("Venue should have 1 contact person added", 1, venue.getContactPersons().size());
		assertEquals("Zip code address for this venue should be 666", "666", venue.getAddress().getZipCode());
	}
	
	@Test
	public void testThirdConstructor() {
		Address address = TestFixture.getValidAddress("Streetir", "Citish", "666", "");
		ContactPerson contactPerson = TestFixture.getValidContactPerson(1L, "Kalle", "Hokkanen");
		Venue venue = new Venue(0L, contactPerson, address);
		assertEquals("Venue should have 1 contact person added", 1, venue.getContactPersons().size());
		assertEquals("Zip code address for this venue should be 666", "666", venue.getAddress().getZipCode());
	}
	
	@Test
	public void testNameAndUrl() {
		Venue venue = TestFixture.getValidVenue(1l, "Da Club", "http://www.daclub.org");
		assertEquals("Name should be \"Da Club\"", "Da Club", venue.getName());
		assertEquals("URL should be \"http://www.daclub.org\"", "http://www.daclub.org", venue.getUrl());
	}
	
	@Test
	public void testAddingContactPerson() {
		Venue venue = TestFixture.getValidVenue();
		assertEquals("Venue should have 1 contact person", 1, venue.getContactPersons().size());
		venue.addContactPerson(TestFixture.getValidContactPerson());
		assertEquals("Venue should now have 2 contactpersons", 2, venue.getContactPersons().size());
	}
	
	@Test
	public void testRemovingContactPerson() {
		Venue venue = TestFixture.getValidVenue(0L, "The Venue");
		
		assertNull("Venue should not have any contact persons yet", venue.getContactPersons());
		
		ContactPerson p1 = TestFixture.getValidContactPerson();
		ContactPerson p2 = TestFixture.getValidContactPerson(1, "Johan", "Fredin");
		venue.setContactPersons(TestFixture.getValidContactPersons(p1, p2));
		assertEquals("Venue should now have 2 contact persons", 2, venue.getContactPersons().size());
		
		venue.removeContactPerson(p1);
		assertEquals("Venue should now have 1 contact person", 1, venue.getContactPersons().size());
		assertEquals("First Name of remaining contact person should be Johan", "Johan", venue.getContactPersons().get(0).getFirstName());
	}
	


}
