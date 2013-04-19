package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.datamodel.Account;
import com.prcse.datamodel.Customer;
import com.prcse.datamodel.Favourite;
import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class CustomerInfo extends BaseRequest {
	
	private Customer customer;
	private ArrayList<Favourite> favourites;
	private String email;
	private String password;
	// variable not exposed to client
	private transient boolean admin;
	private boolean verified;
	
	public CustomerInfo() {
		super();
	}
	
	public CustomerInfo(String email, String password) {
		super();
		
		// used to access salt and hash functions
		Account tempAccount = new Account(email, password, true);
		
		this.email = tempAccount.getEmail();
		this.password = tempAccount.getToken();
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

	public ArrayList<Favourite> getFavourites() {
		return favourites;
	}

	public void setFavourites(ArrayList<Favourite> favourites) {
		this.favourites = favourites;
	}
	
	public void addFavourite(Long id, Long customerId, Long artistId, Long venueId, Long genreId, Long eventId) {
		
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
