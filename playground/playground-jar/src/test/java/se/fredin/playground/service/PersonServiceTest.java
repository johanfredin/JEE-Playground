package se.fredin.playground.service;



import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import se.fredin.playground.TestFixture;
import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.repository.PersonRepository;
import se.fredin.playground.services.PersonService;
import se.fredin.playground.services.impl.PersonServiceImpl;

public class PersonServiceTest extends ServiceTest {

	
	private PersonService personService = new PersonServiceImpl();
	private PersonRepository mockContactPersonRepository;
	private List<Person> persons;
	private Person person;
	
	@Override
	public void setupMock() {
		persons = TestFixture.getValidPersons();
		person = persons.get(0);
		mockContactPersonRepository = createStrictMock(PersonRepository.class);
		personService.setRepository(mockContactPersonRepository);
	}

	@Override
	public void testCreate() {
		expect(mockContactPersonRepository.persist(person)).andReturn(person.getId());
		expect(mockContactPersonRepository.findById(person.getId())).andReturn(person);
		replay(mockContactPersonRepository);
		
		personService.createEntity(person);
		verify(mockContactPersonRepository);
	}

	@Override
	public void testUpdate() {
		mockContactPersonRepository.update(person);
		replay(mockContactPersonRepository);
		
		person.setId(2L);
		personService.updateEntity(person);
		
		verify(mockContactPersonRepository);
	}

	@Override
	public void testDelete() {
		mockContactPersonRepository.remove(person);
		replay(mockContactPersonRepository);
		
		personService.deleteEntity(person);
		verify(mockContactPersonRepository);
	}

	@Override
	public void testFind() {
		expect(mockContactPersonRepository.findById(person.getId())).andReturn(person);
		replay(mockContactPersonRepository);
		
		personService.getEntity(person.getId());
		verify(mockContactPersonRepository);
	}

	@Override
	public void testGetAll() {
		expect(mockContactPersonRepository.getAllPersons()).andReturn(persons);
		replay(mockContactPersonRepository);
		
		List<Person> allContacts = personService.getAllPersons();
		assertEquals(2, allContacts.size());
		verify(mockContactPersonRepository);
	}
	
	@Test
	public void testGetPersonWithFirstNameMatch() {
		List<Person> expectedResultOfQueryList = Arrays.asList(new Person[]{person});
		expect(mockContactPersonRepository.getAllPersonsWithFirstNameLike("Jo")).andReturn(expectedResultOfQueryList).times(1);
		replay(mockContactPersonRepository);
		
		personService.getAllPersonsWithFirstNameLike("Jo");
		verify(mockContactPersonRepository);
	}

}
