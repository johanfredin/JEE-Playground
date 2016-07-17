package com.pylonmusic.gigmanager.repository.jpa.impl;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pylonmusic.gigmanager.TestFixture;
import com.pylonmusic.gigmanager.domain.entitiy.ContactPerson;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.ContactPersonRole;
import com.pylonmusic.gigmanager.repository.VenueRepository;
import com.pylonmusic.gigmanager.repository.jpa.AbstractRepositoryTest;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public class JpaVenueRepositoryIntegrationTest extends AbstractRepositoryTest<Venue, VenueRepository> {

	@Inject
	private VenueRepository venueRepo;
	
	@Test
	public void testGetAllContactPersons() {
		getRepository().persist(getEntity1());
		getRepository().persist(getEntity2());
		assertEquals("Amount of venues should now be 2", 2, getRepository().getAllVenues().size());
	}

	@Override
	protected VenueRepository getRepository() {
		return venueRepo;
	}

	@Override
	protected Venue getEntity1() {
		Venue validVenue = TestFixture.getValidVenue(0L, "The Venue");
		validVenue.setAddress(TestFixture.getValidAddress());
		validVenue.setContactPersons(TestFixture.getValidContactPersons(new ContactPerson(0, "Johan.Fredin@mail.se", ContactPersonRole.BOOKING_AGENT)));
		return validVenue;
	}

	@Override
	protected Venue getEntity2() {
		Venue validVenue = TestFixture.getValidVenue(0L, "The Second Venue");
		validVenue.setAddress(TestFixture.getValidAddress());
		validVenue.setContactPersons(TestFixture.getValidContactPersons(new ContactPerson(0, "Johan.Lund@mail.se", ContactPersonRole.BARTENDER)));
		return validVenue;
	}

	

}
