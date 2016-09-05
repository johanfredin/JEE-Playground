package se.fredin.playground.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.repository.AddressRepository;
import se.fredin.playground.services.AddressService;

@Stateless
public class AddressServiceImpl extends AbstractServiceImpl<Address, AddressRepository> implements AddressService {
	
	@Inject
	private AddressRepository repository;
	
	@Override
	public List<Address> getAllAddresses() {
		return repository.getAllAddresses();
	}

	@Override
	public void setRepository(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public AddressRepository getRepository() {
		return this.repository;
	}

	@Override
	public Set<String> getUniqueIds() {
		Set<String> uniqueIds = new HashSet<String>();
		for(Address address : getAllAddresses()) {
			uniqueIds.add(address.getUniqueId());
		}
		return uniqueIds;
	}

}
