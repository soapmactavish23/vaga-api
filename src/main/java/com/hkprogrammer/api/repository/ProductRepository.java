package com.hkprogrammer.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hkprogrammer.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public boolean existsProductByCode(Integer code);
	
	@Query(value = "SELECT * FROM product p WHERE p.code = ?1 OR p.date LIKE ?2", nativeQuery = true)
	public List<Product> search(String code, String date);
}
