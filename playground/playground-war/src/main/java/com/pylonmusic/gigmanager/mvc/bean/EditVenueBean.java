package com.pylonmusic.gigmanager.mvc.bean;

import javax.validation.Valid;

import com.pylonmusic.gigmanager.domain.entitiy.Venue;

public class EditVenueBean implements EditEntityBean<Venue> {

	@Valid
	private Venue venue;
	
	@Override
	public void setBean(Venue venue) {
		this.venue = venue;
	}
	
	@Override
	public Venue getBean() {
		return venue;
	}
	
}
