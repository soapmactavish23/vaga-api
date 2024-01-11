package com.hkprogrammer.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hkprogrammer.api.exception.NegocioException;
import com.hkprogrammer.api.model.Product;
import com.hkprogrammer.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> search(String code, String date) {
		if (!code.equals("") || !date.equals("")) {
			return repository.search(code, date);
		} else {
			return repository.findAll();
		}
	}

	public List<Product> upload(MultipartFile file) {
		List<Product> list = new ArrayList<>();
		
		if (file.getOriginalFilename().endsWith(".json")) {
			list = parseJsonFile(file);
			System.out.println(list);
		} else if (file.getOriginalFilename().endsWith(".xml")) {
			list = parseXmlFile(file);
		} else {
			throw new NegocioException("Formato de arquivo não suportado.");
		}
		
		List<Product> finalList = new ArrayList<>();
		
		if(list.size() > 10) {
			throw new NegocioException("A lista deve conter no máximo 10 itens");
		}
		
		for(Product p : list) {
			Product pSaved = create(p);
			finalList.add(pSaved);
		}
		
		return finalList;

	}
	
	private List<Product> parseJsonFile(MultipartFile file) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
			return objectMapper.readValue(file.getBytes(), new TypeReference<List<Product>>() {});
		} catch (IOException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao converter o JSON");
		}
	}
	
	private List<Product> parseXmlFile(MultipartFile file) {
		XmlMapper xmlMapper = new XmlMapper();
        try {
			return xmlMapper.readValue(file.getBytes(), new TypeReference<List<Product>>() {});
		} catch (IOException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao converter o XML");
		}
	}

	public Product create(Product obj) {
		Boolean exists = existsProductByCode(obj.getCode());
		if (exists) {
			alertExistsProduct();
		}
		
		return repository.save(obj);
	}

	public Product update(Product obj) {
		Product objSaved = findById(obj.getId());

		Boolean exists = existsProductByCode(obj.getCode());

		if (exists && !obj.getCode().equals(objSaved.getCode())) {
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
