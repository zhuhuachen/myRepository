package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class SalesLineItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	private int quantity;
	private float subamount;
	
	/* all references */
	@ManyToOne(targetEntity=Sale.class) 
	@JoinColumn(name="sale_id",referencedColumnName="id") 
	private Sale belongedSale; 
	
	
	@ManyToOne(targetEntity=Item.class) 
	@JoinColumn(name="item_id",referencedColumnName="id") 
	private Item belongedItem;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getSubamount() {
		return subamount;
	}


	public void setSubamount(float subamount) {
		this.subamount = subamount;
	}


	public Sale getBelongedSale() {
		return belongedSale;
	}


	public void setBelongedSale(Sale belongedSale) {
		this.belongedSale = belongedSale;
	}


	public Item getBelongedItem() {
		return belongedItem;
	}


	public void setBelongedItem(Item belongedItem) {
		this.belongedItem = belongedItem;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}





}
