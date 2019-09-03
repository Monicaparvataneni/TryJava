package com.monica;

public class ReverseString {

	public static void main(String[] args) {
String str ="Hello World!";
System.out.println(reverseWithSB(str));
System.out.println(reverseManually(str));
System.out.println(reverseManuallyNoSB(str));
	}

	private static String reverseWithSB(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	private static String reverseManually(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1;i>=0;i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	private static String reverseManuallyNoSB(String str) {
		String reverse="";
		for(int i=str.length()-1;i>=0;i--){
			reverse = reverse+str.charAt(i);
		}
		return reverse;
	}

}
