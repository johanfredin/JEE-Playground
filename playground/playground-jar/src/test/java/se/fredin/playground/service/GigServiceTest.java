package se.fredin.playground.service;



import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.List;

import se.fredin.playground.MockUtils;
import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.repository.ContactPersonRepository;
import se.fredin.playground.services.ContactPersonService;
import se.fredin.playground.services.impl.ContactPersonServiceImpl;

public class GigServiceTest extends ServiceTest {

	
	private ContactPersonService contactPersonService = new ContactPersonServiceImpl();
	private ContactPersonRepository mockContactPersonRepository;
	private List<ContactPerson> contactPersons;
	private ContactPerson contactPerson;
	
	@Override
	public void setupMock() {
		contactPersons = MockUtils.getMockedContacts();
		contactPerson = contactPersons.get(0);
		mockContactPersonRepository = createStrictMock(ContactPersonRepository.class);
		contactPersonService.setRepository(mockContactPersonRepository);
	}

	@Override
	public void testCreate() {
		expect(mockContactPersonRepository.persist(contactPerson)).andReturn(contactPerson.getId());
		expect(mockContactPersonRepository.findById(contactPerson.getId())).andReturn(contactPerson);
		replay(mockContactPersonRepository);
		
		contactPersonService.createEntity(contactPerson);
		verify(mockContactPersonRepository);
	}

	@Override
	public void testUpdate() {
		mockContactPersonRepository.update(contactPerson);
		replay(mockContactPersonRepository);
		
		contactPerson.setId(2L);
		contactPersonService.updateEntity(contactPerson);
		
		verify(mockContactPersonRepository);
	}

	@Override
	public void testDelete() {
		mockContactPersonRepository.remove(contactPerson);
		replay(mockContactPersonRepository);
		
		contactPersonService.deleteEntity(contactPerson);
		verify(mockContactPersonRepository);
	}

	@Override
	public void testFind() {
		expect(mockContactPersonRepository.findById(contactPerson.getId())).andReturn(contactPerson);
		replay(mockContactPersonRepository);
		
		contactPersonService.getEntity(contactPerson.getId());
		verify(mockContactPersonRepository);
	}

	@Override
	public void testGetAll() {
		expect(mockContactPersonRepository.getAllContacts()).andReturn(contactPersons);
		replay(mockContactPersonRepository);
		
		List<ContactPerson> allGigs = contactPersonService.getAllContacts();
		assertEquals(2, allGigs.size());
		verify(mockContactPersonRepository);
	}

}
