package com.example.javafunctional;

import static com.example.javafunctional.Gender.FEMALE;
import static com.example.javafunctional.Gender.MALE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFunctionalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaFunctionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Person> people = Arrays.asList(
				new Person(1, "James", "Bond", MALE),
				new Person(2, "Bryan", "Mills", MALE),
				new Person(3, "Anna", "Smith", FEMALE),
				new Person(4, "Maria", "Jones", FEMALE)
		);

		// Imperative Approach
		System.out.println("Imperative Approach");
		List<Person> females = new ArrayList<>();

		for (Person person: people) {
			if (FEMALE.equals(person.getGender())) {
				females.add(person);
			}
		}

		for (Person female: females) {
			System.out.println(female);
		}

		// Declarative Approach
		System.out.println("Declarative Approach");
		List<Person> females2 = people.stream()
				.filter(person -> person.getGender().equals(FEMALE))
				.collect(Collectors.toList());

		females2.forEach(System.out::println);
	}
}
