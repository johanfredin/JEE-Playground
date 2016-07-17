package com.pylonmusic.gigmanager;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.pylonmusic.gigmanager.domain.entitiy.Address;
import com.pylonmusic.gigmanager.domain.entitiy.ContactPerson;
import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.ContactPersonRole;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.GigStatus;

public class TestFixture {
	
	private static Logger log = Logger.getLogger(TestFixture.class.getName());
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ ADDRESS --------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	public static Address getValidAddress() {
		return getValidAddress(0, "Street", "City", "Zippie", "Region", "");
	}
	
	public static Address getValidAddress(String street, String city, String zipCode, String region) {
		return getValidAddress(0, street, city, zipCode, region, "");
	}
	
	public static Address getValidAddress(long id, String street, String city, String zipCode, String region, String country) {
		return new Address(id, street, city, zipCode, region, country);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ CONTACT PERSON -------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return a new {@link ContactPerson} with all fields filled in with dummy values
	 */
	public static ContactPerson getValidContactPerson() {
		return getValidContactPerson(0, "Jon", "Doe", "jon.doe@dobi.com", "1234 531 341", ContactPersonRole.BOOKING_AGENT, getValidVenue());
	}
	
	public static ContactPerson getValidContactPerson(long id, String firstName, String lastName) {
		return getValidContactPerson(id, firstName, lastName, "", "", ContactPersonRole.NOT_SET, null);
	}
	
	public static ContactPerson getValidContactPerson(long id, String email, ContactPersonRole role) {
		return getValidContactPerson(id, "", "", email, "", role, null);
	}
	
	public static ContactPerson getValidContactPerson(long id, String email) {
		return getValidContactPerson(id, "", "", email, "", ContactPersonRole.NOT_SET, null);
	}
	
	public static ContactPerson getValidContactPerson(long id, String firstName, String lastName, String email, String phoneNr, ContactPersonRole role, Venue venue) {
		return new ContactPerson(id, firstName, lastName, email, phoneNr, role, venue);
	}
	
	/**
	 * Helper for quickly adding some contact persons to venue constructor
	 * @param persons int
	 * @return
	 */
	public static List<ContactPerson> getValidContactPersons(ContactPerson... persons) {
		List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
		for(ContactPerson person : persons) {
			contactPersons.add(person);
		}
		return contactPersons;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ VENUE ----------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return a new {@link Venue} with all fields filled in with dummy values
	 */
	public static Venue getValidVenue() {
		return getValidVenue(0, "The Whiskey", "http://www.thewhiskey.com", getValidContactPersons(new ContactPerson(0, "Hey@mail.com", ContactPersonRole.BARTENDER)), getValidAddress());
	}
	
	public static Venue getValidVenue(long id, String name) {
		return getValidVenue(id, name, null, null, null);
	}
	
	public static Venue getValidVenue(long id, String name, String url) {
		return getValidVenue(id, name, url, null, null);
	}
	
	public static Venue getValidVenue(long id, List<ContactPerson> contactPersons, Address adress) {
		return getValidVenue(id, null, null, contactPersons, adress);
	}
	
	public static Venue getValidVenue(long id, ContactPerson contactPerson, Address adress) {
		return new Venue(id, contactPerson, adress);
	}
	
	public static Venue getValidVenue(long id, String name, String url, List<ContactPerson> contactPersons, Address adress) {
		return new Venue(id, name, url, contactPersons, adress);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ GIG ------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	public static DateTime getDate(String date) {
		return DateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd"));
	}
	
	public static DateTime getTime(String time) {
		return DateTime.parse(time, DateTimeFormat.forPattern("HH:mm"));
	}
	
	public static Gig getValidGig() {
		DateTime date = getDate("2016-06-27");
		DateTime timeForShow = getTime("20:00");
		DateTime timeForSoundCheck = getTime("18:00");
		return new Gig(0, 100, true, true, true, true, true, getValidVenue(), GigStatus.STATUS_APPROVED, date, timeForShow, timeForSoundCheck, "Bring toothbrush");
	}
	
	/**
	 * @param revenue
	 * @return a new {@link Gig} instance with a {@link DateTime} for gig date and a passed in revenue
	 */
	public static Gig getValidGig(int revenue) {
		DateTime date = getDate("2016-06-27");
		Gig gig = new Gig();
		gig.setDate(date);
		gig.setRevenue(revenue);
		gig.setStatus(GigStatus.STATUS_PENDING);
		return gig;
	}
	
	
	
	@Deployment
	public static Archive<?> createIntegrationTestArchive() {
		
		PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml");
		 
		WebArchive war = ShrinkWrap.create(WebArchive.class, "GigManager_test.war");
		war.addPackages(true, "com.pylonmusic.gigmanager");
		war.addAsWebInfResource("beans.xml");
		war.addAsResource("META-INF/persistence.xml");
		
		war.addAsLibraries(pom.resolve("joda-time:joda-time:2.9.3").withTransitivity().asFile());
		war.addAsLibraries(pom.resolve("org.jadira.usertype:usertype.core:5.0.0.GA").withTransitivity().asFile());
		
		log.info("JAR: " + war.toString(true));
		return war;
	}
	
	public static void assertPropertyIsInvalid(String property, Set<? extends ConstraintViolation<?>> violations) {
		boolean errorFound = false;
		for (ConstraintViolation<?> constraintViolation : violations) {
			if (constraintViolation.getPropertyPath().toString().equals(property)) {
				errorFound = true;
				break;
			}
		}

		if (!errorFound) {
			fail("Expected validation error for '" + property + "', but no such error exists");
		}
	}

	public static Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	
	
}
