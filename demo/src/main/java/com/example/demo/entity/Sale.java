package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;
@Entity 
public class Sale implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	private Date time;
	private boolean isComplete;
	private float amount;
	private boolean isReadytoPay;
	

	
	@ManyToOne(targetEntity=CashDesk.class) 
	@JoinColumn(name="cash_desk_id",referencedColumnName="id")
	private CashDesk BelongedCashDesk; 
	
//	@OneToMany(targetEntity=SalesLineItem.class) 
//	@JoinColumn(name="sale_id",referencedColumnName="id") 
//	private List<SalesLineItem> ContainedSalesLine = new LinkedList<SalesLineItem>(); 
	
	
//	@OneToOne(mappedBy = "sale_id", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//  	private Payment AssoicatedPayment;
		
	/*
	 * @OneToOne(cascade=CascadeType.ALL)//Sale是关系的维护端，当删除 Sale，会级联删除 Payment
	 * 
	 * @JoinColumn(name = "payment_id", referencedColumnName =
	 * "id")//Sale中的payment_id字段参考Payment表中的id字段 private Payment AssoicatedPayment;
	 */


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public boolean isComplete() {
		return isComplete;
	}


	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public boolean isReadytoPay() {
		return isReadytoPay;
	}


	public void setReadytoPay(boolean isReadytoPay) {
		this.isReadytoPay = isReadytoPay;
	}


//	public List<SalesLineItem> getContainedSalesLine() {
//		return ContainedSalesLine;
//	}
//
//
//	public void setContainedSalesLine(List<SalesLineItem> containedSalesLine) {
//		ContainedSalesLine = containedSalesLine;
//	}


	public CashDesk getBelongedCashDesk() {
		return BelongedCashDesk;
	}


	public void setBelongedCashDesk(CashDesk belongedCashDesk) {
		BelongedCashDesk = belongedCashDesk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
}
