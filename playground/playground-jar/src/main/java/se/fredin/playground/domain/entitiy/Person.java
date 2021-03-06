package se.fredin.playground.domain.entitiy;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import se.fredin.playground.domain.IdHolder;

@Entity
@Table(name = "PERSON")
public class Person extends AbstractEntity {
	
	private static final long serialVersionUID = 6757754030293161155L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	private long id;
	
	@NotBlank
	@Email
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PHONE_NR")
	private String phoneNr;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="person", fetch=FetchType.LAZY, orphanRemoval=true)
	@JsonManagedReference
	private Address address;
	
	/**
	 * Default constructor
	 */
	public Person() {
		this("", "", "", "", null);
	}
	
	/**
	 * Create a new {@link Person} instance passing in email and role
	 * @param email the email of the {@link Person}
	 * @param phoneNr the phone nr of the {@link Person}
	 */
	public Person(String email) {
		this("", "", email, "");
	}
	
	/**
	 * Create a new {@link Person} instance passing in first and last name
	 * @param firstName the first name of the {@link Person}
	 * @param lastName the last name of the {@link Person}
	 */
	public Person(String firstName, String lastName) {
		this(firstName, lastName, "", "");
	}
	
	/**
	 * Create a new {@link Person} instance passing in first name, last name and email
	 * @param firstName the first name of the {@link Person}
	 * @param lastName the last name of the {@link Person}
	 * @param email the email of the {@link Person}
	 */
	public Person(String firstName, String lastName, String email) {
		this(firstName, lastName, email, "");
	}

	/**
	 * Create a new {@link Person} instance passing in all fields of this class
	 * @param firstName the first name of the {@link Person}
	 * @param lastName the last name of the {@link Person}
	 * @param email the email of the {@link Person}
	 * @param phoneNr the phone nr of the {@link Person}
	 */
	public Person(String firstName, String lastName, String email, String phoneNr) {
		this(firstName, lastName, email, phoneNr, null);
	}
	
	
	/**
	 * Create a new {@link Person} instance passing in all fields of this class
	 * @param firstName the first name of the {@link Person}
	 * @param lastName the last name of the {@link Person}
	 * @param email the email of the {@link Person}
	 * @param address the {@link Address} of this {@link Person}
	 * 
	 */
	public Person(String firstName, String lastName, String email, String phoneNr, Address address) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNr(phoneNr);
		setAddress(address);
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		Person populaterPerson = (Person) populatedEntity;
		setId(populaterPerson.getId());
		setEmail(populaterPerson.getEmail());
		setFirstName(populaterPerson.getFirstName());
		setLastName(populaterPerson.getLastName());
		setPhoneNr(populaterPerson.getPhoneNr());
		setAddress(populaterPerson.getAddress());
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append("First name=").append(this.firstName).append('\n')
			.append("Last name=").append(this.lastName).append('\n')
			.append("Email=").append(this.email).append('\n')
			.append("Phone=").append(this.phoneNr).append('\n')
			.toString();
	}
	
	@Override
	public void setRelations() {
		if(getAddress() != null) {
			getAddress().setPerson(this);
		}
	}

}
