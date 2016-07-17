package se.fredin.playground.repository;

import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.ContactPerson;

@Local
public interface ContactPersonRepository extends BaseRepository<ContactPerson> {

	/**
	 * @return a {@link List} containing all {@link Gig} entities
	 */
	List<ContactPerson> getAllContacts();
	
}
