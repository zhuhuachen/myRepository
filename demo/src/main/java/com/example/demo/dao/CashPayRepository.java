package com.example.demo.dao;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.CashPayment;
import com.example.demo.entity.Sale;



public interface CashPayRepository extends JpaRepository<CashPayment, Integer> ,JpaSpecificationExecutor<CashPayment>{
	List<CashPayment> findByBelongedSale(Sale s);
//	List<Store> findByName(String name);
//	List<Store> findByNameLike(String string);
}