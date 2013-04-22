package com.prcse.utils;

import com.prcse.protocol.AvailableSeats;
import com.prcse.protocol.CustomerBooking;
import com.prcse.protocol.CustomerForm;
import com.prcse.protocol.CustomerInfo;
import com.prcse.protocol.FrontPage;
import com.prcse.protocol.Request;

public class PrcseConnection extends AsyncSource implements PrcseAsyncSource {
    
    public PrcseConnection(String host, int port) {
		super(host, port);
	}
	
	@Override
	public void getFrontPage(ResponseHandler callback) {
		Request request = new FrontPage();
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}

	@Override
	public void login(CustomerInfo request, ResponseHandler callback) {
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}

	@Override
	public void syncCustomer(CustomerInfo request, ResponseHandler callback) {
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}

	@Override
	public void getCustomerFormData(CustomerForm request, ResponseHandler callback) {
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}

	@Override
	public void createBooking(CustomerBooking request, ResponseHandler callback) {
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}

	@Override
	public void cancelBooking(CustomerBooking request, ResponseHandler callback) {
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}

	@Override
	public void getEventSeatingMap(long eventId, ResponseHandler callback) {
		// TODO will implement the seating plan visual grid from database
	}

	@Override
	public void getEventAvailability(AvailableSeats request, ResponseHandler callback) {
		request.setRequestId(this.nextRequestId());
		this.requestCallbacks.put(new Integer(request.getRequestId()), callback);
		addToOutput(request);
	}
}
