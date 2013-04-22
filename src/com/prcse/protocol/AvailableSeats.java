package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.datamodel.Event;
import com.prcse.datamodel.SeatingArea;
import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

// Protocol Request Object for Getting the available seats and seating areas of a given Event
public class AvailableSeats extends BaseRequest {
	
	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -6798967118773547900L;
	ArrayList<SeatingArea> availableSeats;
	Event event;
	int total;
	
	// ======== Class Constructor ====================================================== //

	public AvailableSeats(Event event) {
		availableSeats = new ArrayList<SeatingArea>();
		this.event = event;
	}

	// ======== Class Getters/Setters =================================================== //
	
	public ArrayList<SeatingArea> getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(ArrayList<SeatingArea> availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public void addSeat(SeatingArea area) {
		this.availableSeats.add(area);
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	// ======== Implemented Methods ===================================================== //
	
	@Override
	public Object getResult() {
		return null;
	}
	
	// This method will take call the method on the datasource to get the database data
	@Override
	public void handleRequest(Connectable dataSource) {
		if(this.event != null){
			// get seats for given event
			try {
				((PrcseSource)dataSource).getEventAvailability(this);
			} catch (Exception e) {
				this.error = e.getMessage();
			}
		}
		else {
			// if no event was given then set error
			this.setError("No event chosen.");
		}
	}

	@Override
	public boolean shouldBroadcast() {
		return false;
	}

	@Override
	public boolean shouldSync() {
		return false;
	}
}
