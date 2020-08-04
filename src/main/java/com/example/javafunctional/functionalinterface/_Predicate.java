package com.example.javafunctional.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

	private static final String IS_PHONE_NUMBER_VALID_AND_CONTAINS_3 = "Is phone number valid and contains 3: %s";

	public static void main(String[] args) {
		System.out.println("Without Predicate");
		System.out.println(isPhoneNumberValid("09999999999"));
		System.out.println(isPhoneNumberValid("08888888888"));
		System.out.println(isPhoneNumberValid("099999999999"));
		System.out.println("With Predicate");
		System.out.println(isPhoneNumberValidPredicate.test("09999999999"));
		System.out.println(isPhoneNumberValidPredicate.test("08888888888"));
		System.out.println(isPhoneNumberValidPredicate.test("099999999999"));

		System.out.println(String.format(IS_PHONE_NUMBER_VALID_AND_CONTAINS_3,
				isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("09999999999"))
		);

		System.out.println(String.format(IS_PHONE_NUMBER_VALID_AND_CONTAINS_3,
				isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("09999999993"))
		);

		System.out.println(String.format(IS_PHONE_NUMBER_VALID_AND_CONTAINS_3,
				isPhoneNumberValidPredicate.or(containsNumber3Predicate).test("09999999999"))
		);

		System.out.println(isPhoneNumberIdenticalPredicate.test("09999999999", "09999999999"));
		System.out.println(isPhoneNumberIdenticalPredicate.test("09999999999", "08888888888"));
	}

	// Normal Function
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("09") && phoneNumber.length() == 11;
	}

	// Functional Interface
	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber
			-> phoneNumber.startsWith("09") && phoneNumber.length() == 11;

	static Predicate<String> containsNumber3Predicate = phoneNumber
			-> phoneNumber.contains("3");

	static BiPredicate<String, String> isPhoneNumberIdenticalPredicate = (phoneNumber1, phoneNumber2)
			-> phoneNumber1.equalsIgnoreCase(phoneNumber2);
}
