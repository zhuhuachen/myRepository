package com.example.demo.dao;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Sale;
import com.example.demo.entity.SalesLineItem;



public interface SalesLineItemRepository extends JpaRepository<SalesLineItem, Integer> ,JpaSpecificationExecutor<SalesLineItem>{
	
	List<SalesLineItem> findByBelongedSale(Sale s);
//	List<Store> findByNameLike(String string);
}