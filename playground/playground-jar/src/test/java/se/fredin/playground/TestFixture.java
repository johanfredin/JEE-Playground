package se.fredin.playground;



import java.util.Arrays;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.domain.entitiy.Person;


public class TestFixture {
	
	private static Logger log = Logger.getLogger(TestFixture.class.getName());
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ PERSON ---------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return a new {@link Person} with all fields filled in with dummy values
	 */
	public static Person getValidPerson() {
		return getValidPerson("Jon", "Doe", "jon.doe@dobi.com", "1234 531 341", getValidAddress());
	}
	
	public static Person getValidPerson2() {
		return getValidPerson("Jane", "Doe", "jane.doe@dobi.com", "1234 666 341", getValidAddress("hagåkers", "mölndal", "43141", "västra götaland"));
	}
	
	public static Person getValidPerson(String firstName, String lastName, String email, String phoneNr, Address address) {
		return new Person(firstName, lastName, email, phoneNr, address);
	}
	
	public static List<Person> getValidPersons() {
		return Arrays.asList(
			new Person[]{
				getValidPerson(), 
				getValidPerson2()
			}
		);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ ADDRESS --------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return street="Street", city="City", zipCode="Zippie", stateOrRegion="Region"
	 */
	public static Address getValidAddress() {
		return getValidAddress("Street", "City", "Zippie", "Region");
	}
	
	public static Address getValidAddress(String street, String city, String zipCode, String region) {
		return new Address(street, city, zipCode, region, "");
	}
	
	
	@Deployment
	public static Archive<?> createIntegrationTestArchive() {
		
		WebArchive war = ShrinkWrap.create(WebArchive.class, "playground_test.war");
		war.addPackages(true, "se.fredin.playground");
		war.addAsWebInfResource("beans.xml");
		war.addAsResource("META-INF/persistence.xml");
		
		log.info("JAR: " + war.toString(true));
		return war;
	}
	
	public static Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	
	
}
