package se.fredin.playground.services.impl;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.repository.ContactPersonRepository;
import se.fredin.playground.services.ContactPersonService;

@Stateless
public class ContactPersonServiceImpl extends AbstractServiceImpl<ContactPerson, ContactPersonRepository> implements ContactPersonService {

	@Inject
	private ContactPersonRepository contactPersonRepository;
	
	@Override
	public void setRepository(ContactPersonRepository repository) {
		this.contactPersonRepository = repository;
	}
	
	@Override
	public ContactPersonRepository getRepository() {
		return contactPersonRepository;
	}
	
	@Override
	public List<ContactPerson> getAllContacts() {
		return contactPersonRepository.getAllContacts();
	}

}
