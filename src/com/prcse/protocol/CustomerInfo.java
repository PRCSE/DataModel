package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.datamodel.Customer;
import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class CustomerInfo extends BaseRequest {
	
	private Customer customer;
	private ArrayList favourites;
	private String email;
	private String password;
	private boolean verified;
	
	public CustomerInfo() {
		super();
	}
	
	public CustomerInfo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	@Override
	public void handleRequest(Connectable dataSource) {
		if(this.customer == null){
			// login
			try {
				((PrcseSource)dataSource).login(this);
			} catch (Exception e) {
				this.error = e.getMessage();
			}
		}
		else {
			//sync customer data
			try {
				((PrcseSource)dataSource).syncCustomer(this);
			} catch (Exception e) {
				this.error = e.getMessage();
			}
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
		return true;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList getFavourites() {
		return favourites;
	}

	public void setFavourites(ArrayList favourites) {
		this.favourites = favourites;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
}
