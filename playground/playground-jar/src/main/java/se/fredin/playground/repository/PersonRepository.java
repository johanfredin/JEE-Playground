package se.fredin.playground.repository;

import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.Person;

public interface PersonRepository extends BaseRepository<Person> {

	/**
	 * @return a {@link List} containing all {@link Gig} entities
	 */
	List<Person> getAllContacts();
	
}
