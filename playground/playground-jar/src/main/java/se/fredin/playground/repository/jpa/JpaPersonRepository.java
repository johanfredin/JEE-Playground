package se.fredin.playground.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;

@Stateless
public class JpaPersonRepository extends JpaRepository<Person> implements PersonRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersons() {
		return em.createQuery("select p from Person p").getResultList();
	}

}
