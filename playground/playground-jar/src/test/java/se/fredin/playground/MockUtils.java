package se.fredin.playground;


import java.util.ArrayList;
import java.util.List;
import se.fredin.playground.domain.entitiy.ContactPerson;


/**
 * Some utility methods to use with mock implementations of repositories
 * @author johan
 *
 */
public class MockUtils {
	
	public static List<ContactPerson> getMockedContacts() {
		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		contacts.add(new ContactPerson(0L, "Jon", "Bon Jovi", "jonbon@jovi.com", "0763252525"));
		contacts.add(new ContactPerson(1L, "Lenny", "Kravits", "lenni.k@lenny.com", "0763123456"));
		contacts.add(new ContactPerson(2L, "Justin", "Bieber", "oh.yea@com", "0763666666"));
		return contacts;
	}
	
	public static List<ContactPerson> getMockedContacts2() {
		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		contacts.add(new ContactPerson(3L, "Sara", "Connor", "", ""));
		return contacts;
	}
	

}
