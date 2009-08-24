package de.gmorling.scriptassert;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.gmorling.scriptassert.model.CalendarEvent;

public class CalendarEventTest {

	private static Validator validator;

	private Date startDate;

	private Date endDate;

	@BeforeClass
	public static void setUpValidator() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Before
	public void setUpDates() {
		startDate = new GregorianCalendar(2009, 8, 20).getTime();
		endDate = new GregorianCalendar(2009, 8, 21).getTime();
	}

	@Test
	public void validCalendarEvent() {

		CalendarEvent testEvent = new CalendarEvent("Team meeting", startDate,
				endDate);

		assertTrue(validator.validate(testEvent).isEmpty());
	}

	@Test
	public void invalidCalendarEvent() {

		CalendarEvent testOrder = new CalendarEvent("Team meeting", endDate,
				startDate);

		Set<ConstraintViolation<CalendarEvent>> constraintViolations = validator
				.validate(testOrder);
		assertEquals(1, constraintViolations.size());

		assertEquals(
				"Script statement \"_this.creationDate.before(_this.shipmentDate)\" didn't evaluate to TRUE.",
				constraintViolations.iterator().next().getMessage());
	}

}
