package com.example.javafunctional.finalsection;

import java.util.function.Consumer;

public class Callbacks {
	public static void main(String[] args) {

		hello("James", null, value -> {
			System.out.println(String.format("No last name provided for %s", value));
		});
	}

	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if (lastName != null) {
			System.out.println(lastName);
		} else {
			callback.accept(firstName);
		}
	}

//	function hello(firstName, lastName, callback) {
//		console.log(firstName);
//		if (lastName) {
//			console.log(lastName);
//		} else {
//			callback();
//		}
//	}
}
