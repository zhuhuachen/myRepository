package com.example.demo.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Store;



public interface StoreRepository extends JpaRepository<Store, Integer> ,JpaSpecificationExecutor<Store>{
	
//	List<Store> findByName(String name);
//	List<Store> findByNameLike(String string);
}