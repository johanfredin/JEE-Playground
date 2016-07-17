package com.pylonmusic.gigmanager.repository.jpa;

import java.util.List;

import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.repository.VenueRepository;

public class JpaVenueRepository extends JpaRepository<Venue> implements VenueRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Venue> getAllVenues() {
		return em.createQuery("select v from Venue v").getResultList();
	}

}
