package com.prcse.datamodel;

import java.util.ArrayList;


/*
 * Class used in the creation/and/or/editing of a venue like object
 */
public class Venue extends PersistantObject {
	
	
	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = 7718540087157370890L;
	private ArrayList<SeatingPlan> seatingPlan;
	private String name;
	private double geoLat;
	private double geoLong;
	private String thumb;
	private String postcode;
	private String description;

	
	// ======== Class Constructors ===================================================== //
	
	public Venue(long id, String name)
	{
		this.seatingPlan = new ArrayList<SeatingPlan>();
		this.name = name;
		this.id = id;
		this.geoLat = 0;
		this.geoLong = 0;
	}
	
	public Venue(String name, double geoLat, double geoLong)
	{
		this.seatingPlan = new ArrayList<SeatingPlan>();
		this.name = name;
		this.geoLat = geoLat;
		this.geoLong = geoLong;
	}
	
	public Venue(long id, String name, String thumb, String postcode, String description) {
		super();
		this.id = id;
		this.name = name;
		this.thumb = thumb;
		this.postcode = postcode;
		this.description = description;
	}

	
	// ======== Class Getters/Setters =================================================== //
	
	public void addSeatingPlan(SeatingPlan seatingPlan)
	{
		this.seatingPlan.add(seatingPlan);
	}
	
	public void removeSeatingPlan(SeatingPlan seatingPlan)
	{
		this.seatingPlan.remove(seatingPlan);
	}

	public ArrayList<SeatingPlan> getSeatingPlan() 
	{
		return seatingPlan;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getGeoLat() 
	{
		return geoLat;
	}

	public void setGeoLat(double geoLat) 
	{
		this.geoLat = geoLat;
	}

	public double getGeoLong() 
	{
		return geoLong;
	}

	public void setGeoLong(double geoLong) 
	{
		this.geoLong = geoLong;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Venue [name=" + name + ", geoLat=" + geoLat + ", geoLong="
				+ geoLong + ", postcode=" + postcode + "]";
	}
}