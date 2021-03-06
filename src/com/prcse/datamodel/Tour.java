package com.prcse.datamodel;

import java.util.ArrayList;

/*
 *Class used when creating/managing tours information
 */
public class Tour extends PersistantObject {

	
	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -3305178071548108866L;
	private ArrayList<Billing> bills;
	private String name;
	private Artist artist;
	private String thumb;
	
	
	// ======== Class Constructors ===================================================== //
	
	public Tour(long id, String name, Artist artist)
	{
		bills = new ArrayList<Billing>();
		this.id = id;
		this.name = name;
		this.artist = artist;
	}
	
	public Tour(String name)
	{
		this.name = name;
	}
	
	
	// ======== Class Getters/Setters =================================================== //
	
	public void addBill(Billing bill)
	{
		this.bills.add(bill);
	}
	
	public void removeBillAt(int index)
	{
		this.bills.remove(index);
	}
	
	public void removeBill(Billing bill)
	{
		this.bills.remove(bill);
	}
	
	public ArrayList<Billing> getBills() 
	{
		return bills;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public Artist getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return "Tour [name=" + name + ", artist=" + artist + "]";
	}
}
