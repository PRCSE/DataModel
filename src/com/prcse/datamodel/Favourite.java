package com.prcse.datamodel;

/*
 * Class used for creating favourites for customers such as artist, venue, stuff. Holds favourite info. Get it?
 */
public class Favourite extends PersistantObject {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -5958147671107102663L;
	private Long customerId;
	private Long artistId;
	private Long venueId;
	private Long genreId;
	private Long eventId;
	
	
	// ======== Class Constructors ===================================================== //
	
	// default constructor
	public Favourite() {
		super();
	}
	
	public Favourite(Long customerId, Long artistId, Long venueId, Long genreId, Long eventId) {
		super();
		this.customerId = customerId;
		this.artistId = artistId;
		this.venueId = venueId;
		this.genreId = genreId;
		this.eventId = eventId;
	}
	
	public Favourite(Long id, Long customerId, Long artistId, Long venueId, Long genreId, Long eventId) {
		super();
		this.customerId = customerId;
		this.artistId = artistId;
		this.venueId = venueId;
		this.genreId = genreId;
		this.eventId = eventId;
		
		this.setId(id);
	}
	
	
	// ======== Class Getters/Setters =================================================== //
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	public Long getVenueId() {
		return venueId;
	}
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}
	public Long getGenreId() {
		return genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Favourite [customerId=" + customerId + ", artistId=" + artistId
				+ ", venueId=" + venueId + ", genreId=" + genreId
				+ ", eventId=" + eventId + "]";
	}
}
