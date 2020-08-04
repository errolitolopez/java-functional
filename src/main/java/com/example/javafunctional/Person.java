package com.example.javafunctional;

public class Person {

	private final Integer personId;
	private final String firstName;
	private final String lastName;
	private final Gender gender;

	public Integer getPersonId() {
		return personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Gender getGender() {
		return gender;
	}

	public Person(Integer personId, String firstName, String lastName, Gender gender) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + "]";
	}


}
