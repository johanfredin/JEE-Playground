package com.pylonmusic.gigmanager.repository.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pylonmusic.gigmanager.TestFixture;
import com.pylonmusic.gigmanager.domain.IdHolder;
import com.pylonmusic.gigmanager.repository.BaseRepository;


/**
 * An abstract test class that tests basic CRUD functionality. All repositories
 * can reuse these tests, hereby reducing code duplication.
 * 
 * This class uses the Template pattern. This abstract class is the template
 * that coordinates basic test cases. The concrete implementations provide the
 * specific details, such as which entities and repositories to use etc.
 * 
 */
@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public abstract class AbstractRepositoryTest<E extends IdHolder, G extends BaseRepository<E>> {

	private static Logger log = Logger.getLogger(AbstractRepositoryTest.class.getName());

	/*
	 * Subclasses must return the repository to use
	 */
	protected abstract G getRepository();

	/*
	 * Sublcasses must return a valid entity to persist.
	 */
	protected abstract E getEntity1();

	/*
	 * Sublclasses must return a second valid entity. Should be different from
	 * entity 1.
	 */
	protected abstract E getEntity2();

	@Deployment
	public static Archive<?> createArchive() {
		return TestFixture.createIntegrationTestArchive();
	}

	@Test
	public void testCreate() {

		long id1 = getRepository().persist(getEntity1());
		long id2 = getRepository().persist(getEntity2());

		assertTrue("Entity 1 ID", id1 > 0);
		assertTrue("Entity 2 ID", id2 > id1);
		log.fine("testCreate() was called");
	}

	@Test
	public void testFindById() {

		long id = getRepository().persist(getEntity1());
		IdHolder entity = getRepository().findById(id);
		assertNotNull("Entity is not null", entity);
		assertEquals("Id is correct", id, entity.getId());
	}

	@Test
	public void testDelete() {

		long id = getRepository().persist(getEntity1());
		E entity = getRepository().findById(id);
		assertNotNull("Entity is not null", entity);

		getRepository().remove(entity);
		assertNull("Deleted object return null", getRepository().findById(id));
	}

	@Test
	public void testUpdate() {
		long id = getRepository().persist(getEntity1());
		E entity = getRepository().findById(id);

		// This doesn´t test much, but is still some control that no exception
		// is thrown.
		getRepository().update(entity);

	}

}
