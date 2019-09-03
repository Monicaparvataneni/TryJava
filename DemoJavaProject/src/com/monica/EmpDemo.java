package com.monica;

import java.util.ArrayList;
import java.util.Collections;
//comporator lambda function for customised object
public class EmpDemo {
//lambda for comporator 
	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(4, "Monica"));
		empList.add(new Employee(2, "Sahana"));
		empList.add(new Employee(3, "Balu"));
System.out.println("before sorting"+empList);
Collections.sort(empList, (e1,e2)->(e1.eNo<e2.eNo)?-1:(e1.eNo>e2.eNo)?1:0);
System.out.println("after sorting"+empList);
	}

}
