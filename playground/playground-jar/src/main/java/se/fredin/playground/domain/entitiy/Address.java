package se.fredin.playground.domain.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import se.fredin.playground.domain.IdHolder;


/**
 * Domain object containing data for an address for an {@link Address}
 * @author johan
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2582703777627336786L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private long id;
	
	@NotBlank
	@Column(name="STREET")
	private String street;
	
	@NotBlank
	@Column(name="CITY")
	private String city;
	
	@Column(name="ZIPCODE")
	private String zipCode;

	@NotBlank
	@Column(name="STATE_OR_REGION")
	private String stateOrRegion;
	
	@Column(name="COUNTRY")
	private String country;
	
	/**
	 * Construct a new empty {@link Address} instance 
	 */
	public Address() {}
	
	/**
	 * Construct a new {@link Address} instance
	 * @param street the street of the {@link Address}
	 * @param city the city of the {@link Address}
	 */
	public Address(String street, String city) {
		this(street, city, "", "", "");
	}
	
	/**
	 * Construct a new {@link Address} instance
	 * @param street the street of the {@link Address}
	 * @param city the city of the {@link Address}
	 * @param zipCode the the zipcode of the {@link Address}
	 * @param stateOrRegion the state/region of the {@link Address}
	 */
	public Address(String street, String city, String zipCode, String stateOrRegion) {
		this(street, city, zipCode, stateOrRegion, "");
	}
	
	/**
	 * Construct a new {@link Address} instance
	 * @param street the street of the {@link Address}
	 * @param city the city of the {@link Address}
	 * @param zipCode the the zipcode of the {@link Address}
	 * @param stateOrRegion the state/region of the {@link Address}
	 * @param country the country where the {@link Address} is
	 */
	public Address(String street, String city, String zipCode, String stateOrRegion, String country) {
		setStreet(street);
		setCity(city);
		setZipCode(zipCode);
		setStateOrRegion(stateOrRegion);
		setCountry(country);
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
	 * @return the street of the {@link Address}
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Set the street of the {@link Address}
	 * @param street the street of the {@link Address}
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Set the city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the City
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @return the zipcode of the {@link Address}
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * set the zipcode of the {@link Address}
	 * @param zipCode the zipcode of the {@link Address}
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * @return the state/region of the {@link Address}
	 */
	public String getStateOrRegion() {
		return stateOrRegion;
	}

	/**
	 * Set the state/region of the {@link Address}
	 * @param stateOrRegion the state/region of the {@link Address}
	 */
	public void setStateOrRegion(String stateOrRegion) {
		this.stateOrRegion = stateOrRegion;
	}

	/**
	 * @return the country where this {@link Address} is based
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Set the country where this {@link Address} is located
	 * @param country the country where this {@link Address} is located
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		char newLine = '\n';
		return new StringBuilder().
			append("ADDRESS").append(newLine).
			append("=======").append(newLine).
			append("Address Id=").append(this.id).append(newLine).
			append("Street=").append(this.street).append(newLine).
			append("Zip Code=").append(this.zipCode).append(newLine).
			append("State/Region=").append(this.stateOrRegion).append(newLine).
			append("Country=").append(this.country).append(newLine).
			toString();
	}

	@Override
	public void setRelations() {
		
	}

	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		Address populatedAddres = (Address) populatedEntity;
		setId(populatedAddres.getId());
		setCity(populatedAddres.getCity());
		setCountry(populatedAddres.getCountry());
		setStateOrRegion(populatedAddres.getStateOrRegion());
		setStreet(populatedAddres.getStreet());
		setZipCode(populatedAddres.getZipCode());
	}
	
	

}
