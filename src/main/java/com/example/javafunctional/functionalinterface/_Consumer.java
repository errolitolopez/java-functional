package com.example.javafunctional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.example.javafunctional.Customer;

public class _Consumer {

	public static void main(String[] args) {
		Customer customer = new Customer("Errolito Lopez", "09999999999");
		greetCustomer(customer);
		greetCustomerConsumer.accept(customer);
		greetCustomerConsumerV2.accept(customer, false);
	}

	// Normal Function
	static void greetCustomer(Customer customer) {
		System.out.println(String.format("Hello %1$s thanks for registering phone number %2$s",
				customer.getCustomerName(),
				customer.getCustomerPhoneNumber()));
	}

	// Functional Interface
	static Consumer<Customer> greetCustomerConsumer = customer -> System.out
			.println(String.format("Hello %1$s thanks for registering phone number %2$s",
					customer.getCustomerName(),
					customer.getCustomerPhoneNumber()));

	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out
			.println(String.format("Hello %1$s thanks for registering phone number %2$s",
					customer.getCustomerName(),
					(showPhoneNumber) ? customer.getCustomerPhoneNumber() : "***********"));
}
