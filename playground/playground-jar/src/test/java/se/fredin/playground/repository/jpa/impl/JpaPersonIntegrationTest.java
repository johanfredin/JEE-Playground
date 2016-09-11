package se.fredin.playground.repository.jpa.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Address;
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
		Person joe = getEntity1();
		Person jane = getEntity2();
		getRepository().persist(jane);
		getRepository().persist(joe);
		assertEquals("Amount of contacts should now be 2", 2, getRepository().getAllPersons().size());
	}
	
	@Test
	public void testGetFirstNameMatch() {
		Person joe = getEntity1();
		Person jane = getEntity2();
		getRepository().persist(jane);
		getRepository().persist(joe);
		List<Person> result = getRepository().getAllPersonsWithFirstNameLike("Jo");
		assertEquals("Finding a person with a name like Jo should result in 1 match", 1, result.size());
	}
	
	@Test
	public void testGetFirstNamesLimitedMatch() {
		Person joe = getEntity1();
		Person jane = getEntity2();
		getRepository().persist(jane);
		getRepository().persist(joe);
		List<Person> limitedResult = getRepository().getAllPersonsWithFirstNameLike("J", 1);
		assertEquals("Finding a person with a name like J with a limited result to 1 should result in 1 match", 1, limitedResult.size());
		List<Person> standardResult = getRepository().getAllPersonsWithFirstNameLike("J");
		assertEquals("Finding a person with a name like J with a standard result should result in 2 matches", 2, standardResult.size());
	}
	
	@Test
	public void testGetExistingEmails() {
		Person joe = getEntity1();
		Person jane = getEntity2();
		getRepository().persist(jane);
		getRepository().persist(joe);
		Person joe2 = TestFixture.getValidPerson();
		joe2.setAddress(new Address("S", "C", "Z", "STR", "CTR"));
		getRepository().persist(joe2);
		List<String> existingEmails = getRepository().getExistingEmails(joe2);
		boolean isUniqueEmail = existingEmails.isEmpty();
		assertFalse("Joe2 email should not be unique", isUniqueEmail);
		assertEquals("There should be 1 other person with joe2's email", 1, existingEmails.size());
		assertEquals("The matching email already existing should be \"jon.doe@dobi.com\"", "jon.doe@dobi.com", existingEmails.get(0));
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
