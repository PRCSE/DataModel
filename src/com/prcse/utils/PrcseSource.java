package com.prcse.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.prcse.datamodel.SeatingArea;
import com.prcse.protocol.AvailableSeats;
import com.prcse.protocol.CustomerBooking;
import com.prcse.protocol.CustomerForm;
import com.prcse.protocol.CustomerInfo;

// interface for database side connection protocols
public interface PrcseSource extends Connectable {

	public abstract ArrayList<Object> getFrontPage() throws Exception;
	
	public abstract CustomerInfo login(CustomerInfo request) throws Exception;

	public abstract CustomerInfo syncCustomer(CustomerInfo request) throws Exception;
	
	public abstract CustomerForm getCustomerFormData(CustomerForm request) throws Exception;
	
	public abstract CustomerBooking createBooking(CustomerBooking request) throws Exception;
	
	public abstract CustomerBooking cancelBooking(CustomerBooking request) throws Exception;

	public abstract ArrayList<HashMap<Long, SeatingArea>> getEventSeatingMap(long eventId) throws Exception;

	public abstract AvailableSeats getEventAvailability(AvailableSeats request) throws Exception;
}

