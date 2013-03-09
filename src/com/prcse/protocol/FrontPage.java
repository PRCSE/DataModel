package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class FrontPage extends BaseRequest {
	
	private ArrayList artists = null;
	private ArrayList events = null;
	private boolean shouldBroadcast;
	
	// this constructor is used by the client to request front page data
	public FrontPage() {
		super();
		this.shouldBroadcast = false;
	}
	
	// use this constructor to broadcast new events and artist to clients
	public FrontPage(ArrayList artists, ArrayList events) {
		super();
		this.artists = artists;
		this.events = events;
		this.shouldBroadcast = true;
	}

	public void handleRequest(Connectable dataSource) {
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

	public ArrayList getArtists() {
		return artists;
	}

	public ArrayList getEvents() {
		return events;
	}
}
