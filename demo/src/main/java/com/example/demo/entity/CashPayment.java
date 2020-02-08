package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity 
public class CashPayment extends Payment  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	private float balance;
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/* all references */
	
	/* all get and set functions */

}
