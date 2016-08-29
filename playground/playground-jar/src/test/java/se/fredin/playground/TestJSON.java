package se.fredin.playground;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import se.fredin.playground.domain.IdHolder;
import se.fredin.playground.domain.entitiy.Person;

public class TestJSON {
	
	private List<IdHolder> entities;
	private ObjectMapper mapper = new ObjectMapper();
	private String jsonString;
	
	@Before
	public void init() {
		this.entities = new ArrayList<IdHolder>();
		this.entities.addAll(TestFixture.getValidPersons());
		this.entities.add(TestFixture.getValidAddress());
		this.jsonString = null;
		this.mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
	
	@Test
	public void testJSON() throws JsonProcessingException {
		Person person = TestFixture.getValidPerson();
		this.jsonString = this.mapper.writeValueAsString(person);
		assertNotNull("jsonString should not be null!", jsonString);
	}
	
	@Test
	public void testMixedJSONList() throws JsonProcessingException {
		this.jsonString = this.mapper.writeValueAsString(this.entities);
		assertNotNull("jsonString should not be null!", jsonString);
	}
	
	@Test
	public void testRetrievingJSONData() throws IOException {
		this.jsonString = this.mapper.writeValueAsString(TestFixture.getValidPerson());
		Person retrievedPerson = this.mapper.readValue(this.jsonString, Person.class);
		assertNotNull("Retrieved person should not be null", retrievedPerson);
	}
	
	
}
