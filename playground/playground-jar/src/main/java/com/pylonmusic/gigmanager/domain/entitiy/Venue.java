package com.pylonmusic.gigmanager.domain.entitiy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.URL;

import com.pylonmusic.gigmanager.domain.IdHolder;

/**
 * A venue represents a club, pub etc where the band can perform
 * it holds a reference to a {@link ContactPerson} and an address
 * @author johan
 *
 */
@Entity
@Table(name = "VENUE")
public class Venue implements IdHolder {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8612101898511939966L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VENUE_ID")
	private long id;
	
	@NotNull
	@Column(name="VENUE_NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="venue")
	@Type(type = "com.pylonmusic.gigmanager.domain.entity.ContactPerson")
	private List<ContactPerson> contactPersons;
	
	@NotNull
	@Type(type="com.pylonmusic.gigmanager.domain.entity.Address")
	@OneToOne(mappedBy="venue", cascade=CascadeType.ALL)
	private Address address;
	
	@URL
	private String url;
	
	/**
	 * Construct a new empty instance of a {@link Venue}
	 */
	public Venue() {}
	
	/**
	 * Construct a new instance of a {@link Venue}
	 * @param id the id of this {@link Venue}
	 * @param name the name of the {@link Venue}
	 */
	public Venue(long id, String name) {
		this(id, name, null, null);
	}
	
	/**
	 * Construct a new instance of a {@link Venue}
	 * @param id the id of this {@link Venue}
	 * @param name the name of the {@link Venue}
	 * @param url the url of the {@link Venue}
	 */
	public Venue(long id, String name, String url) {
		this(id, name, null, null);
	}
	
	/**
	 * Construct a new instance of a {@link Venue}
	 * @param id the id of this {@link Venue}
	 * @param contactPerson the {@link ContactPerson} of the {@link Venue}
	 * @param address the address of the {@link Venue}
	 */
	public Venue(long id, ContactPerson contactPerson, Address adress) {
		setId(id);
		this.contactPersons = new ArrayList<ContactPerson>();
		addContactPerson(contactPerson);
		setAddress(adress);
	}
	
	/**
	 * Construct a new instance of a {@link Venue}
	 * @param id the id of this {@link Venue}
	 * @param url the URL of this {@link Venue}
	 * @param contactPerson the {@link ContactPerson} of the {@link Venue}
	 * @param address the address of the {@link Venue}
	 */
	public Venue(long id, String url, List<ContactPerson> contactPersons, Address adress) {
		this(id,null, url, contactPersons, adress);
	}
	

	/**
	 * Construct a new instance of a {@link Venue}
	 * @param id the id of this {@link Venue}
	 * @param name the name of this {@link Venue}
	 * @param url the URL of this {@link Venue}
	 * @param contactPerson the {@link ContactPerson} of the {@link Venue}
	 * @param address the address of the {@link Venue}
	 */
	public Venue(long id, String name, String url, List<ContactPerson> contactPersons, Address adress) {
		setId(id);
		setName(name);
		setUrl(url);
		setContactPersons(contactPersons);
		setAddress(adress);
	}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the {@link ContactPerson}'s for this {@link Venue}
	 */
	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}
	
	/**
	 * @param contactPersons the {@link List} of {@link ContactPerson}'s for this {@link Venue}
	 */
	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}
	
	/**
	 * Add a {@link ContactPerson} to our {@link Venue}
	 * @param contactPerson the {@link ContactPerson} to add
	 */
	public void addContactPerson(ContactPerson contactPerson) {
		this.contactPersons.add(contactPerson);
	}
	
	/**
	 * Remove a {@link ContactPerson} to our {@link Venue}
	 * @param contactPerson the {@link ContactPerson} to remove
	 */
	public void removeContactPerson(ContactPerson contactPerson) {
		this.contactPersons.remove(contactPerson);
	}
	
	/**
	 * @param address the {@link Address} for this {@link Venue}
 	 */
	public void setAddress(Address adress) {
		this.address = adress;
	}
	
	/**
	 * Set the name of the {@link Venue}
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name of the {@link Venue}
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the {@link Address} for this {@link Venue}
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Set the url for the venue
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the url for the venue
	 */
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		char newLine = '\n';
		StringBuilder sb = new StringBuilder();
		sb.append(newLine);
		sb.append("VENUE").append(newLine);
		sb.append("=====").append(newLine);
		sb.append("Venue Id=").append(this.id).append(newLine);
		sb.append("Name=").append(this.name).append(newLine);
		sb.append("Url=").append(this.url).append(newLine);
		if(address != null) {
			sb.append("Address = ").append(newLine).
			append(this.address.toString()).append(newLine);
		}
		if(contactPersons != null) {
			for(ContactPerson contactPerson : this.contactPersons) {
				sb.append(contactPerson.toString());
			}
		}
		return sb.toString();
	}

	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		Venue populatedVenue = (Venue) populatedEntity;
		setId(populatedVenue.getId());
		setAddress(populatedVenue.getAddress());
		setContactPersons(populatedVenue.getContactPersons());
		setName(populatedVenue.getName());
		setUrl(populatedVenue.getName());
	}
}
