package com.example.javafunctional.functionalinterface;

import java.util.Optional;

public class _Optionals {
	public static void main(String[] args) {
		Object value = Optional.ofNullable(null)
				.orElseGet(() -> "default value");
		System.out.println(value);

		Object valueV1 = Optional.ofNullable("valueV1")
				.orElseGet(() -> "default value");
		System.out.println(valueV1);

		Object valueV2 = Optional.ofNullable("valueV2")
				.orElseThrow(() -> new IllegalStateException("exception"));
		System.out.println(valueV2);

		Optional.ofNullable("valueV3")
				.ifPresent(valueV3 -> {
					// logic
					System.out.println(valueV3);
				});

		Optional.ofNullable("valueV4")
				.ifPresent(System.out::println);

		Optional.ofNullable("errolitolopez@gmail.com")
				.ifPresent(email -> {
					System.out.println(String.format("Sending email to %s", email));
				});
	}
}
