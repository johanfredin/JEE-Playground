package se.fredin.playground.services;


import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.repository.ContactPersonRepository;


@Local
public interface ContactPersonService extends ServiceBase<ContactPerson, ContactPersonRepository> {

	/**
	 * @return a {@link List} containing all the {@link Gig} entities
	 */
	List<ContactPerson> getAllContacts();
	
}
