package com.pylonmusic.gigmanager.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.repository.VenueRepository;
import com.pylonmusic.gigmanager.services.VenueService;

@Stateless
public class VenueServiceImpl extends AbstractServiceImpl<Venue, VenueRepository> implements VenueService {
	
	@Inject
	private VenueRepository venueRepository;
	
	@Override
	public List<Venue> getAllVenues() {
		return this.venueRepository.getAllVenues();
	}

	@Override
	public void setRepository(VenueRepository repository) {
		this.venueRepository = repository;
	}

	@Override
	public VenueRepository getRepository() {
		return venueRepository;
	}
	
}
