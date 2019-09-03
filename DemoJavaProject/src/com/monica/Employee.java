/**
 * 
 */
package com.monica;

/**
 * @author Monica_Parvataneni
 *
 */
public class Employee {

	int eNo;
	String eName;
	/**
	 * 
	 */
	public Employee(int eNo,String eName) {
		this.eNo = eNo;
		this.eName = eName;
	}
	public String toString(){
		return eNo+"-->"+eName;
	}

}
