package se.fredin.playground.mvc.bean;



import javax.validation.Valid;

import se.fredin.playground.domain.entitiy.ContactPerson;

/**
 * Bean class for editing a {@link Gig}
 * @author johan
 *
 */
public class EditContactPersonBean {
	
	@Valid
	private ContactPerson contactPerson;
	
	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public ContactPerson getContactPerson() {
		return contactPerson;
	}

}
