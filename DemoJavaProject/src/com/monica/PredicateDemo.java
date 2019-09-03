package com.monica;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> intCheck = j -> j > 10;
		Predicate<String> strCheck = s -> s.startsWith("m");
		System.out.println(intCheck.test(100));
		System.out.println(strCheck.test("monica"));
		System.out.println(intCheck.negate().test(1000));
	}
}
