package se.fredin.playground.services.impl;

import java.util.List;

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


}
