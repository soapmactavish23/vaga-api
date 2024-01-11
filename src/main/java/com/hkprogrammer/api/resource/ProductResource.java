package com.hkprogrammer.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hkprogrammer.api.model.Product;
import com.hkprogrammer.api.service.ProductService;

@RestController
@RequestMapping("/produto")
public class ProductResource {

	@Autowired
	private ProductService service;

	@GetMapping
	public List<Product> findAll(@RequestParam(defaultValue = "") String code,
			@RequestParam(defaultValue = "") String date) {
		return service.search(code, date);
	}
	
		
	@PostMapping("/upload")
	public List<Product> upload(@RequestParam("file") MultipartFile file) {
		return service.upload(file);
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody @Valid Product obj) {
		Product objSaved = service.create(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(objSaved);
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody @Valid Product obj) {
		Product objSaved = service.update(obj);
		return ResponseEntity.ok(objSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product objSaved = service.findById(id);
		return ResponseEntity.ok(objSaved);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
