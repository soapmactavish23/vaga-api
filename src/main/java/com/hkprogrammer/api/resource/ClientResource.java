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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hkprogrammer.api.model.Client;
import com.hkprogrammer.api.service.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public List<Client> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Client> create(@RequestBody @Valid Client obj) {
		Client objSaved = service.create(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(objSaved);
	}
	
	@PutMapping
	public ResponseEntity<Client> update(@RequestBody @Valid Client obj) {
		Client objSaved = service.update(obj);
		return ResponseEntity.ok(objSaved);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Integer id){
		Client objSaved = service.findById(id);
		return ResponseEntity.ok(objSaved);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
