package de.gmorling.scriptassert.model;

import java.util.Date;

import de.gmorling.ScriptAssert;

@ScriptAssert(lang = "groovy", script = "_this.creationDate.before(_this.shipmentDate)")
public class CalendarEvent {

	private String title;

	private Date creationDate;

	private Date shipmentDate;

	public CalendarEvent(String title, Date creationDate, Date shipmentDate) {
		super();
		this.title = title;
		this.creationDate = creationDate;
		this.shipmentDate = shipmentDate;
	}

	public String getTitle() {
		return title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

}