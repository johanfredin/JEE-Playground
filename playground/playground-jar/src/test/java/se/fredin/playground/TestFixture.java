package se.fredin.playground;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import se.fredin.playground.domain.entitiy.ContactPerson;


public class TestFixture {
	
	private static Logger log = Logger.getLogger(TestFixture.class.getName());
	
	// -----------------------------------------------------------------------------------------------------------------------
	// ------------------------------ CONTACT PERSON -------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return a new {@link ContactPerson} with all fields filled in with dummy values
	 */
	public static ContactPerson getValidContactPerson() {
		return getValidContactPerson(0, "Jon", "Doe", "jon.doe@dobi.com", "1234 531 341");
	}
	
	public static ContactPerson getValidContactPerson(long id, String firstName, String lastName) {
		return getValidContactPerson(id, firstName, lastName, "", "");
	}
	
	public static ContactPerson getValidContactPerson(long id, String email) {
		return getValidContactPerson(id, "", "", email, "");
	}
	
	public static ContactPerson getValidContactPerson(long id, String firstName, String lastName, String email, String phoneNr) {
		return new ContactPerson(id, firstName, lastName, email, phoneNr);
	}
	
	/**
	 * Helper for quickly adding some contact persons to venue constructor
	 * @param persons int
	 * @return
	 */
	public static List<ContactPerson> getValidContactPersons(ContactPerson... persons) {
		List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
		for(ContactPerson person : persons) {
			contactPersons.add(person);
		}
		return contactPersons;
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
