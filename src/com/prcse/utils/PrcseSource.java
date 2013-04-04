package com.prcse.utils;

import java.util.ArrayList;

import com.prcse.protocol.CustomerInfo;

public interface PrcseSource extends Connectable {

	public abstract ArrayList<Object> getFrontPage() throws Exception;
	
	public abstract CustomerInfo login(CustomerInfo request) throws Exception;

	public abstract CustomerInfo syncCustomer(CustomerInfo request) throws Exception;
	
	public abstract CustomerInfo registerCustomer(CustomerInfo request) throws Exception;
}
