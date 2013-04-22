package com.prcse.protocol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.prcse.datamodel.Booking;
import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class CustomerBooking extends BaseRequest {
	
	private long customerId;
	private ArrayList<Long> seatIds;
	private Booking booking;
	
	public CustomerBooking() {
		super();
	}
	
	public CustomerBooking(Booking booking, long customerId, ArrayList<Long> seats) {
		super();
		this.booking = booking;
		this.customerId = customerId;
		
		if(seats != null) {
			seatIds = seats;
		}
		else {
			seatIds = new ArrayList<Long>();
		}
	}

	@Override
	public void handleRequest(Connectable dataSource) {
		// TODO Auto-generated method stub
		if(this.booking == null) {
			// create booking
			try {
				((PrcseSource)dataSource).createBooking(this);
			} catch (Exception e) {
				this.error = e.getMessage();
			}
		}
		else if(this.booking.getCancelled() != null) {
			// sync booking
			try {
				((PrcseSource)dataSource).cancelBooking(this);
			} catch (Exception e) {
				this.error = e.getMessage();
			}
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
		return true;
	}

	@Override
	public boolean shouldSync() {
		// TODO Auto-generated method stub
		return false;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public ArrayList<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(ArrayList<Long> seatIds) {
		this.seatIds = seatIds;
	}
	
	public String getCreatedAsString() {
		// format date for oracle/mysql
		Date created = this.booking.getCreated();
		
    	if(created != null) {
    		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        	return fmt.format(created);
    	}
    	return null;
	}
	
	public String getCancelledAsString() {
		// format date for oracle/mysql
		Date cancelled = this.booking.getCancelled();
		
    	if(cancelled != null) {
    		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        	return fmt.format(cancelled);
    	}
    	return null;
	}
}
