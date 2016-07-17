package com.pylonmusic.gigmanager.mvc.bean;

import javax.validation.Valid;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;

/**
 * Bean class for editing a {@link Gig}
 * @author johan
 *
 */
public class EditGigBean {
	
	@Valid
	private Gig gig;
	
	public void setGig(Gig bean) {
		this.gig = bean;
	}

	public Gig getGig() {
		return this.gig;
	}

}
