package com.prcse.datamodel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/*
 * Customer account which holds details for login
 */
public class Account extends PersistantObject {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -5538084349286532764L; // serialisation ID
	private ArrayList<Permission> permissions; // permissions list for customer account
	private String email; // customer email address
    private String token; // the 'password' sent to to the server for login authentication
    private String preferences; // TODO unimplemented feature variable
    
    // ======== Class Constructors ===================================================== //
    
    // Default constructor
    public Account()
    {
    	// Initialise to empty strings
        email = "";
        token = "";
    }
    
    // Custom constructor : email - customer email, password - password to be obfuscated, newAccount - flag for new accounts
    public Account(String email, String password, boolean newAccount)
    {
    	this.permissions = new ArrayList<Permission>();
        this.email = email;
        
        // If creating new account then salt and hash else copy from source
        if(newAccount == true) {
        	this.token = salt(password, email);
            this.token = hash(this.token);
        }
        else {
        	// Would most likely be set like this from database source
        	this.token = password;
        }
    }
    
    // ======== Class Getters/Setters =================================================== //
    
    public String getEmail() 
    {
        return email;
    }

    public String getToken() 
    {
        return token;
    }

    public void setEmail(String email, String password) 
    {
    	// If changing the email then the password must be salted and hashed again
        this.email = email;
        this.setToken(password);
    }

    public void setToken(String password) 
    {
        // When setting the password it will always be salted and hashed against the email
    	this.token = salt(password, this.email);
        this.token = hash(this.token);
    }
    
    public ArrayList<Permission> getPermission() {
		return permissions;
	}

	public void setPermission(ArrayList<Permission> permission) {
		this.permissions = permission;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	} 
	
	// ======== Class Methods ====================================================== //
    
	// Method to produce a salted string from email and password
    private static String salt(String message, String salt)
    {
    	// salted message placeholder
    	String saltedMessage = null;
    	
    	// email or password are null then break
    	if (message == null || salt == null)
    	{
    		// return... something... or is it nothing?
    		return null;
    	}
    	
    	// remove whitespace
    	salt.replaceAll("\\s", "");
    	// remove non-word characters (e.g. punctuation)
    	salt.replaceAll("\\W", "");
    	
    	// salt the message
    	saltedMessage = message + salt;
    	
    	return saltedMessage;
    }
    
    // Takes a salted string and hashes it using MD5
    private static String hash(String message)
    {
    	// hash placeholder
    	String hashedMessage = null;
    	
    	// break if the salted string is null
    	if (message == null)
    	{
    		return null;
    	}
    	
    	// Perform hash functions
    	try
    	{
    		MessageDigest digest = MessageDigest.getInstance("MD5");
    		
    		digest.update(message.getBytes(), 0, message.length());
    		
    		hashedMessage = new BigInteger(1, digest.digest()).toString(16);
    	}
    	catch(NoSuchAlgorithmException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return hashedMessage;
    }
    
    // Formatted add to permissions arraylist variable
    public void addPermission(Permission permission)
    {
    	// if you add a permission you have to remove it from the permissions list
    	permission.addAccount(this);
    	this.permissions.add(permission);
    }
    
    // Formatted add to permissions arraylist
    public void removePermission(Permission permission)
    {
    	// if you remove a permission you have to remove it from the permissions list
    	permission.removeAccount(this);
    	this.permissions.remove(permission);
    }

	@Override
	public String toString() {
		return 		"\n id: " + this.getId()
    			+	"\n username: " + this.getEmail()
    			+	"\n password: " + this.getToken();
	}
}
