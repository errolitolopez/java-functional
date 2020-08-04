package com.example.javafunctional;

public class Customer {

	private final String customerName;
	private final String customerPhoneNumber;

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public Customer(String customerName, String customerPhoneNumber) {
		super();
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerPhoneNumber=" + customerPhoneNumber + "]";
	}

}
