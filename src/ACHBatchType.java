/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

/**
 * @author MichaelDev
 *
 */
public enum ACHBatchType {
	COLLECTION(1, "COLLECTION"), PAYROLL(2, "Employeee"), VENDOR(3, "Employeee"), REVERSAL(4, "Reversal");

	public Integer code;
	public String name;

	ACHBatchType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
}