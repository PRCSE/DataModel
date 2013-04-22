package com.prcse.utils;

import com.prcse.protocol.AvailableSeats;
import com.prcse.protocol.CustomerBooking;
import com.prcse.protocol.CustomerForm;
import com.prcse.protocol.CustomerInfo;

// interface for client side connection protocols
public interface PrcseAsyncSource extends Connectable {

	public abstract void getFrontPage(ResponseHandler callback);
	
	public abstract void login(CustomerInfo request, ResponseHandler callback);

	public abstract void syncCustomer(CustomerInfo request, ResponseHandler callback);
	
	public void getCustomerFormData(CustomerForm request, ResponseHandler callback);
	
	public void createBooking(CustomerBooking request, ResponseHandler callback);
	
	public void cancelBooking(CustomerBooking request, ResponseHandler callback);
	
	public void getEventSeatingMap(long eventId, ResponseHandler callback);
	
	public void getEventAvailability(AvailableSeats request, ResponseHandler callback);
}