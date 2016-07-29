package se.fredin.playground.domain.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.domain.entitiy.PersonRegistery;

public class PersonRegisteryTest {

	@Test
	public void testNotNull() {
		PersonRegistery registery = TestFixture.getValidRegistery();
		assertNotNull("Registery should have persons not null", registery.getPersons());
		for(Person person : registery.getPersons()) {
			assertNotNull("Person assigned to registery should have an address", person.getAddress());
		}
	}
	
}
