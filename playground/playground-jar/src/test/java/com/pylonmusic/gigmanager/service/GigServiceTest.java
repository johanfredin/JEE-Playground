package com.pylonmusic.gigmanager.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.List;

import com.pylonmusic.gigmanager.MockUtils;
import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.repository.GigRepository;
import com.pylonmusic.gigmanager.services.GigService;
import com.pylonmusic.gigmanager.services.impl.GigServiceImpl;

public class GigServiceTest extends ServiceTest {

	
	private GigService gigService = new GigServiceImpl();
	private GigRepository mockGigRepository;
	private List<Gig> gigs;
	private Gig gig1;
	
	@Override
	public void setupMock() {
		gigs = MockUtils.getMockedGigs();
		gig1 = gigs.get(0);
		mockGigRepository = createStrictMock(GigRepository.class);
		gigService.setRepository(mockGigRepository);
	}

	@Override
	public void testCreate() {
		expect(mockGigRepository.persist(gig1)).andReturn(gig1.getId());
		expect(mockGigRepository.findById(gig1.getId())).andReturn(gig1);
		replay(mockGigRepository);
		
		gigService.createEntity(gig1);
		verify(mockGigRepository);
	}

	@Override
	public void testUpdate() {
		mockGigRepository.update(gig1);
		replay(mockGigRepository);
		
		gig1.setId(2L);
		gigService.updateEntity(gig1);
		
		verify(mockGigRepository);
	}

	@Override
	public void testDelete() {
		mockGigRepository.remove(gig1);
		replay(mockGigRepository);
		
		gigService.deleteEntity(gig1);
		verify(mockGigRepository);
	}

	@Override
	public void testFind() {
		expect(mockGigRepository.findById(gig1.getId())).andReturn(gig1);
		replay(mockGigRepository);
		
		gigService.getEntity(gig1.getId());
		verify(mockGigRepository);
	}

	@Override
	public void testGetAll() {
		expect(mockGigRepository.getAllGigs()).andReturn(gigs);
		replay(mockGigRepository);
		
		List<Gig> allGigs = gigService.getAllGigs();
		assertEquals(2, allGigs.size());
		verify(mockGigRepository);
	}

}
