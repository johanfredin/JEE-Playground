package com.pylonmusic.gigmanager.domain.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import com.pylonmusic.gigmanager.TestFixture;
import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.GigStatus;

public class GigTest {

	@Test
	public void testFirstConstructor() {
		Gig gig = new Gig();
		assertNull("Venue should be null", gig.getVenue());
		assertNull("Date should be null", gig.getDate());
		assertNull("Time for show should be null", gig.getTimeForShow());
		assertNull("Time for soundcheck should be null", gig.getTimeForSoundcheck());
		assertEquals("Revenue should be 0", 0, gig.getRevenue());
		assertFalse("Has backline should be false", gig.isBackline());
		assertFalse("Travel compensation should be false", gig.isTravelCompensation());
		assertFalse("Food included should be false", gig.isFoodIncluded());
		assertFalse("Free beets should be false", gig.isFreeBeverages());
		assertFalse("Has backstage should be false", gig.isBackStage());
		assertNull("Notes should be null", gig.getSideNotes());
	}
	
	@Test
	public void testSecondConstructor() {
		Gig gig = new Gig(1, new Venue());
		assertNotNull("Venue should not be null", gig.getVenue());
		assertNull("Date should be null", gig.getDate());
		assertNull("Time for show should be null", gig.getTimeForShow());
		assertNull("Time for soundcheck should be null", gig.getTimeForSoundcheck());
		assertEquals("Revenue should be 0", 0, gig.getRevenue());
		assertFalse("Has backline should be false", gig.isBackline());
		assertFalse("Travel compensation should be false", gig.isTravelCompensation());
		assertFalse("Food included should be false", gig.isFoodIncluded());
		assertFalse("Free beverages should be false", gig.isFreeBeverages());
		assertFalse("Has backstage should be false", gig.isBackStage());
		assertEquals("Notes should be empty", "", gig.getSideNotes());
	}
	
	@Test
	public void testThirdConstructor() {
		Gig gig = new Gig(1, new Venue(), new DateTime());
		assertNotNull("Venue should be null", gig.getVenue());
		assertNotNull("Date should  not be null", gig.getDate());
		assertNull("Time for show should be null", gig.getTimeForShow());
		assertNull("Time for soundcheck should be null", gig.getTimeForSoundcheck());
		assertEquals("Revenue should be 0", 0, gig.getRevenue());
		assertFalse("Has backline should be false", gig.isBackline());
		assertFalse("Travel compensation should be false", gig.isTravelCompensation());
		assertFalse("Food included should be false", gig.isFoodIncluded());
		assertFalse("Free beets should be false", gig.isFreeBeverages());
		assertFalse("Has backstage should be false", gig.isBackStage());
		assertEquals("Notes should be empty", "", gig.getSideNotes());
	}
	
	@Test
	public void testFullGigConstructor() {
		Gig gig = TestFixture.getValidGig();
		assertEquals("Revenue should be 100", 100, gig.getRevenue());
		assertTrue("Venue should have backline", gig.isBackline());
		assertTrue("Venue should have travel compensation", gig.isTravelCompensation());
		assertTrue("Venue should have food included", gig.isFoodIncluded());
		assertTrue("Venue should serve free beverages", gig.isFreeBeverages());
		assertTrue("Venue should have backstage", gig.isBackStage());
		assertEquals("Status should be \"STATUS_APPROVED\"", GigStatus.STATUS_APPROVED, gig.getStatus());
		assertNotNull("Venue should exist for the gig", gig.getVenue());
		assertEquals("Date for gig should be 2016-06-27", "2016-06-27", gig.getDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
		assertEquals("Time for show should be 20:00", "20:00", gig.getTimeForShow().toString(DateTimeFormat.forPattern("HH:mm")));
		assertEquals("Time for show should be 18:00", "18:00", gig.getTimeForSoundcheck().toString(DateTimeFormat.forPattern("HH:mm")));
		assertEquals("Side notes should be \"Bring toothbrush\"", "Bring toothbrush", gig.getSideNotes());
	}
	
	

	


	
}
