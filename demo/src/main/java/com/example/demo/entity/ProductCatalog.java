package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.io.Serializable;
@Entity 
public class ProductCatalog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	private String Name;
	
	@ManyToOne(targetEntity=Store.class) 
	@JoinColumn(name="store_id",referencedColumnName="id") 
	private Store BelongedStore; 

//	@OneToMany(targetEntity=Item.class) 
//	@JoinColumn(name="catalog_id",referencedColumnName="id") 
//	private Set<Item> ContainedItems = new HashSet<Item>();
	
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



	public void setName(String name) {
		this.Name = name;
	}

//	public Set<Item> getContainedItems() {
//		return ContainedItems;
//	}
//
//	public void setContainedItems(Set<Item> containedItems) {
//		ContainedItems = containedItems;
//	}
//	
	/* all functions for reference*/

}
