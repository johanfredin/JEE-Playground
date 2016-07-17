package com.pylonmusic.gigmanager.domain.entitiy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.pylonmusic.gigmanager.domain.IdHolder;
import com.pylonmusic.gigmanager.domain.entitiy.enumerations.GigStatus;

/**
 * Domain object representing all the need to knows about an upcoming gig for your band
 * @author johan
 *
 */
@Entity
@Table(name = "GIG")
public class Gig implements IdHolder {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5053759475593685383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GIG_ID")
	private long id;
	
	@Column(name="REVENUE")
	private int revenue;
	
	@Column(name="BACKLINE")
	private boolean isBackline;
	
	@Column(name="TRAVEL_COMPENSATION")
	private boolean isTravelCompensation;
	
	@Column(name="FOOD_INCLUDED")
	private boolean isFoodIncluded;
	
	@Column(name="FREE_BEVERAGES")
	private boolean isFreeBeverages;
	
	@Column(name="BACKSTAGE")
	private boolean isBackStage;
	
	@Column(name="NO_ALCOHOL")
	private boolean isNoAlcohol;
	
	@NotNull
	@OneToOne(cascade=CascadeType.PERSIST)
	@Type(type = "com.pylonmusic.gigmanager.domain.entity.Venue")
	private Venue venue;
	
