package com.pylonmusic.gigmanager.services;

import java.util.List;

import javax.ejb.Local;

import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.repository.VenueRepository;

@Local
public interface VenueService extends ServiceBase<Venue, VenueRepository> {
	
	/**
	 * @return a {@link List} containing all the {@link Venue} entities
	 */
	List<Venue> getAllVenues();
	
}
