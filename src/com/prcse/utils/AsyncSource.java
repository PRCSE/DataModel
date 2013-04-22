package com.prcse.utils;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import com.prcse.protocol.Request;
import com.prcse.utils.Connectable;

// 
public class AsyncSource extends Observable implements Connectable, Runnable {

	// ======== Class Variables ======================================================== //
	
	protected HashMap<Integer, ResponseHandler> requestCallbacks; // holds the list of request that have been handled (coming back)
	protected int requestIdSeed; // counter for request id's
	protected String host; // host location
	protected int port; // port number for host connection
	private Socket socket = null; // connection socket
	protected ArrayList<Request> outputQueue; // list of requests havn't been handled (going out)
	private int clientId = 0; // unique identifier for client connection (used by server)
	private boolean shouldDisconnect; // flag for shutdown procedure
	
	// ======== Class Constructor ====================================================== //

	public AsyncSource(String host, int port) {
		super();
		requestCallbacks = new HashMap<Integer, ResponseHandler>();
		requestIdSeed = 0;
		this.host = host;
		this.port = port;
		outputQueue = new ArrayList<Request>();
	}
	
	// ======== Class Getters/Setters =================================================== //

	public int getClientId() {
		return clientId;
	}

	// check if closing
	public synchronized boolean isShouldDisconnect() {
		return shouldDisconnect;
	}
	
	// check for a connection
	public boolean isConnected() {
		return this.socket != null;
	}

	// flags that the source should disconnect (begin closing)
	public synchronized void setShouldDisconnect(boolean shouldDisconnect) {
		this.shouldDisconnect = shouldDisconnect;
	}

	// used to add unique identifiers to requests
	public int nextRequestId() {
		requestIdSeed ++;
		return requestIdSeed;
	}
	
	// ======== Class Methods ===================================================== //

	// establish server connection
	public void connect() throws Exception {
		socket = new Socket(this.host, this.port);
	    this.shouldDisconnect = false;
	    changed(null);
	}

	// force the connection thread to die
	public void disconnect() throws Exception {
		this.socket.close();
		this.socket = null;
		this.clientId = 0;
		changed(null);
	}

	// flag datasource change
	public void changed(Object arg1) {
		setChanged();
		notifyObservers(arg1);
		clearChanged();
	}
	
	// generic change
	protected void changed() {
		this.changed(null);
	}

	// pull request off the queue to be handled
	private synchronized Request GetNextOutput() {
		Request result = null;
		if(outputQueue.size() > 0){
			result = (Request)outputQueue.get(0);
			outputQueue.remove(0);
			System.out.println("Request removed.");
		}
		return result;
	}

	// add item to queue
	protected synchronized void addToOutput(Request request) {
		request.setClientId(clientId);
		outputQueue.add(request);
		System.out.println("Request added.");
	}

	// main run method for the connection thread
	public void run() {
		try {
			this.connect();
	
			// socket connection parameters
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
	    	BufferedInputStream buff = new BufferedInputStream(socket.getInputStream());
			ObjectInputStream input = new ObjectInputStream(buff);
	    	
			// retrieve client id
			this.clientId = ((Integer)input.readObject()).intValue();
			System.out.println("ID recieved. [" + clientId + "]");
			
			// notify client of change (id received)
			this.changed();
	
			// main loop
			while(true) {
				// get request of queue
				Request request = GetNextOutput();
				// try output request
				if(request != null) {
					output.writeObject(request);
					output.flush();
					System.out.println("Request sent.");
					
					request = null;
				}
				//test input for something to receive
				if(buff.available() > 0) {
					//get request id, callback and invoke later in thread
					final Request response = (Request)input.readObject();
					System.out.println("Response received.");
					if(response.getClientId() == this.clientId) {
						Integer key = new Integer(response.getRequestId());
						if(this.requestCallbacks.containsKey(key)) {
							handleResponse(response, key);
						}
					}
					else {
						// send back response
						changed(response);
					}
				}
				if(isShouldDisconnect() == true){ // check for disconnect command
					this.disconnect();
					break;
				}
				Thread.sleep(10); // pause work
			}
		} 
		catch (Exception e1) {
			e1.printStackTrace(); // throw general errors
		}
	}

	// process for reaction to a response
	protected void handleResponse(final Request response, Integer key) {
		ResponseHandler handler = (ResponseHandler)this.requestCallbacks.get(key);
		handler.handleResponse(response);
	}

}