package com.pylonmusic.gigmanager.domain.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pylonmusic.gigmanager.TestFixture;
import com.pylonmusic.gigmanager.domain.entitiy.Address;

public class AddressTest {
	
	@Test
	public void testEmptyConstructor() {
		Address address = new Address();
		assertEquals("Id should be", 0, address.getId());
		assertNull("Street should be null", address.getStreet());
		assertNull("Zip code should be null", address.getZipCode());
		assertNull("State or region should be null", address.getStateOrRegion());
		assertNull("Country should be null", address.getCountry());
	}
	
	@Test
	public void testSecondConstructor() {
		Address address = TestFixture.getValidAddress("Street", "City", "Zippie", "Region");
		assertEquals("Id should be", 0, address.getId());
		assertEquals("Street should be Street", "Street", address.getStreet());
		assertEquals("City should be City", "City", address.getCity());
		assertEquals("Zip code should be Zippie", "Zippie", address.getZipCode());
		assertEquals("State or region should be Region", "Region", address.getStateOrRegion());
		assertEquals("Country should be empty", "", address.getCountry());
	}
	
	@Test
	public void testThirdConstructor() {
		Address address = TestFixture.getValidAddress(1, "Street", "City", "Zippie", "Region", "Country");
		assertEquals("Id should be", 1, address.getId());
		assertEquals("Street should be Street", "Street", address.getStreet());
		assertEquals("City should be City", "City", address.getCity());
		assertEquals("Zip code should be Zippie", "Zippie", address.getZipCode());
		assertEquals("State or region should be Region", "Region", address.getStateOrRegion());
		assertEquals("Country should be Country", "Country", address.getCountry());
	}


}
