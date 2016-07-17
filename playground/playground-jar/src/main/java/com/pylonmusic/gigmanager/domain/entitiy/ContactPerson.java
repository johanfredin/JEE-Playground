package com.pylonmusic.gigmanager.domain.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;

import com.pylonmusic.gigmanager.domain.IdHolder;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.ContactPersonRole;

/**
 * Domain class holding data for a {@link ContactPerson} at a {@link Venue}.
 * @author PylonMusic
 *
 */
@Entity
@Table(name = "CONTACTPERSON")
public class ContactPerson implements IdHolder {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8597280622650264264L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACTPERSON_ID")
	private long id;
	
	@Email
	@NotNull
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PHONE_NR")
	private String phoneNr;
	
	@Column(name="ROLE")
	private ContactPersonRole role;
	
	@ManyToOne
	@JoinColumn(name="VENUE_ID")
	@Type(type = "com.pylonmusic.gigmanager.domain.entity.Venue")
	private Venue venue;
	
	/**
	 * Default constructor
	 */
	public ContactPerson() {}
	
	/**
	 * Create a new {@link ContactPerson} instance passing in email and role
	 * @param id the identifier of this {@link ContactPerson}
	 * @param email the email of the {@link ContactPerson}
	 * @param phoneNr the phone nr of the {@link ContactPerson}
	 */
	public ContactPerson(long id, String email, ContactPersonRole role) {
		this(id, "", "", email, "", role);
	}
	
	/**
	 * Create a new {@link ContactPerson} instance passing in first and last name
	 * @param id the identifier of this {@link ContactPerson}
	 * @param firstName the first name of the {@link ContactPerson}
	 * @param lastName the last name of the {@link ContactPerson}
	 */
	public ContactPerson(long id, String firstName, String lastName) {
		this(id, firstName, lastName, "", "", ContactPersonRole.NOT_SET);
	}
	
	/**
	 * Create a new {@link ContactPerson} instance passing in first name, last name and email
	 * @param id the identifier of this {@link ContactPerson}
	 * @param firstName the first name of the {@link ContactPerson}
	 * @param lastName the last name of the {@link ContactPerson}
	 * @param email the email of the {@link ContactPerson}
	 */
	public ContactPerson(long id, String firstName, String lastName, String email) {
		this(id, firstName, lastName, email, "", ContactPersonRole.NOT_SET);
	}

	/**
	 * Create a new {@link ContactPerson} instance passing in all fields of this class
	 * @param id the identifier of this {@link ContactPerson}
	 * @param firstName the first name of the {@link ContactPerson}
	 * @param lastName the last name of the {@link ContactPerson}
	 * @param email the email of the {@link ContactPerson}
	 * @param phoneNr the phone nr of the {@link ContactPerson}
	 */
	public ContactPerson(long id, String firstName, String lastName, String email, String phoneNr) {
		this(id, firstName, lastName, email, phoneNr, ContactPersonRole.NOT_SET);
	}
	
	/**
	 * Create a new {@link ContactPerson} instance passing in all fields of this class
	 * @param id the identifier of this {@link ContactPerson}
	 * @param firstName the first name of the {@link ContactPerson}
	 * @param lastName the last name of the {@link ContactPerson}
	 * @param email the email of the {@link ContactPerson}
	 * @param phoneNr the phone nr of the {@link ContactPerson}
	 * @param role what role this contact person has at the {@link Venue}
	 */
	public ContactPerson(long id, String firstName, String lastName, String email, String phoneNr, ContactPersonRole role) {
		this(id, firstName, lastName, email, phoneNr, role, null);
	}
	
	/**
	 * Create a new {@link ContactPerson} instance passing in all fields of this class
	 * @param id the identifier of this {@link ContactPerson}
	 * @param firstName the first name of the {@link ContactPerson}
	 * @param lastName the last name of the {@link ContactPerson}
	 * @param email the email of the {@link ContactPerson}
	 * @param phoneNr the phone nr of the {@link ContactPerson}
	 * @param role what role this contact person has at the {@link Venue}
	 * @param venue the {@link Venue} this {@link ContactPerson} works at
	 */
	public ContactPerson(long id, String firstName, String lastName, String email, String phoneNr, ContactPersonRole role, Venue venue) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNr(phoneNr);
		setContactPersonRole(role);
		setVenue(venue);
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	/**
	 * @return the first name of this {@link ContactPerson}
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the first name of this {@link ContactPerson}
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the last name of the {@link ContactPerson}
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the last name of the {@link ContactPerson}
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the email of the {@link ContactPerson}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email of the {@link ContactPerson}
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone nr of the {@link ContactPerson}
	 */
	public String getPhoneNr() {
		return phoneNr;
	}

	/**
	 * @param phoneNr the phone nr the {@link ContactPerson}
	 */
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	/**
	 * Set what {@link ContactPersonRole} of the {@link ContactPerson}
	 * @param role
	 */
	public void setContactPersonRole(ContactPersonRole role) {
		this.role = role;
	}
	
	/**
	 * @return the {@link ContactPersonRole} this {@link ContactPerson} has at the {@link Venue}
	 */
	public ContactPersonRole getRole() {
		return role;
	}
	
	/**
	 * Set a {@link Venue} that this contact person works at
	 * @param venue
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	/**
	 * @return the {@link Venue} (if any) that this contact person works at
	 */
	public Venue getVenue() {
		return venue;
	}
	
	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		ContactPerson populatedContactPerson = (ContactPerson) populatedEntity;
		setId(populatedContactPerson.getId());
		setContactPersonRole(populatedContactPerson.getRole());
		setEmail(populatedContactPerson.getEmail());
		setFirstName(populatedContactPerson.getFirstName());
		setLastName(populatedContactPerson.getLastName());
		setPhoneNr(populatedContactPerson.getPhoneNr());
		setVenue(populatedContactPerson.getVenue());
	}
	
	@Override
	public String toString() {
		char newLine = '\n';
		return new StringBuilder().
			append(newLine).
			append("CONTACT-PERSON").append(newLine).
			append("==============").append(newLine).
			append("Contact Person Id=").append(this.id).append(newLine).
			append("First name=").append(this.firstName).append(newLine).
			append("Last name=").append(this.lastName).append(newLine).
			append("email=").append(this.email).append(newLine).
			append("Phone nr=").append(this.phoneNr).append(newLine).
			append("Role=").append(this.role.getRole()).
			toString();
	}
	
	
}
