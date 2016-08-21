package se.fredin.playground.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.repository.AddressRepository;

@Stateless
public class JpaAddressRepository extends JpaRepository<Address> implements AddressRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAllAddresses() {
		return em.createQuery("select a from Address a").getResultList();
	}

}
