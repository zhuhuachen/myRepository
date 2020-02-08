package com.example.demo.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.ProductCatalog;



public interface CatalogRepository extends JpaRepository<ProductCatalog, Long> ,JpaSpecificationExecutor<ProductCatalog>{
}