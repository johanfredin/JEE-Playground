package se.fredin.playground.repository.jpa.impl;



import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;
import se.fredin.playground.repository.jpa.AbstractRepositoryTest;



@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public class JpaPersonIntegrationTest extends AbstractRepositoryTest<Person, PersonRepository> {

	@Inject
	private PersonRepository contactPersonRepo;
	
	@Test
	public void testGetAllContactPersons() {
		getRepository().persist(getEntity1());
		getRepository().persist(getEntity2());
		assertEquals("Amount of contacts should now be 2", 2, getRepository().getAllContacts().size());
	}

	@Override
	protected PersonRepository getRepository() {
		return contactPersonRepo;
	}

	@Override
	protected Person getEntity1() {
		return new Person(0, "Jon", "Doe", "jon.doe@dobi.com", "1234 531 341");
	}

	@Override
	protected Person getEntity2() {
		return new Person(1, "Jane", "Doe", "jane.doe@dobi.com", "1234 531 ");
	}

	

}
