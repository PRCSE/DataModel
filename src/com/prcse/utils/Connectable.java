package com.prcse.utils;

import java.util.Observer;

// interface for classes with connections (client-server, server-database)
public interface Connectable {
	public abstract void connect() throws Exception;
	
	public abstract void disconnect() throws Exception;

	public abstract boolean isConnected();

	public abstract void addObserver(Observer observer);
}
