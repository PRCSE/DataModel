package com.prcse.protocol;

import java.util.Date;

import com.prcse.utils.Connectable;

public class CustomerBooking extends BaseRequest {
	
	private int customerId;
	private int eventId;
	private int quantity;
	private Date created;
	private CustomerBooking booking;
	
	public CustomerBooking() {
		super();
	}
	
	public CustomerBooking(int customerId, int eventId, int quantity) {
		super();
		this.customerId = customerId;
		this.eventId = eventId;
		this.quantity = quantity;
	}

	@Override
	public void handleRequest(Connectable dataSource) {
		// TODO Auto-generated method stub
		if(this.booking == null) {
			// create booking
		}
		else {
			// set booking information by id
		}
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldBroadcast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSync() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public CustomerBooking getBooking() {
		return booking;
	}

	public void setBooking(CustomerBooking booking) {
		this.booking = booking;
	}

}
