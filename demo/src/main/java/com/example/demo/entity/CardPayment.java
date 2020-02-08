package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Entity;

import java.io.Serializable;

@Entity  // 实体
public class CardPayment extends Payment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */

	
	private String cardAccountNumber;
	private float fee;
    private Date expiryDate;

	public String getCardAccountNumber() {
		return cardAccountNumber;
	}

	public void setCardAccountNumber(String cardAccountNumber) {
		this.cardAccountNumber = cardAccountNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}
	

	/* all references */
	
	/* all get and set functions */



	
	/* all functions for reference*/
	


}
