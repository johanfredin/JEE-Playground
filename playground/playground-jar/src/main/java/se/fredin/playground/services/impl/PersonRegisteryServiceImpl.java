package se.fredin.playground.services.impl;

import java.util.List;

import javax.inject.Inject;

import se.fredin.playground.domain.entitiy.PersonRegistery;
import se.fredin.playground.repository.PersonRegisteryRepository;
import se.fredin.playground.services.PersonRegisteryService;

public class PersonRegisteryServiceImpl extends AbstractServiceImpl<PersonRegistery, PersonRegisteryRepository> implements PersonRegisteryService {

	@Inject
	private PersonRegisteryRepository repository;
	
	@Override
	public void setRepository(PersonRegisteryRepository repository) {
		this.repository = repository;
	}

	@Override
	public PersonRegisteryRepository getRepository() {
		return this.repository;
	}

	@Override
	public List<PersonRegistery> getAllRegisteries() {
		return getRepository().getAllRegisters();
	}

}