	@NotNull
	private GigStatus status;
	
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="DATE")
	private DateTime date;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="TIME_FOR_SHOW")
	private DateTime timeForShow;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="TIME_FOR_SOUNDCHECK")
	private DateTime timeForSoundcheck;
	
	@Column(name="SIDENOTES")
	private String sideNotes;

	/**
	 * Create a new empty instance of {@link Gig}
	 */
	public Gig() {}
	
	/**
	 * Create a new instance of {@link Gig}
	 * @param id the identifier of this {@link Gig}
	 * @param venue the {@link Venue} of the {@link Gig}
	 */
	public Gig(long id, Venue venue) {
		this(id, 0, false, false, false, false, false, venue, GigStatus.STATUS_DISCOVERED, null, null, null, "");
	}
	
	/**
	/**
	 * Create a new instance of a {@link Gig}
	 * @param id the identifier of this {@link Gig}
	 * @param venue the {@link Venue} of the {@link Gig}
	 * @param date the {@link DateTime} for this {@link Gig}
	 */
	public Gig(long id, Venue venue, DateTime date) {
		this(id, 0, false, false, false, false, false, venue, GigStatus.STATUS_DISCOVERED, date, null, null, "");
	}
	
	/**
	 * @param id the identifier of this {@link Gig}
	 * @param revenue the amount of money payed by {@link Venue} owner
	 * @param isBackline whether or not backline is available
	 * @param isTravelCompensation whether or not travel cost is compensated
	 * @param isFoodIncluded whether or not food is included
	 * @param isFreeBeverages whether or not beers are free
	 * @param isBackStage whether or not there is a backstage
	 * @param venue the {@link Venue} of this {@link Gig}
	 * @param date the {@link DateTime} of the {@link Gig}
	 * @param timeForShow the {@link DateTime} when its time to play
	 * @param timeForSoundcheck the {@link DateTime} for soundcheck
	 * @param sideNotes internal sideNotes
	 */
	public Gig(long id, int revenue, boolean hasBackline, boolean isTravelCompensation, boolean isFoodIncluded, boolean isFreeBeers, 
			boolean isBackStage, Venue venue, GigStatus status, DateTime date, DateTime timeForShow, DateTime timeForSoundcheck, String notes) {
		setId(id);
		setRevenue(revenue);
		setBackline(hasBackline);
		setTravelCompensation(isTravelCompensation);
		setFoodIncluded(isFoodIncluded);
		setFreeBeverages(isFreeBeers);
		setBackline(hasBackline);
		setBackStage(isBackStage);
		setVenue(venue);
		setStatus(status);
		setDate(date);
		setTimeForShow(timeForShow);
		setTimeForSoundcheck(timeForSoundcheck);
		setSideNotes(notes);
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	/**
	 * @return the amount of money payed by {@link Venue} owner
	 */
	public int getRevenue() {
		return revenue;
	}

	/**
	 * Set the amount of money payed by {@link Venue} owner
	 * @param revenue the amount of money payed by {@link Venue} owner
	 */
	public void setRevenue (int revenue) {
		this.revenue = revenue;
	}
	
	/**
	 * @return whether or not backline is available
	 */
	public boolean isBackline() {
		return isBackline;
	}
	
	/**
	 * Set the current {@link GigStatus} of this {@link Gig}
	 * @param status
	 */
	public void setStatus(GigStatus status) {
		this.status = status;
	}
	
	/**
	 * @return the current {@link GigStatus} of this {@link Gig}
	 */
	public GigStatus getStatus() {
		return status;
	}

	/**
	 * Set whether or not backline is available
	 * @param isBackline whether or not backline is available
	 */
	public void setBackline(boolean hasBackline) {
		this.isBackline = hasBackline;
	}
	
	/**
	 * @return whether or not travel cost is compensated
	 */
	public boolean isTravelCompensation() {
		return isTravelCompensation;
	}
	
	/**
	 * Set whether or not travel cost is compensated
	 * @param isTravelCompensation whether or not travel cost is compensated
	 */
	public void setTravelCompensation(boolean isTravelCompensation) {
		this.isTravelCompensation = isTravelCompensation;
	}
	
	/**
	 * @return whether or not food is included
	 */
	public boolean isFoodIncluded() {
		return isFoodIncluded;
	}
	
	/**
	 * Set whether or not food is included
	 * @param isFoodIncluded whether or not food is included
	 */
	public void setFoodIncluded(boolean isFoodIncluded) {
		this.isFoodIncluded = isFoodIncluded;
	}
	
	/**
	 * @return whether or not beers are free
	 */
	public boolean isFreeBeverages() {
		return isFreeBeverages;
	}

	/**
	 * Set whether or not beers are free
	 * If the {@link #isNoAlcohol()} is set to <code>true</code> this will be set fo <code>false</code>
	 * @param isFreeBeverages whether or not beers are free
	 */
	public void setFreeBeverages(boolean isFreeBeers) {
		this.isFreeBeverages = isNoAlcohol() ? false : isFreeBeers;
	}
	
	/**
	 * @return whether or not there is a backstage
	 */
	public boolean isBackStage() {
		return isBackStage;
	}

	/**
	 * whether or not there is a backstage
	 * @param isBackStage whether or not there is a backstage
	 */
	public void setBackStage(boolean isBackStage) {
		this.isBackStage = isBackStage;
	}
	
	/**
	 * Set whether or not you are allowed to drink alcohol at {@link Venue}
	 * @param isNoAlcohol
	 */
	public void setNoAlcohol(boolean isNoAlcohol) {
		this.isNoAlcohol = isNoAlcohol;
	}
	
	/**
	 * @return <code>true</code> if {@link Venue} does not allow you to drink alcohol
	 */
	public boolean isNoAlcohol() {
		return isNoAlcohol;
	}
	
	/**
	 * @return the {@link Venue} of this {@link Gig}
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * @param venue the {@link Venue} of this {@link Gig}
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	/**
	 * @return the {@link DateTime} of the {@link Gig}
	 */
	public DateTime getDate() {
		return date;
	}

	/**
	 * Set the {@link DateTime} of the {@link Gig}
	 * @param date the {@link DateTime} of the {@link Gig}
	 */
	public void setDate(DateTime date) {
		this.date = date;
	}
	
	/**
	 * @return the {@link DateTime} when its time to play
	 */
	public DateTime getTimeForShow() {
		return timeForShow;
	}
	
	/**
	 * Set the {@link DateTime} when its time to play
	 * @param timeForShow the {@link DateTime} when its time to play
	 */
	public void setTimeForShow(DateTime timeForShow) {
		this.timeForShow = timeForShow;
	}
	
	/**
	 * @return the {@link DateTime} for soundcheck
	 */
	public DateTime getTimeForSoundcheck() {
		return timeForSoundcheck;
	}
	
	/**
	 * Set the {@link DateTime} for soundcheck
	 * @param timeForSoundcheck the {@link DateTime} for soundcheck
	 */
	public void setTimeForSoundcheck(DateTime timeForSoundcheck) {
		this.timeForSoundcheck = timeForSoundcheck;
	}
	
	/**
	 * @return internal sideNotes
	 */
	public String getSideNotes() {
		return sideNotes;
	}
	
	/**
	 * internal sideNotes
	 * @param sideNotes internal sideNotes
	 */
	public void setSideNotes(String notes) {
		this.sideNotes = notes;
	}
	
	@Override
	public String toString() {
		char newLine = '\n';
		StringBuilder sb = new StringBuilder();
		sb.append("GIG").append(newLine).
			append("===").append(newLine).
			append("Gig Id").append(this.id).append(newLine).
			append("Revenue=").append(this.revenue).append(newLine).
			append("Has backline?=").append(this.isBackline).append(newLine).
			append("Is travel compensated?=").append(this.isTravelCompensation).append(newLine).
			append("Is food included?=").append(this.isFoodIncluded).append(newLine).
			append("Is backstage available?=").append(this.isBackStage).append(newLine);
			if(date != null) {
				sb.append("Date=").append(this.date.toString()).append(newLine);
			} if(timeForShow != null) {
				sb.append("Time for show=").append(this.timeForShow.toString()).append(newLine);
			} if(timeForSoundcheck != null) {
				sb.append("Time for soundcheck=").append(this.timeForSoundcheck.toString()).append(newLine);
			} if(sideNotes != null) {
				sb.append("Side notes=").append(this.sideNotes);
			} if(venue != null) {
				sb.append("Venue=").append(this.venue.toString()).append(newLine);
			}
			return sb.toString();
	}

	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		Gig populatedGig = (Gig) populatedEntity;
		setId(populatedGig.getId());
		setBackline(populatedGig.isBackline());
		setBackStage(populatedGig.isBackStage());
		setDate(populatedGig.getDate());
		setFoodIncluded(populatedGig.isFoodIncluded());
		setFreeBeverages(populatedGig.isFreeBeverages());
		setNoAlcohol(populatedGig.isNoAlcohol());
		setRevenue(populatedGig.getRevenue());
		setSideNotes(populatedGig.getSideNotes());
		setStatus(populatedGig.getStatus());
		setTimeForShow(populatedGig.getTimeForShow());
		setTimeForSoundcheck(populatedGig.getTimeForSoundcheck());
		setTravelCompensation(populatedGig.isTravelCompensation());
		setVenue(populatedGig.getVenue());
	}

}
