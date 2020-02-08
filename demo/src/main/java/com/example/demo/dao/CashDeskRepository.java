package com.example.demo.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.CashDesk;



public interface CashDeskRepository extends JpaRepository<CashDesk, Long> ,JpaSpecificationExecutor<CashDesk>{
}