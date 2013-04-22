package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.datamodel.Event;
import com.prcse.datamodel.SeatingArea;
import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class AvailableSeats extends BaseRequest {
	ArrayList<SeatingArea> availableSeats;
	Event event;
	int total;

	public AvailableSeats(Event event) {
		availableSeats = new ArrayList<SeatingArea>();
		this.event = event;
	}

	@Override
	public void handleRequest(Connectable dataSource) {
		if(this.event != null){
			// get seats for event
			try {
				((PrcseSource)dataSource).getEventAvailability(this);
			} catch (Exception e) {
				this.error = e.getMessage();
			}
		}
		else {
			this.setError("No event chosen.");
		}
	}

	@Override
	public Object getResult() {
		return null;
	}

	@Override
	public boolean shouldBroadcast() {
		return false;
	}

	@Override
	public boolean shouldSync() {
		return false;
	}

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

}
