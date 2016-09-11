package se.fredin.playground.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;

@Stateless
public class JpaPersonRepository extends JpaRepository<Person> implements PersonRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersons() {
		return em.createQuery("select p from Person p").getResultList();
	}
	
	@Override
	public List<Person> getAllPersonsWithFirstNameLike(String firstName) {
		return getAllPersonsWithFirstNameLike(firstName, MAX_RESULTS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersonsWithFirstNameLike(String firstName, int maxResults) {
		Query query = em.createQuery("select p from Person p where p.firstName like:param");
		query.setParameter("param", firstName + "%");
		query.setMaxResults(maxResults);
		return query.getResultList();
	}
	
	// select * from PERSON WHERE EMAIL = 'johanfredin205@gmail.com' and PERSON_ID != 1 

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getExistingEmails(Person person) {
		Query query = em.createQuery("select p.email from Person p where p.email=:email and p.id !=:id");
		query.setParameter("email", person.getEmail());
		query.setParameter("id", person.getId());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getExistingPhoneNrs(Person person) {
		Query query = em.createQuery("select p.phoneNr from Person p where p.phoneNr=:phoneNr and p.id !=:id");
		query.setParameter("phoneNr", person.getPhoneNr());
		query.setParameter("id", person.getId());
		return query.getResultList();
	}

	
}
