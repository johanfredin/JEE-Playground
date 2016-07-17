package com.pylonmusic.gigmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.pylonmusic.gigmanager.domain.entitiy.Address;
import com.pylonmusic.gigmanager.domain.entitiy.ContactPerson;
import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.ContactPersonRole;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.GigStatus;

/**
 * Some utility methods to use with mock implementations of repositories
 * @author johan
 *
 */
public class MockUtils {
	
	public static List<ContactPerson> getMockedContacts() {
		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		contacts.add(new ContactPerson(0L, "Jon", "Bon Jovi", "jonbon@jovi.com", "0763252525", ContactPersonRole.BOOKING_AGENT));
		contacts.add(new ContactPerson(1L, "Lenny", "Kravits", "lenni.k@lenny.com", "0763123456", ContactPersonRole.SOUND_ENGINEER));
		contacts.add(new ContactPerson(2L, "Justin", "Bieber", "oh.yea@com", "0763666666", ContactPersonRole.BARTENDER));
		return contacts;
	}
	
	public static List<ContactPerson> getMockedContacts2() {
		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		contacts.add(new ContactPerson(3L, "Sara", "Connor", "", "", ContactPersonRole.BOOKING_AGENT));
		return contacts;
	}
	
	public static List<Address> getMockedAddresses() {
		return Arrays.asList(
			new Address[]{
				new Address(0L, "Le Street", "Le City", "43141", "State", "Country"),
				new Address(1L, "Calle 30", "Mexico DF", "CP45670", "DF", "Mexico"),
				new Address(2L, "SaboStreet", "SaboTown", "SaboZip123", "SaboState", "SaboCountry")
			}
		);
	}
	
	public static List<Venue> getMockedVenues() {
		return Arrays.asList(
			new Venue[]{
				new Venue(0L, "Venue 1", getMockedContacts(), getMockedAddresses().get(0)),
				new Venue(1L, "Venue 2", getMockedContacts2(), getMockedAddresses().get(0))
			}
		);
	}
	
	public static List<Gig> getMockedGigs() {
		return Arrays.asList(
			new Gig[] {
				new Gig(0, 1000, true, true, true, true, true, getMockedVenues().get(0),GigStatus.STATUS_DISCOVERED, getDate("2016-06-28"), getTime("22:00"), getTime("17:30"), "Bring stick"),
				new Gig(1L, 0, false, false, false, false, false, getMockedVenues().get(1), GigStatus.STATUS_APPROVED, getDate("1992-09-22"), null, null, "What a shitty place!")
			}
		);
	}
	
	public static DateTime getDate(String date) {
		return DateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd"));
	}
	
	public static DateTime getTime(String time) {
		return DateTime.parse(time, DateTimeFormat.forPattern("HH:mm"));
	}

}
