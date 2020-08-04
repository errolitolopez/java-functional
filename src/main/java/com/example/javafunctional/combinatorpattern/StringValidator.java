package com.example.javafunctional.combinatorpattern;

import static com.example.javafunctional.combinatorpattern.StringValidationResult.IS_EMPTY;
import static com.example.javafunctional.combinatorpattern.StringValidationResult.IS_NULL;
import static com.example.javafunctional.combinatorpattern.StringValidationResult.SUCCESS;

import java.util.function.Function;

public interface StringValidator extends Function<String, StringValidationResult> {

	static StringValidator isNotNull() {
		return value -> value != null ? SUCCESS : IS_NULL;
	}

	static StringValidator isNotEmpty() {
		return value -> !value.equals("") ? SUCCESS : IS_EMPTY;
	}

	default StringValidator and(StringValidator other) {
		return value -> {
			StringValidationResult result = this.apply(value);
			return result.equals(SUCCESS) ? other.apply(value) : result;
		};
	}
}
