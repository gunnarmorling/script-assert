package de.gmorling.beanvalidation.scriptassert;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.script.ScriptEngineManager;
import javax.validation.Constraint;
import javax.validation.ConstraintPayload;

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ScriptAssertValidator.class)
@Documented
public @interface ScriptAssert {

	String message() default "{de.gmorling.beanvalidation.scriptassert}";

	Class<?>[] groups() default {};

	Class<? extends ConstraintPayload>[] payload() default {};

	/**
	 * 
	 * @return The name of the script language as expected by the JSR 223
	 *         {@link ScriptEngineManager}.
	 */
	String lang();

	String script();

	/**
	 * Defines several @ScriptAssert annotations on the same element
	 * 
	 * @see ScriptAssert
	 * 
	 * @author Gunnar Morling
	 */
	@Target( { TYPE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		ScriptAssert[] value();
	}
}