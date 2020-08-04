package com.example.javafunctional.combinatorpattern;

import static com.example.javafunctional.combinatorpattern.ValidationResult.SUCCESS;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer("Alice",
				"alice@email.com",
				"+639999999999",
				LocalDate.of(2000, 1, 1));

		Customer customerV1 = new Customer("Alice",
				"alice.com",
				"+639999999999",
				LocalDate.of(2000, 1, 1));

		System.out.println(new CustomerValidatorService().isValid(customer));
		System.out.println(new CustomerValidatorService().isValid(customerV1));

		// If valid we can store customer in db

		// Using combinator pattern
		Customer customerV2 = new Customer("Alice",
				"alicegmail.com",
				"+639999999999",
				LocalDate.of(2000, 1, 1));

		CustomerRegistrationValidator isEmailValid = CustomerRegistrationValidator.isEmailValid();
		CustomerRegistrationValidator isAnAdult = CustomerRegistrationValidator.isAdult();
		CustomerRegistrationValidator isPhoneNumberValid = CustomerRegistrationValidator.isPhoneNumberValid();

		ValidationResult result = isEmailValid
				.and(isPhoneNumberValid)
				.and(isAnAdult)
				.apply(customerV2);

		System.out.println(result);
		if (result != SUCCESS) {
			throw new RuntimeException(result.name());
		}
	}
}
