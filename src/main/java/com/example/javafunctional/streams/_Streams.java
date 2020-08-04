package com.example.javafunctional.streams;

import static com.example.javafunctional.Gender.FEMALE;
import static com.example.javafunctional.Gender.MALE;
import static com.example.javafunctional.Gender.PREFER_NOT_TO_SAY;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.example.javafunctional.Person;

public class _Streams {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person(1, "James", "Bond", MALE),
				new Person(2, "Bryan", "Mills", MALE),
				new Person(3, "Anna", "Smith", FEMALE));

//		people.stream()
//				.map(Person::getGender)
//				.collect(Collectors.toSet())
//				.forEach(System.out::println);
//
//		Function<Person, String> firstNameFunction = Person::getFirstName;
//		ToIntFunction<String> firstNameLengthToIntFunction = String::length;
//		IntConsumer printlnIntConsumer = System.out::println;
//
//		people.stream()
//				.map(firstNameFunction)
//				.mapToInt(firstNameLengthToIntFunction)
//				.forEach(printlnIntConsumer);


		Predicate<Person> femalePredicate = person -> person.getGender().equals(FEMALE);
		boolean containsOnlyFemales = people.stream()
				.allMatch(femalePredicate);
		System.out.println(containsOnlyFemales);


		boolean atleastOneFemale = people.stream()
				.anyMatch(femalePredicate);
		System.out.println(atleastOneFemale);

		Predicate<Person> preferNotToSayPredicate = person -> person.getGender().equals(PREFER_NOT_TO_SAY);
		boolean doesNotContainsPreferNotToSay = people.stream()
				.noneMatch(preferNotToSayPredicate);
		System.out.println(doesNotContainsPreferNotToSay);

	}
}
