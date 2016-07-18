package se.fredin.playground;



import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import se.fredin.playground.domain.entitiy.Person;


public class TestFixture {
	
	private static Logger log = Logger.getLogger(TestFixture.class.getName());
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ CONTACT PERSON -------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return a new {@link Person} with all fields filled in with dummy values
	 */
	public static Person getValidPerson() {
		return getValidPerson("Jon", "Doe", "jon.doe@dobi.com", "1234 531 341");
	}
	
	public static Person getValidPerson(String firstName, String lastName, String email, String phoneNr) {
		return new Person(firstName, lastName, email, phoneNr);
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
