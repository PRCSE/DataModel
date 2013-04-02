package com.prcse.datamodel;

import java.util.ArrayList;



public class Venue extends PersistantObject {
	
	ArrayList<SeatingPlan> seatingPlan;
	String name;
	double geoLat;
	double geoLong;
	//TODO add image string data members
	//TODO add postcode data member with getters and setters

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
}