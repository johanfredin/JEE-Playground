package se.fredin.playground.repository.jpa.impl;

import javax.inject.Inject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.PersonRegistery;
import se.fredin.playground.repository.PersonRegisteryRepository;
import se.fredin.playground.repository.jpa.AbstractRepositoryTest;

public class JpaPersonRegisteryRepositoryTest extends AbstractRepositoryTest<PersonRegistery, PersonRegisteryRepository> {

	@Inject
	private PersonRegisteryRepository repository;
	
	@Test
	public void testGetAll() {
		getRepository().persist(getEntity1());
		getRepository().persist(getEntity2());
		assertEquals("Registeries should be 2", 2, getRepository().getAllRegisters().size());
	}

	@Override
	protected PersonRegisteryRepository getRepository() {
		return this.repository;
	}

	@Override
	protected PersonRegistery getEntity1() {
		return TestFixture.getValidRegistery();
	}

	@Override
	protected PersonRegistery getEntity2() {
		return TestFixture.getValidRegistery2();
	}

}
