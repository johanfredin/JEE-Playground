package com.pylonmusic.gigmanager.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.repository.GigRepository;
import com.pylonmusic.gigmanager.services.GigService;

@Stateless
public class GigServiceImpl extends AbstractServiceImpl<Gig, GigRepository> implements GigService {

	@Inject
	private GigRepository gigRepository;
	
	@Override
	public void setRepository(GigRepository repository) {
		this.gigRepository = repository;
	}
	
	@Override
	public GigRepository getRepository() {
		return gigRepository;
	}
	
	@Override
	public List<Gig> getAllGigs() {
		return gigRepository.getAllGigs();
	}

}
