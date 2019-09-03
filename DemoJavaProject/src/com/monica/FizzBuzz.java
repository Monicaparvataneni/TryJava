package com.monica;

public class FizzBuzz {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				count++;
				System.out.println("FizzBuzz");
			} else if (i % 5 == 0) {
				count++;
				System.out.println("Buzz");
			} else if (i % 3 == 0) {
				count++;
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
		System.out.println("count :: " + count);
	}

}
