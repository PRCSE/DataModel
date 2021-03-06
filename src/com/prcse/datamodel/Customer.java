package com.prcse.datamodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 *Class used in the creation of a human bein....erm, customer... It holds information about a customer.
 */
public class Customer extends PersistantObject {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = 3339993911539002972L;
	private Account account;
	private ArrayList<Booking> bookings;
    private String title;
    private String forename;
    private String surname;
    private String telephone;
    private String mobile;
    private String addr1;
    private String addr2;
    private String town;
    private String county;
	private String postcode;
    private String country;
    private Date created;
    private String thumb;
    
    // ======== Class Constructors ===================================================== //
    
    public Customer()
    {
        super();
        this.title = null;
        this.forename = "";
        this.surname = "";
        this.telephone = "";
        this.mobile = "";
        this.addr1 = "";
        this.addr2 = "";
        this.town = "";
        this.county = "";
        this.postcode = "";
        this.country = "";
        this.thumb = "";
        this.created = null;
        bookings = new ArrayList<Booking>();
    }

    public Customer(String email, String password, String title, String forename, String surname, String telephone, String mobile, String addr1, String addr2, String town, String county, String postcode, String country, String thumb, Date created, boolean newAccount) 
    {
        this.account = new Account(email, password, newAccount);
        this.title = title;
    	this.forename = forename;
        this.surname = surname;
        this.telephone = telephone;
        this.mobile = mobile;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
        this.country = country;
        this.thumb = thumb;
        this.bookings = new ArrayList<Booking>();
        
        if(newAccount == true) {
        	this.created = new Date();
        }
        else {
        	this.created = created;
        }
    }
    
    // ======== Class Getters/Setters =================================================== //
    
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) 
    {
        this.bookings = bookings;
    }
    
    public void addBooking(Booking booking) {
    	this.bookings.add(booking);
    }
    
    public void removeBooking(Booking booking) {
    	this.bookings.remove(booking);
    }
    
    public Account getAccount() {
		return account;
	}

	public String getFullName()
    {
    	return title + " " + forename + " " + surname;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForename() 
    {
        return forename;
    }

    public void setForename(String forename) 
    {
        this.forename = forename;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public String getTelephone() 
    {
        return telephone;
    }

    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getMobile() 
    {
        return mobile;
    }

    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getAddr1() 
    {
        return addr1;
    }

    public void setAddr1(String addr1) 
    {
        this.addr1 = addr1;
    }

    public String getAddr2() 
    {
        return addr2;
    }

    public void setAddr2(String addr2) 
    {
        this.addr2 = addr2;
    }

    public String getTown() 
    {
        return town;
    }

    public void setTown(String town) 
    {
        this.town = town;
    }

    public String getCounty() 
    {
        return county;
    }

    public void setCounty(String county) 
    {
        this.county = county;
    }
    
    public Date getCreated() {
		return created;
	}
    
	public String createdAsString() {
    	// format date for oracle/mysql
    	if(created != null) {
    		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        	return fmt.format(created);
    	}
    	return null;
    }

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
    public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
    public String toString()
    {
    	return 		"\n id c-a: " + this.getId() + "-" + this.account.getId()
    			+	"\n username: " + this.account.getEmail()
    			+	"\n password: " + this.account.getToken()
    			+	"\n forename: " + this.getForename()
    			+	"\n surname: " 	+ this.getSurname()
    			+	"\n created: " + this.createdAsString();
    }
}
