package com.example.javafunctional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		// Function that takes 1 argument and produces 1 result
		int incrementByOneNormal = incrementByOneNormalFunction(1);
		System.out.println(incrementByOneNormal);

		int incrementByOne = incrementByOneFunction.apply(1);
		System.out.println(incrementByOne);

		int multiplyBy10 = multiplyBy10Function.apply(incrementByOne);
		System.out.println(multiplyBy10);

		int addBy1AndThenMultiplyBy10 = addBy1AndThenMultiplyBy10Function.apply(1);
		System.out.println(addBy1AndThenMultiplyBy10);

		// BiFunction that takes 2 argument and produces 1 result

		System.out.println(incrementByOneAndThenMultiplyNormalFunction(4, 100));
		System.out.println(incrementByOneAndThenMultiplyFunction.apply(4, 100));

	}

	// Normal Function
	static int incrementByOneNormalFunction(int number) {
		return number + 1;
	}

	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

	static Function<Integer, Integer> addBy1AndThenMultiplyBy10Function = incrementByOneFunction
			.andThen(multiplyBy10Function);

	static BiFunction<Integer, Integer, Integer> incrementByOneAndThenMultiplyFunction =
			(numberToIncrementByOne, numberToMultiplyBy)
			-> (numberToIncrementByOne + 1) * numberToMultiplyBy;

	static int incrementByOneAndThenMultiplyNormalFunction(int number, int numToMultiplyBy) {
		return (number + 1) * numToMultiplyBy;
	}
}
