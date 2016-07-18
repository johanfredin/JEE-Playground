package se.fredin.playground;


import java.util.ArrayList;
import java.util.List;
import se.fredin.playground.domain.entitiy.Person;


/**
 * Some utility methods to use with mock implementations of repositories
 * @author johan
 *
 */
public class MockUtils {
	
	public static List<Person> getMockedContacts() {
		List<Person> contacts = new ArrayList<Person>();
		contacts.add(new Person(0L, "Jon", "Bon Jovi", "jonbon@jovi.com", "0763252525"));
		contacts.add(new Person(1L, "Lenny", "Kravits", "lenni.k@lenny.com", "0763123456"));
		contacts.add(new Person(2L, "Justin", "Bieber", "oh.yea@com", "0763666666"));
		return contacts;
	}
	
	public static List<Person> getMockedContacts2() {
		List<Person> contacts = new ArrayList<Person>();
		contacts.add(new Person(3L, "Sara", "Connor", "", ""));
		return contacts;
	}
	

}
