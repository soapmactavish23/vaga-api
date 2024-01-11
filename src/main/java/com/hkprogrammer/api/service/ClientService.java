package com.hkprogrammer.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hkprogrammer.api.model.Client;
import com.hkprogrammer.api.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public Client create(Client obj) {
		return repository.save(obj);
	}

	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client update(Client obj) {
		Client objSaved = findById(obj.getId());
		
		BeanUtils.copyProperties(obj, objSaved, "id");
		
		return repository.save(objSaved);
	}
	
	public void delete(Integer id) {
		Client obj = findById(id);
		repository.deleteById(obj.getId());
	}

	public Client findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
