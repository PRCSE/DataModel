package com.prcse.protocol;

import java.io.Serializable;

// Base Protocol Request Object for Getting data from the database using the server 'middleware'
public abstract class BaseRequest implements Request, Serializable {

	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -6122870344042451380L;
	private int requestId;
	private int clientId;
	protected String error;
	
	// ======== Class Getters/Setters =================================================== //

	public void setRequestId(int value) {
		this.requestId = value;
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setClientId(int value) {
		this.clientId = value;
	}

	public int getClientId() {
		return clientId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
