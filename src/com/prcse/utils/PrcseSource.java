package com.prcse.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.prcse.protocol.CustomerBooking;
import com.prcse.protocol.CustomerForm;
import com.prcse.protocol.CustomerInfo;

public interface PrcseSource extends Connectable {

	public abstract ArrayList<Object> getFrontPage() throws Exception;
	
	public abstract CustomerInfo login(CustomerInfo request) throws Exception;

	public abstract CustomerInfo syncCustomer(CustomerInfo request) throws Exception;
	
	public abstract CustomerForm getCustomerFormData(CustomerForm request) throws Exception;
	
	public abstract CustomerBooking createBooking(CustomerBooking request) throws Exception;
	
	public abstract CustomerBooking cancelBooking(CustomerBooking request) throws Exception;

	public abstract ArrayList<HashMap> getEventSeatingMap(long eventId);
}

