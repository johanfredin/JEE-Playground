package com.pylonmusic.gigmanager.domain.entitiy.enumerations;

import com.pylonmusic.gigmanager.domain.entitiy.ContactPerson;
import com.pylonmusic.gigmanager.domain.entitiy.Venue;

/**
 * A set of roles a {@link ContactPerson} could have at a {@link Venue}
 * @author root
 *
 */
public enum ContactPersonRole {
	
	/** Default value when no role is chosen for the {@link ContactPerson} */
	NOT_SET("No role chosen"),
	/** {@link ContactPerson} is a bartender */
	BARTENDER("Bartender"),
	/** {@link ContactPerson} is a booking agent */
	BOOKING_AGENT("Booker"),
	/** {@link ContactPerson} is a manager */
	MANAGER("Manager"),
	/** {@link ContactPerson} is a sound engineer */
	SOUND_ENGINEER("Sound Enginer"),
	/** {@link ContactPerson} is unspecified (could be anything) */
	OTHER("Other");
	
	private String role;
	
	private ContactPersonRole(String role) {
		setRole(role);
	}
	
	/**
	 * @return get the {@link #role} of associated entry
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Alter the {@link #role} of associated entry
	 * @param role
	 */
	private void setRole(String role) {
		this.role = role;
	}

}
