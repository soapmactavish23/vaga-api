package com.hkprogrammer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//public List<Product> findBy
	
	public boolean existsProductByCode(Integer code);
}
