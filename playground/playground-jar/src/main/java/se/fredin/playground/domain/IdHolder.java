package se.fredin.playground.domain;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import se.fredin.playground.domain.entitiy.AbstractEntity;
import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.domain.entitiy.Person;

/**
 * An interface for all entities that can return a long ID. This is supposed to
 * be done by every JPA entity.
 * 
 * By having this simple interface we can reuse functionality for all JPA
 * entities. If a method returns an object of type IdHolder, we can cast that to
 * whatever object we expect.
 * @param <E>
 * 
 */
@JsonTypeInfo(use=Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	 @Type(value=AbstractEntity.class),
	 @Type(value=Address.class),
	 @Type(value=Person.class),
})
public interface IdHolder extends Serializable {
	
	/**
	 * Set the id of this {@link IdHolder}
	 * @param id
	 */
	void setId(long id);
	
	/**
	 * @return the id of this {@link IdHolder} implementation
	 */
	long getId();
	
	/**
	 * Should be used to determine what makes an entity unique, whereas {@link #getId()} returns the
	 * numeric identity (which is also unique) this one could be used when submitting a form to tell
	 * if that email already exist or that adress is taken to another venue etc
	 * @return whatever the class implementing this interface deems as qualifier for making this implementation unique
	 */
	String getUniqueId();
	
}
