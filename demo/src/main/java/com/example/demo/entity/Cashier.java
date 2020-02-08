package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Cashier implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	private String Name;
	
	/* all references */
	@ManyToOne(targetEntity=Store.class) 
	@JoinColumn(name="store_id",referencedColumnName="id") 
	private Store WorkedStore; 
	
	/* all get and set functions */

	public String getName() {
		return Name;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	/* all functions for reference*/
	public Store getWorkedStore() {
		return WorkedStore;
	}	
	
	public void setWorkedStore(Store store) {
		this.WorkedStore = store;
	}			
}
