package com.pylonmusic.gigmanager.repository;

import java.util.List;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;

public interface GigRepository extends BaseRepository<Gig> {

	/**
	 * @return a {@link List} containing all {@link Gig} entities
	 */
	List<Gig> getAllGigs();
	
}
