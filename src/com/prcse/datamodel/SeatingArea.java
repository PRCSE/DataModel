package com.prcse.datamodel;

import java.util.ArrayList;


public class SeatingArea extends PersistantObject {

	private static final long serialVersionUID = 1617913797946293969L;
	private ArrayList<Booking> booked;
	private String name;
	private int capacity;
	private long parent;
	private long plan;
	
	public SeatingArea(String name, int capacity, long parent, long plan)
	{
		this.booked = new ArrayList<Booking>();
		this.name = name;
		this.capacity = capacity;
		this.parent = parent;
		this.plan = plan;
	}
	
	public void addBooking(Booking booked)
	{
		this.booked.add(booked);
	}
	
	public void removeBooking(Booking booked)
	{
		this.booked.remove(booked);
	}

	public ArrayList<Booking> getBooked() {
		return booked;
	}

	public void setBooked(ArrayList<Booking> booked) {
		this.booked = booked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}

	public long getPlan() {
		return plan;
	}

	public void setPlan(long plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "SeatingArea [name=" + name + ", capacity=" + capacity
				+ ", plan=" + plan + "]";
	}
}
