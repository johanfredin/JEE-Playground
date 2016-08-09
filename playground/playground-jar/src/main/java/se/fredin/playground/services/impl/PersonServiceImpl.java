package se.fredin.playground.services.impl;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;
import se.fredin.playground.services.PersonService;

@Stateless
public class PersonServiceImpl extends AbstractServiceImpl<Person, PersonRepository> implements PersonService {

	@Inject
	private PersonRepository personRepository;
	
	@Override
	public void setRepository(PersonRepository repository) {
		this.personRepository = repository;
	}
	
	@Override
	public PersonRepository getRepository() {
		return personRepository;
	}
	
	@Override
	public List<Person> getAllPersons() {
		return personRepository.getAllPersons();
	}

	@Override
	public List<Person> getAllPersonsWithFirstNameLike(String firstName) {
		return personRepository.getAllPersonsWithFirstNameLike(firstName);
	}

	@Override
	public List<Person> getAllPersonsWithFirstNameLike(String firstName, int maxResults) {
		return personRepository.getAllPersonsWithFirstNameLike(firstName, maxResults);
	}
	

}
