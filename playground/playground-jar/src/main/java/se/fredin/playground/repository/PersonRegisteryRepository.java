package se.fredin.playground.repository;

import java.util.List;

import javax.ejb.Local;

import se.fredin.playground.domain.entitiy.PersonRegistery;

@Local
public interface PersonRegisteryRepository extends BaseRepository<PersonRegistery> {
	
	List<PersonRegistery> getAllRegisters();

}
