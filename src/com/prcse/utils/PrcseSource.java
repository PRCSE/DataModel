package com.prcse.utils;

import java.util.ArrayList;

public interface PrcseSource extends Connectable {

	public abstract ArrayList<Object> getFrontPage() throws Exception;
	
	
}
