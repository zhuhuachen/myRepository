package com.example.demo.dao;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.CardPayment;
import com.example.demo.entity.Sale;



public interface CardPayRepository extends JpaRepository<CardPayment, Integer> ,JpaSpecificationExecutor<CardPayment>{
	List<CardPayment> findByBelongedSale(Sale s);
//	List<Store> findByName(String name);
//	List<Store> findByNameLike(String string);
}