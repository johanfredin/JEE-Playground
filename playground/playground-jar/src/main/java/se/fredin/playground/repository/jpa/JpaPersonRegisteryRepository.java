package se.fredin.playground.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import se.fredin.playground.domain.entitiy.PersonRegistery;
import se.fredin.playground.repository.PersonRegisteryRepository;

@Stateless
public class JpaPersonRegisteryRepository extends JpaRepository<PersonRegistery> implements PersonRegisteryRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonRegistery> getAllRegisters() {
		return em.createQuery("select r from PersonRegistery r").getResultList();
	}

}
