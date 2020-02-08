package com.example.demo.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Item;



public interface ItemRepository extends JpaRepository<Item, Integer> ,JpaSpecificationExecutor<Item>{
	List<Item> findByName(String name);
	List<Item> findByBarcode(int barcode);
	List<Item> findByStockNumber(String name);
}