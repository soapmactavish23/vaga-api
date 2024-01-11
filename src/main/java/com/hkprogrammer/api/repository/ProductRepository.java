package com.hkprogrammer.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public boolean existsProductByCode(Integer code);
	
	public List<Product> findByCodeOrDate(Integer code, Date date);
	
}
