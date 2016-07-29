package se.fredin.playground.services;

import java.util.List;

import se.fredin.playground.domain.entitiy.PersonRegistery;
import se.fredin.playground.repository.PersonRegisteryRepository;

public interface PersonRegisteryService extends ServiceBase<PersonRegistery, PersonRegisteryRepository> {
	
	List<PersonRegistery> getAllRegisteries();

}
