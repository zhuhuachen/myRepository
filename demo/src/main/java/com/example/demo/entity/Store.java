package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

@Entity 
public class Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	private String name;
	private String address;
	private boolean isOpened;
	
//	/* all references */
//	@OneToMany(targetEntity=CashDesk.class) 
//	@JoinColumn(name="store_id",referencedColumnName="id") 
//	private List<CashDesk> AssociationCashdeskes = new LinkedList<CashDesk>(); 
//	
//	
//	@OneToMany(targetEntity=ProductCatalog.class) 
//	@JoinColumn(name="store_id",referencedColumnName="id") 
//	private List<ProductCatalog> Productcatalogs = new LinkedList<ProductCatalog>(); 
//	
//	@OneToMany(targetEntity=Cashier.class) 
//	@JoinColumn(name="store_id",referencedColumnName="id") 
//	private List<Cashier> Cashiers = new LinkedList<Cashier>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

//	public List<CashDesk> getAssociationCashdeskes() {
//		return AssociationCashdeskes;
//	}
//
//	public void setAssociationCashdeskes(List<CashDesk> associationCashdeskes) {
//		AssociationCashdeskes = associationCashdeskes;
//	}
//
//	public List<ProductCatalog> getProductcatalogs() {
//		return Productcatalogs;
//	}
//
//	public void setProductcatalogs(List<ProductCatalog> productcatalogs) {
//		Productcatalogs = productcatalogs;
//	}
//
//	public List<Cashier> getCashiers() {
//		return Cashiers;
//	}
//
//	public void setCashiers(List<Cashier> cashiers) {
//		Cashiers = cashiers;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	

}
