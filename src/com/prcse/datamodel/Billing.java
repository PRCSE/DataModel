package com.prcse.datamodel;

/*
 * TODO for Dash: write class description. I, Vlad, have not the slightest idea what this does and I think my brain is dead from over 12 hours of coding
 */
public class Billing extends PersistantObject {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -1888341062108193175L;
	private Artist artist;
	private Event event;
	int lineupOrder;
	
	// ======== Class Constructors ===================================================== //
	
	public Billing(long id, Artist artist, Event event, int lineupOrder)
	{
		this.id = id;
		this.artist = artist;
		this.event = event;
		this.lineupOrder = lineupOrder;
	}
	
	// ======== Class Getters/Setters =================================================== //

	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}


	public int getLineupOrder() {
		return lineupOrder;
	}

	public void setLineupOrder(int lineupOrder) {
		this.lineupOrder = lineupOrder;
	}


	@Override
	public String toString() {
		return "Billing [artist=" + artist + ", event=" + event + "]";
	}
	
}
