package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.LinkedList;
import java.io.Serializable;

@Entity  // 实体
public class CashDesk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	
	private String Name;
	
	private boolean IsOpened;
	
	/* all references */
//	@OneToMany(targetEntity=Sale.class) 
//	@JoinColumn(name="cash_desk_id",referencedColumnName="id") 
//	private List<Sale> ContainedSales = new LinkedList<Sale>(); 
//	
	@ManyToOne(targetEntity=Store.class) 
	@JoinColumn(name="store_id",referencedColumnName="id") 
	private Store BelongedStore; 
	
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
	public boolean getIsOpened() {
		return IsOpened;
	}	
	
	public void setIsOpened(boolean isopened) {
		this.IsOpened = isopened;
	}
	
	/* all functions for reference*/
//	public void setContainedSales(List<Sale> containedSales) {
//		ContainedSales = containedSales;
//	}
//	public List<Sale> getContainedSales() {
//		return ContainedSales;
//	}	
//	
//	public void addContainedSales(Sale sale) {
//		this.ContainedSales.add(sale);
//	}
//	
//	public void deleteContainedSales(Sale sale) {
//		this.ContainedSales.remove(sale);
//	}
	public Store getBelongedStore() {
		return BelongedStore;
	}	
	
	public void setBelongedStore(Store store) {
		this.BelongedStore = store;
	}			


}
