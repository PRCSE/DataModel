package com.prcse.datamodel;

import java.io.Serializable;

public abstract class PersistantObject implements Serializable {

	private static final long serialVersionUID = 7248168704303738812L;
	protected long id;
	
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
