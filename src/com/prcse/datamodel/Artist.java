package com.prcse.datamodel;

import java.util.ArrayList;
/*
 * Class which holds information about artists
 */
public class Artist extends PersistantObject {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = 1332872240262641119L;
	private ArrayList<String> genres;
	private ArrayList<Billing> billings;
	private ArrayList<Tour> tours;
	private String name;
	private String bio;
	private String thumb;
	
	// ======== Class Constructors ===================================================== //
	
	public Artist(long id, String name, String bio, String genres, String thumb) {
		super();
		this.id = id;
		this.genres = new ArrayList<String>();
		this.billings = new ArrayList<Billing>();
		this.tours = new ArrayList<Tour>();
		this.name = name;
		this.bio = bio;
		this.thumb = thumb;
		
		if(genres != null) {
			String[] splitGenres = genres.split(",");
			for(int i = 0; i < splitGenres.length; i++) {
				this.genres.add(splitGenres[i]);
			}
		}
	}
	
	// ======== Class Getters/Setters =================================================== //
	
	public ArrayList<String> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	public ArrayList<Billing> getBillings() {
		return billings;
	}

	public void setBillings(ArrayList<Billing> billings) {
		this.billings = billings;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String groupName) 
	{
		this.name = groupName;
	}
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
    public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
    public ArrayList<Tour> getTours() {
    	return this.tours;
    }
    
    public Tour getTourAt(int tourId) {
    	return this.tours.get(tourId);
    }

	// ======== Class Methods ====================================================== //
	
	public void addGenre(String genre)
    {
    	this.genres.add(genre);
    }
    
    public void removeGenre(String genre)
    {
    	this.genres.remove(genre);
    }
	
    public void addBilling(Billing billing) {
    	this.billings.add(billing);
    }
    
    public void removeBilling(Billing billing) {
    	this.billings.remove(billing);
    }
    
    public void addTour(Tour tour) {
    	this.tours.add(tour);
    }
    
    public void removeTour(Tour tour) {
    	this.tours.remove(tour);
    }

	@Override
	public String toString() {
		return "Artist [name=" + name + ", bio=" + bio + "]";
	}
}
