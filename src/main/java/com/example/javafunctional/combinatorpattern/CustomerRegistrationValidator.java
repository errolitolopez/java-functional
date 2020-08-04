package com.example.javafunctional.combinatorpattern;

import static com.example.javafunctional.combinatorpattern.ValidationResult.EMAIL_NOT_VALID;
import static com.example.javafunctional.combinatorpattern.ValidationResult.IS_NOT_AN_ADULT;
import static com.example.javafunctional.combinatorpattern.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static com.example.javafunctional.combinatorpattern.ValidationResult.SUCCESS;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

	static CustomerRegistrationValidator isEmailValid() {
		System.out.println("running email validation");
		return customer -> customer.getEmail().contains("@")
				? SUCCESS
				: EMAIL_NOT_VALID;
	}

	static CustomerRegistrationValidator isPhoneNumberValid() {
		System.out.println("phone number validation");
		return customer -> customer.getPhoneNumber().contains("+63")
				&& customer.getPhoneNumber().length() == 13
						? SUCCESS
						: PHONE_NUMBER_NOT_VALID;
	}

	static CustomerRegistrationValidator isAdult() {
		System.out.println("age validation");
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16
				? SUCCESS
				: IS_NOT_AN_ADULT;
	}

	default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(SUCCESS) ? other.apply(customer) : result;
		};
	}
}
