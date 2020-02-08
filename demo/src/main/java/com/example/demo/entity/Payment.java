package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class Payment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* all primary attributes */
	
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private int id;
	
	private float amountTendered;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/*
	 * 	CascadeType.PERSIST：级联新增（又称级联保存）：对order对象保存时也对items里的对象也会保存。对应EntityManager的presist方法。
		CascadeType.MERGE：级联合并（级联更新）：若items属性修改了那么order对象保存时同时修改items里的对象。对应EntityManager的merge方法 。
		CascadeType.REMOVE：级联删除：对order对象删除也对items里的对象也会删除。对应EntityManager的remove方法。
		CascadeType.REFRESH：级联刷新：获取order对象里也同时也重新获取最新的items时的对象。对应EntityManager的refresh(object)方法有效。即会重新查询数据库里的最新数据。
		CascadeType.ALL：以上四种都是
	 * */
	@OneToOne(cascade=CascadeType.ALL)//CardPayment是关系的维护端，当删除CardPayment，会级联删除 Sale
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale belongedSale;

	public float getAmountTendered() {
		return amountTendered;
	}

	public void setAmountTendered(float amountTendered) {
		this.amountTendered = amountTendered;
	}

	public Sale getBelongedSale() {
		return belongedSale;
	}

	public void setBelongedSale(Sale belongedSale) {
		this.belongedSale = belongedSale;
	} 
	
	

}
