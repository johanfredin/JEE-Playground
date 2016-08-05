package se.fredin.playground.repository;

import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.Person;

@Local
public interface PersonRepository extends BaseRepository<Person> {

	/**
	 * @return a {@link List} containing all {@link Person} entities
	 */
	List<Person> getAllPersons();
	
	/**
	 * @param firstName the firstname to compare to
	 * @return a list with all persons whose first name is like passed in firstName
	 */
	List<Person> getAllPersonsWithFirstNameLike(String firstName);
	
	/**
	 * @param firstName the firstname to compare to
	 * @return a list with all persons whose first name is like passed in firstName
	 */
	List<String> getAllFirstNamesLike(String firstName);
}
