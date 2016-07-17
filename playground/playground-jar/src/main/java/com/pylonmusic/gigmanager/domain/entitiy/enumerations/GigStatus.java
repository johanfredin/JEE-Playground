package com.pylonmusic.gigmanager.domain.entitiy.enumerations;

/**
 * Helper enum for different statuses on a possible show
 * @author johan
 *
 */
public enum GigStatus {
	
	/** A venue has been discovered but needs more research before proceeding to contact them */
	STATUS_DISCOVERED("Discovered"),
	/** The venue seems interesting for the artist/band */
	STATUS_INTERESTING("Interesting"),
	/** The venue is not interesting for the artist/band */
	STATUS_NOT_INTERESTING("Not interesting"),
	/** A request to perform at venue sent to club */
	STATUS_REQUEST_SENT("Request sent"),
	/** Request pending, no real response yet */
	STATUS_PENDING("Pending"),
	/** Club wants you to perform */
	STATUS_APPROVED("Approved"),
	/** Club is not interested */
	STATUS_DENIED("Denied");
	
	private String status;
	
	private GigStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
}
