package com.example.demo.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Cashier;



public interface CashierRepository extends JpaRepository<Cashier, Long> ,JpaSpecificationExecutor<Cashier>{
}