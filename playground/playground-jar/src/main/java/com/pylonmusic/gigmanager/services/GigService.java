package com.pylonmusic.gigmanager.services;

import java.util.List;

import javax.ejb.Local;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.repository.GigRepository;

@Local
public interface GigService extends ServiceBase<Gig, GigRepository> {

	/**
	 * @return a {@link List} containing all the {@link Gig} entities
	 */
	List<Gig> getAllGigs();
	
}
