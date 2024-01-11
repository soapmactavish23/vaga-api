package com.hkprogrammer.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hkprogrammer.api.exception.NegocioException;
import com.hkprogrammer.api.model.Product;
import com.hkprogrammer.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> search(Integer code, Date date) {
		if(code == null && date == null) {
			return repository.findAll();
		} else {
			return repository.findByCodeOrDate(code, date);
		}
	}

	public Product create(Product obj) {
		Boolean exists = existsProductByCode(obj.getCode());
		if(exists) {
			alertExistsProduct();
		}
		return repository.save(obj);
	}
	
	public Product update(Product obj) {
		Product objSaved = findById(obj.getId());
		
		Boolean exists = existsProductByCode(obj.getCode());
		
		if(exists && !obj.getCode().equals(objSaved.getCode())) {
			alertExistsProduct();
		}
		
		BeanUtils.copyProperties(obj, objSaved, "id");
		return repository.save(objSaved);
		
		
	}
	
	public void delete(Integer id) {
		Product obj = findById(id);
		repository.deleteById(obj.getId());
	}

	public Product findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	private Boolean existsProductByCode(Integer code) {
		return repository.existsProductByCode(code);
	}
	
	private void alertExistsProduct() {
		throw new NegocioException("Já existe um produto cadastrado com esse código");
	}
}
