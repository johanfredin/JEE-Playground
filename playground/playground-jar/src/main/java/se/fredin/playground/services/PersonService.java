package se.fredin.playground.services;


import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;


@Local
public interface PersonService extends ServiceBase<Person, PersonRepository> {

	/**
	 * @return a {@link List} containing all the {@link Gig} entities
	 */
	List<Person> getAllContacts();
	
}
