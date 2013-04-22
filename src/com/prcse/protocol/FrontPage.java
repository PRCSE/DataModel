package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class FrontPage extends BaseRequest {

	// ======== Class Variables ======================================================== //

	private static final long serialVersionUID = 8594059088498807133L;
	private ArrayList<Object> artists = null;
	private ArrayList<Object> events = null;
	private boolean shouldBroadcast;
	
	// ======== Class Constructor ====================================================== //
	
	// this constructor is used by the client to request front page data
	public FrontPage() {
		super();
		this.shouldBroadcast = false;
	}
	
	// use this constructor to broadcast new events and artist to clients (not used)
	public FrontPage(ArrayList<Object> artists, ArrayList<Object> events) {
		super();
		this.artists = artists;
		this.events = events;
		this.shouldBroadcast = true;
	}
	
	// ======== Class Getters/Setters =================================================== //
	
	public ArrayList<Object> getArtists() {
		return artists;
	}

	public ArrayList<Object> getEvents() {
		return events;
	}
	
	// ======== Implemented Methods ===================================================== //
	
	public void handleRequest(Connectable dataSource) {
		// get top level data for application
		// includes all artists, events, venues and tours
		try {
			this.artists = ((PrcseSource)dataSource).getFrontPage();
		} catch (Exception e) {
			this.error = e.getMessage();
		}
	}

	public Object getResult() {
		return null;
	}

	public boolean shouldBroadcast() {
		return this.shouldBroadcast;
	}
	
	public void setShouldBroadcast(boolean value) {
		this.shouldBroadcast = value;
	}

	@Override
	public boolean shouldSync() {
		return false;
	}
}
