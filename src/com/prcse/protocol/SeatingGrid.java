package com.prcse.protocol;

import java.util.ArrayList;
import java.util.HashMap;

import com.prcse.datamodel.SeatingArea;
import com.prcse.utils.Connectable;
import com.prcse.utils.PrcseSource;

public class SeatingGrid extends BaseRequest {
	
	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = 1220975553304345677L;
	private long eventId;
	private ArrayList<HashMap<Long, SeatingArea>> seatingAreas;

	// ======== Class Constructor ====================================================== //
	
	public SeatingGrid(long eventId) {
		this.eventId = eventId;
	}

	@Override
	public void handleRequest(Connectable dataSource) {
		try {
			this.seatingAreas = ((PrcseSource)dataSource).getEventSeatingMap(eventId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object getResult() {
		return this.seatingAreas;
	}

	@Override
	public boolean shouldBroadcast() {
		return false;
	}

	@Override
	public boolean shouldSync() {
		return false;
	}

}
