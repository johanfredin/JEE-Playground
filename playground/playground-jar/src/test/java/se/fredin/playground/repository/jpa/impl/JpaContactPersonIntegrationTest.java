package se.fredin.playground.repository.jpa.impl;



import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.repository.ContactPersonRepository;
import se.fredin.playground.repository.jpa.AbstractRepositoryTest;



@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public class JpaContactPersonIntegrationTest extends AbstractRepositoryTest<ContactPerson, ContactPersonRepository> {

	@Inject
	private ContactPersonRepository contactPersonRepo;
	
	@Test
	public void testGetAllContactPersons() {
		getRepository().persist(getEntity1());
		getRepository().persist(getEntity2());
		assertEquals("Amount of contacts should now be 2", 2, getRepository().getAllContacts().size());
	}

	@Override
	protected ContactPersonRepository getRepository() {
		return contactPersonRepo;
	}

	@Override
	protected ContactPerson getEntity1() {
		return new ContactPerson(0, "Jon", "Doe", "jon.doe@dobi.com", "1234 531 341");
	}

	@Override
	protected ContactPerson getEntity2() {
		return new ContactPerson(1, "Jane", "Doe", "jane.doe@dobi.com", "1234 531 ");
	}

	

}
