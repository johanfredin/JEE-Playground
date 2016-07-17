package com.pylonmusic.gigmanager.repository;

import java.util.List;

import com.pylonmusic.gigmanager.domain.entitiy.Venue;

public interface VenueRepository extends BaseRepository<Venue> {

	/**
	 * @return a {@link List} containing all {@link Venue} entities
	 */
	List<Venue> getAllVenues();
	
}
