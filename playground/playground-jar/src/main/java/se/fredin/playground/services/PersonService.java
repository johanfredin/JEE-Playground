package se.fredin.playground.services;


import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;


@Local
public interface PersonService extends ServiceBase<Person, PersonRepository> {

	List<Person> getAllPersons();
	
	List<Person> getAllPersonsWithFirstNameLike(String firstName);
	
	List<Person> getAllPersonsWithFirstNameLike(String firstName, int maxResults);
	
	List<String> getExistingEmails(Person person);
	
	List<String> getExistingPhoneNrs(Person person);
	
	boolean isUniqueEmail(Person person);
	
	boolean isUniquePhoneNr(Person person);
	
}
