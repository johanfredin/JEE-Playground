package se.fredin.playground.repository.jpa;

import java.util.List;

import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.repository.ContactPersonRepository;

public class JpaContactPersonRepository extends JpaRepository<ContactPerson> implements ContactPersonRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactPerson> getAllContacts() {
		return em.createQuery("select c from ContactPerson c").getResultList();
	}

}
