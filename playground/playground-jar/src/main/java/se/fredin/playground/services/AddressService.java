package se.fredin.playground.services;

import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.repository.AddressRepository;

@Local
public interface AddressService extends ServiceBase<Address, AddressRepository> {
	
	List<Address> getAllAddresses();
	
}
