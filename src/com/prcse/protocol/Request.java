package com.prcse.protocol;

import com.prcse.utils.Connectable;

// Interface for generic request objects 
// A request object must implement all of these to be interpreted by the server
public interface Request {
	
	// called to execute protocol specific code
	public void handleRequest(Connectable dataSource);
	
	// used to return protocol results (not really used)
	public Object getResult();
	
	// used to store possible errors for client benefit
	public String getError();
	
	// used to check if a request should be pushed to all users
	public boolean shouldBroadcast();
	
	// used to check if a request should be pushed to only the user that sent it
	public boolean shouldSync();
	
	// request parameter getters and setters
	public void setRequestId(int value);
	public int getRequestId();
	public void setClientId(int value);
	public int getClientId();
}
