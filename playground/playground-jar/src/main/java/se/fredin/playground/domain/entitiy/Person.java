package se.fredin.playground.domain.entitiy;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import se.fredin.playground.domain.IdHolder;

/**
 * Domain class holding data for a {@link Person}
 * @author johan
 *
 */
@Entity
@Table(name = "PERSON")
public class Person implements IdHolder {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6757754030293161155L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSON_ID")
	private long id;
	
	@NotNull
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PHONE_NR")
	private String phoneNr;
	
	/**
	 * Default constructor
	 */
	public Person() {}
	
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
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNr(phoneNr);
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
	 * @return the first name of this {@link Person}
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the first name of this {@link Person}
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the last name of the {@link Person}
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the last name of the {@link Person}
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the email of the {@link Person}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email of the {@link Person}
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone nr of the {@link Person}
	 */
	public String getPhoneNr() {
		return phoneNr;
	}

	/**
	 * @param phoneNr the phone nr the {@link Person}
	 */
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		Person populaterPerson = (Person) populatedEntity;
		setId(populaterPerson.getId());
		setEmail(populaterPerson.getEmail());
		setFirstName(populaterPerson.getFirstName());
		setLastName(populaterPerson.getLastName());
		setPhoneNr(populaterPerson.getPhoneNr());
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
	
}
