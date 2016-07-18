package se.fredin.playground.mvc.bean;



import javax.validation.Valid;

import se.fredin.playground.domain.entitiy.Person;

/**
 * Bean class for editing a {@link Gig}
 * @author johan
 *
 */
public class EditContactPersonBean {
	
	@Valid
	private Person person;
	
	public void setContactPerson(Person person) {
		this.person = person;
	}
	
	public Person getContactPerson() {
		return person;
	}

}
