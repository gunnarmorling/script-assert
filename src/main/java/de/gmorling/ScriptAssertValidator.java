package de.gmorling;

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

	public void initialize(ScriptAssert arg0) {

		this.script = arg0.script();
		this.languageName = arg0.lang();
	}

	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {

		ScriptEngine engine = manager.getEngineByName(languageName);

		if (engine == null) {
			throw new IllegalArgumentException(
					"No JSR 223 script engine found for language "
							+ languageName);
		}

		engine.put("_this", arg0);

		try {
			return Boolean.TRUE.equals(engine.eval(script));
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		}
	}
}