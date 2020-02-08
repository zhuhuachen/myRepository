package com.example.demo.dao;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Sale;



public interface SaleRepository extends JpaRepository<Sale, Integer> ,JpaSpecificationExecutor<Sale>{
	
	List<Sale> findByIsReadytoPayAndIsComplete(boolean type,boolean tyoe2);
	List<Sale> findByTimeIsNull();
	List<Sale> findFirstByOrderByIdDesc();
//	List<Store> findByNameLike(String string);
}