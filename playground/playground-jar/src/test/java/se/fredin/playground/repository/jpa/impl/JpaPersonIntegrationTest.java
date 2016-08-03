package se.fredin.playground.repository.jpa.impl;


import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;
import se.fredin.playground.repository.jpa.AbstractRepositoryTest;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public class JpaPersonIntegrationTest extends AbstractRepositoryTest<Person, PersonRepository> {

	@Inject
	private PersonRepository personRepository;
	
	@Test
	public void testGetAllContactPersons() {
		getRepository().persist(getEntity1());
		getRepository().persist(getEntity2());
		assertEquals("Amount of contacts should now be 2", 2, getRepository().getAllPersons().size());
	}
	
	@Test
	public void testGetFirstNameMatch() {
		Person joe = getEntity1();
		Person jane = getEntity2();
		getRepository().persist(joe);
		getRepository().persist(jane);
		assertEquals("Finding a person with a name like Jo should result in 1 match", 1, getRepository().getAllPersonsWithFirstNameLike("Jo").size());
	}

	@Override
	protected PersonRepository getRepository() {
		return personRepository;
	}

	@Override
	protected Person getEntity1() {
		return TestFixture.getValidPerson();
	}

	@Override
	protected Person getEntity2() {
		return TestFixture.getValidPerson2();
	}

	

}
