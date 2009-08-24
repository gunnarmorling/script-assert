package de.gmorling.beanvalidation.scriptassert;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScriptAssertValidator implements
		ConstraintValidator<ScriptAssert, Object> {

	private String script;

	private String languageName;

	private ScriptEngineManager manager = new ScriptEngineManager();

	public void initialize(ScriptAssert constraintAnnotation) {

		this.script = constraintAnnotation.script();
		this.languageName = constraintAnnotation.lang();
	}

	public boolean isValid(Object value,
			ConstraintValidatorContext constraintValidatorContext) {

		ScriptEngine engine = manager.getEngineByName(languageName);

		if (engine == null) {
			throw new IllegalArgumentException(
					"No JSR 223 script engine found for language "
							+ languageName);
		}

		engine.put("_this", value);

		try {
			return Boolean.TRUE.equals(engine.eval(script));
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		}
	}
}