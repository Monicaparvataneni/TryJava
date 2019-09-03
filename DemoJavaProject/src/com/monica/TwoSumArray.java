package com.monica;

import java.util.HashMap;

public class TwoSumArray {

	public static void main(String[] args) {
		int[] numArray = { 4, 3, 5, 4, 8 };
		int total = 8;
		int delta = 0;
		// best way to retrieve is set or map, in map we can also store indices
		// as required per problem so we choose map over set or array.
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numArray.length; i++) {
			delta = total - numArray[i];
			if (indexMap.containsKey(numArray[i])) {
				System.out.println("indices are :: " + indexMap.get(numArray[i]) + " and " + i);
			} else {
				indexMap.put(delta, i);
			}
		}
	}

}
