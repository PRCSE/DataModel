package com.prcse.protocol;

import java.util.ArrayList;

import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class CustomerForm extends BaseRequest {
	
	ArrayList<String> titles;
	ArrayList<String> countries;

	public CustomerForm() {
		super();
		
		this.titles = new ArrayList<String>();
		this.countries = new ArrayList<String>();
	}
	
	public CustomerForm(ArrayList<String> title, ArrayList<String> country) {
		super();
		
		this.titles = title;
		this.countries = country;
	}

	public ArrayList<String> getTitles() {
		return titles;
	}

	public ArrayList<String> getCountries() {
		return countries;
	}

	@Override
	public void handleRequest(Connectable dataSource) {
		if(this.titles.size() < 1 || this.countries.size() < 1){
			// get data from db
			try {
				CustomerForm data = ((PrcseSource)dataSource).getCustomerFormData(this);
				
				if(data.getTitles().size() > 1 && data.getCountries().size() > 1) {
					titles = data.getTitles();
					countries = data.getCountries();
				}
				else {
					this.setError(data.getError());
				}
				
			} catch (Exception e) {
				this.error = e.getMessage();
			}
		}
		else {
			this.setError("Already Retrieved Customer Form Data");
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
		return false;
	}

	@Override
	public String toString() {
		return "CustomerForm [title=" + titles + "\ncountry=" + countries + "]";
	}

}
