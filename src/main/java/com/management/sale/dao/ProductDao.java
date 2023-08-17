package com.management.sale.dao;
import java.util.List;
//Created a repository for storing products
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.management.sale.entity.Product;

public interface ProductDao extends JpaRepository<Product, String> {

	Optional<Product> findById(String productId);
    //Written a logic for pagination
	public Page<Product>  findAll(Pageable pageable);
	
}
