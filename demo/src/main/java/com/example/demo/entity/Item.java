package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 
public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	
	private int barcode;
	
	@Column(name = "name")
	private String name;
	
	private float price;
	
	private int stockNumber;
	
	private float orderPrice;
	
    private Date createDate;
    
//    @OneToMany(targetEntity=SalesLineItem.class) 
//    @JoinColumn(name="item_id",referencedColumnName="id") 
//    private List<SalesLineItem> ContainedSales = new LinkedList<SalesLineItem>(); 
	/* all references */
	
    @ManyToOne(targetEntity=ProductCatalog.class) 
    @JoinColumn(name="catalog_id",referencedColumnName="id") 
	private ProductCatalog BelongedCatalog; 
    
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductCatalog getBelongedCatalog() {
		return BelongedCatalog;
	}

	public void setBelongedCatalog(ProductCatalog belongedCatalog) {
		BelongedCatalog = belongedCatalog;
	}

	
	public String getName() {
		return name;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStockNumber() {
		return stockNumber;
	}	
	
	public void setStockNumber(int stocknumber) {
		this.stockNumber = stocknumber;
	}
	public float getOrderPrice() {
		return orderPrice;
	}	
	
	public void setOrderPrice(float orderprice) {
		this.orderPrice = orderprice;
	}
	
	/* all functions for reference*/

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//	public List<SalesLineItem> getContainedSales() {
//		return ContainedSales;
//	}
//
//	public void setContainedSales(List<SalesLineItem> containedSales) {
//		ContainedSales = containedSales;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}	
	
}
