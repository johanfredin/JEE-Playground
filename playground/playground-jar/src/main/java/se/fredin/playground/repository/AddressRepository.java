package se.fredin.playground.repository;

import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.Address;

@Local
public interface AddressRepository extends BaseRepository<Address> {

	List<Address> getAllAddresses();
	
}
