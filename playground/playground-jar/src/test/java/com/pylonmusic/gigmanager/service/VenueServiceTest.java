package com.pylonmusic.gigmanager.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.pylonmusic.gigmanager.MockUtils;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;
import com.pylonmusic.gigmanager.repository.VenueRepository;
import com.pylonmusic.gigmanager.services.VenueService;
import com.pylonmusic.gigmanager.services.impl.VenueServiceImpl;

public class VenueServiceTest extends ServiceTest {
	
	private VenueService venueService = new VenueServiceImpl();
	private VenueRepository mockVenueRepository;
	private List<Venue> venues;
	private Venue venue1;
	
	@Override
	public void setupMock() {
		venues = MockUtils.getMockedVenues();
		venue1 = venues.get(0);
		mockVenueRepository = createStrictMock(VenueRepository.class);
		venueService.setRepository(mockVenueRepository);
	}
	
	@Test
	public void testCreate() {
		expect(mockVenueRepository.persist(venue1)).andReturn(venue1.getId());
		expect(mockVenueRepository.findById(venue1.getId())).andReturn(venue1);
		replay(mockVenueRepository);
		
		venueService.createEntity(venue1);
		verify(mockVenueRepository);
	}
	
	@Override
	public void testUpdate() {
		mockVenueRepository.update(venue1);
		replay(mockVenueRepository);
		
		venue1.setName("Another Venue");
		venueService.updateEntity(venue1);
		
		verify(mockVenueRepository);
	}

	@Override
	public void testDelete() {
		mockVenueRepository.remove(venue1);
		replay(mockVenueRepository);
		
		venueService.deleteEntity(venue1);
		verify(mockVenueRepository);
	}

	@Override
	public void testFind() {
		expect(mockVenueRepository.findById(venue1.getId())).andReturn(venue1);
		replay(mockVenueRepository);
		
		venueService.getEntity(venue1.getId());
		verify(mockVenueRepository);
		
	}

	@Override
	public void testGetAll() {
		expect(mockVenueRepository.getAllVenues()).andReturn(venues);
		replay(mockVenueRepository);
		
		List<Venue> allVenues = venueService.getAllVenues();
		assertEquals(2, allVenues.size());
		verify(mockVenueRepository);
	}
	
	
}
