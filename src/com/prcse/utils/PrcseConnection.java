package com.prcse.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import com.prcse.datamodel.Artist;
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
}
