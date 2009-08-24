package de.gmorling.scriptassert.model;

import java.util.Date;

import de.gmorling.ScriptAssert;
import de.gmorling.ScriptAssert.List;

@List( {
		@ScriptAssert(lang = "groovy", script = "_this.creationDate.before(_this.shipmentDate)"),
		@ScriptAssert(lang = "groovy", script = "_this.shipmentDate.after(_this.creationDate)") })
public class Order2 {

	private Date creationDate;

	private Date shipmentDate;

	public Order2(Date creationDate, Date shipmentDate) {

		this.creationDate = creationDate;
		this.shipmentDate = shipmentDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

}