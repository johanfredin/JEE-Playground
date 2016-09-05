package se.fredin.playground.domain.entitiy;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import se.fredin.playground.domain.IdHolder;

public abstract class AbstractEntity implements IdHolder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3025466194050844855L;
	
	/**
	 * Intended to be used for copying the fields from the populatedEntity
	 * @param populatedEntity the {@link IdHolder} with the data
	 */
	public abstract void copyDataFromEntity(IdHolder populatedEntity);
	
	/**
	 * Our entities have {@link OneToOne}, {@link ManyToOne}, {@link OneToMany} relations
	 * this method should make sure that relations are set both ways.<br>
	 * <b>Example</b>:<br>
	 * class Entity1 has an instance of Class Entity2 and they have a {@link OneToOne} relation<br>
	 * Entity1 must then both set the Entity2 instance the usual way<br>
	 * and assign itself to Entity2 so that:<br><br>
	 * <code>public void setRelations() {<br>
	 * this.getEntity2().setEntity1(this);<br>
	 * }<br>
	 *
	 */
	public abstract void setRelations();
	
	/**
	 * @return <code>true</code> if {@link #getId()} > 0
	 */
	@JsonIgnore
	public boolean isExistingEntity() {
		return isExistingEntity(getId());
	}
	
	/**
	 * @param id
	 * @return <code>true</code> if passed in id > 0
	 */
	@JsonIgnore
	public boolean isExistingEntity(long id) {
		return id > 0;
	}
	
	/**
	 * Helper method for Entities overriding the {@link #equals(Object)} method
	 * It uses trim and ignore case on the passed in fields
	 * @param ourField
	 * @param otherField
	 * @return <code>true</code> if <b>ourField.trim().equalsIgnoreCase(otherField.trim();</b>
	 */
	@JsonIgnore
	public boolean strEq(String ourField, String otherField) {
		return ourField.trim().equalsIgnoreCase(otherField.trim());
	}
	
	@JsonIgnore
	public String strSqueze(String value) {
		return value.replace(" ", "").trim();
	}
	
	/**
	 * Custom implementation of the {@link #equals(Object)} method.
	 * This equals method first tries to compare the {@link #getUniqueId()} of this instance with the object to compare against.
	 * If {@link #getUniqueId()} == null the standard {@link #equals(Object)} method will be called
	 * This one compares {@link #uniqueId}
	 */
	@Override
	public boolean equals(Object obj) {
		AbstractEntity other = (AbstractEntity) obj;
		if(this.getUniqueId() == null) {
			return super.equals(other);
		}
		return other.getUniqueId().equalsIgnoreCase(this.getUniqueId());
	}
	

}
