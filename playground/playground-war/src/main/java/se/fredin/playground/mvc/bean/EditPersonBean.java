package se.fredin.playground.mvc.bean;



import javax.validation.Valid;

import se.fredin.playground.domain.entitiy.Person;

/**
 * Bean class for editing a {@link Person}
 * @author johan
 *
 */
public class EditPersonBean {
	
	@Valid
	private Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}

}
