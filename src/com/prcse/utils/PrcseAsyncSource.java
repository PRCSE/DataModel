package com.prcse.utils;

import com.prcse.protocol.CustomerForm;
import com.prcse.protocol.CustomerInfo;

public interface PrcseAsyncSource extends Connectable {

	public abstract void getFrontPage(ResponseHandler callback);
	
	public abstract void login(CustomerInfo request, ResponseHandler callback);

	public abstract void syncCustomer(CustomerInfo request, ResponseHandler callback);
	
	public void getCustomerFormData(CustomerForm request, ResponseHandler callback);
}