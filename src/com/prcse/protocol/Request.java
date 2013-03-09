package com.prcse.protocol;

import com.prcse.utils.Connectable;

public interface Request {
	public void handleRequest(Connectable dataSource);
	public Object getResult();
	public String getError();
	public boolean shouldBroadcast();
	public void setRequestId(int value);
	public int getRequestId();
	public void setClientId(int value);
	public int getClientId();
}
