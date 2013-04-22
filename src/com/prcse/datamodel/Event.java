package com.prcse.datamodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * Class used for creating events and holds information about events
 */
public class Event extends PersistantObject {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -406642166220542302L;
	private ArrayList<Billing> billings;
	private String name;
	private String tourName;
	private Date startTime;
	private Date endTime;
	private SeatingPlan seatingPlan;
	
	
	// ======== Class Constructor ====================================================== //
	
	public Event(long id, String name, Date startTime, Date endTime)
	{
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.billings = new ArrayList<Billing>();
		this.seatingPlan = null;
	}

	
	// ======== Class Getters/Setters =================================================== //
	
	public ArrayList<Billing> getBillings() 
	{
		return billings;
	}

	public void setBillings(ArrayList<Billing> billings) 
	{
		this.billings = billings;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Date getStartTime() 
	{
		return startTime;
	}

	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}

	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}
	
	public String getDayToString()
	{
		try
		{
			SimpleDateFormat formatDay = new SimpleDateFormat("dd", Locale.ENGLISH);
			return formatDay.format(startTime);
		}
		catch (Exception e)
		{
			return "00";
		}
		
	}
	
	public String getMonthToString()
	{
		try
		{
			SimpleDateFormat formatMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
			return formatMonth.format(startTime);
		}
		catch (Exception e)
		{
			return "unavalible";
		}
	}
	
	public String getYearToString()
	{
		try
		{
			SimpleDateFormat formatYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);
			return formatYear.format(startTime);
		}
		catch (Exception e)
		{
			return "0000";
		}
	}
	
	public String getDateToString()
	{
		try
		{
			SimpleDateFormat formatYear = new SimpleDateFormat("EEEEEE, MMMM dd, yyyy", Locale.ENGLISH);
			return formatYear.format(startTime);
		}
		catch (Exception e)
		{
			return "unavalible";
		}
	}

	public SeatingPlan getSeatingPlan() {
		return seatingPlan;
	}

	public void setSeatingPlan(SeatingPlan seatingPlan) {
		this.seatingPlan = seatingPlan;
	}
	
    public void addBilling(Billing billing) {
    	this.billings.add(billing);
    }
    
    public void removeBilling(Billing billing) {
    	this.billings.remove(billing);
    }

	@Override
	public String toString() {
		return "Event [name=" + name + ", startTime=" + startTime + "]";
	}
	
	public void setTourName(String name) {
		this.tourName = name;
	}
	
	public String getTourName() {
		if(tourName == null) {
			return this.tourName;
		}
		else {
			return "";
		}
	}
}
