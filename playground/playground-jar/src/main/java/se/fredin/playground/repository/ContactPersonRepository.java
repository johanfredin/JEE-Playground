package se.fredin.playground.repository;

import java.util.List;

import se.fredin.playground.domain.entitiy.ContactPerson;

public interface ContactPersonRepository extends BaseRepository<ContactPerson> {

	/**
	 * @return a {@link List} containing all {@link Gig} entities
	 */
	List<ContactPerson> getAllContacts();
	
}
