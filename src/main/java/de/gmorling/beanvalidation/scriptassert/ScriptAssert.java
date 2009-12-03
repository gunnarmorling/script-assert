package de.gmorling.beanvalidation.scriptassert;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.script.ScriptEngineManager;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * <p>
 * A constraint annotation for the <a
 * href="http://jcp.org/en/jsr/detail?id=303">Bean Validation API</a>, that
 * allows to express constraints using any <a
 * href="http://jcp.org/en/jsr/detail?id=223">JSR 223</a> compatible scripting
 * or expression language.
 * </p>
 * <p>
 * Accepts any type.
 * <p>
 * </p>
 * Based on the similar concept of the <a
 * href="http://oval.sourceforge.net/">OVal framework</a>. </p>
 * 
 * @author Gunnar Morling
 */
@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ScriptAssertValidator.class)
@Documented
public @interface ScriptAssert {

	String message() default "{de.gmorling.beanvalidation.scriptassert}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * 
	 * @return The name of the script language as expected by the JSR 223
	 *         {@link ScriptEngineManager}.
	 */
	String lang();

	/**
	 * 
	 * @return The script to be executed. The script must return Boolean.TRUE,
	 *         if the given object could successfully be validated, otherwise
	 *         Boolean.FALSE. Within the script, the validated object can be
	 *         accessed from the script context using the name "_this".
	 */
	String script();

	/**
	 * Defines several @ScriptAssert annotations on the same element.
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