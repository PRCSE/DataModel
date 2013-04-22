package com.prcse.datamodel;

import java.io.Serializable;

/*
 * TODO: write class description
 */
public abstract class PersistantObject implements Serializable {

	
	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = 7248168704303738812L;
	protected long id;
	
	
	// ======== Class Getters/Setters =================================================== //
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PersistantObject [id=" + id + "]";
	}
}
