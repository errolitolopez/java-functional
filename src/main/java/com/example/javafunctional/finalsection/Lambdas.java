package com.example.javafunctional.finalsection;

import static com.example.javafunctional.combinatorpattern.StringValidationResult.SUCCESS;

import java.util.function.Function;

import com.example.javafunctional.combinatorpattern.StringValidationResult;
import com.example.javafunctional.combinatorpattern.StringValidator;

public class Lambdas {
	public static void main(String[] args) {
		Function<String, String> uppperCaseName = name -> name.toUpperCase();

		Function<String, String> uppperCaseNameV1 = name -> {

			StringValidator isNotEmpty = StringValidator.isNotEmpty();
			StringValidator isNotNull = StringValidator.isNotNull();

			StringValidationResult result = isNotNull
					.and(isNotEmpty)
					.apply(name);

			if (result != SUCCESS) {
				throw new RuntimeException(result.name());
			}

			return name.toUpperCase();
		};

		System.out.println(uppperCaseNameV1.apply("errolito"));
	}
}
