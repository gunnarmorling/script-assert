package de.gmorling.beanvalidation.scriptassert.model;

import java.util.Date;

import de.gmorling.beanvalidation.scriptassert.ScriptAssert;

@ScriptAssert(lang = "groovy", script = "_this.startDate.before(_this.endDate)")
public class CalendarEvent {

	private String title;

	private Date startDate;

	private Date endDate;

	public CalendarEvent(String title, Date startDate, Date endDate) {

		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

}