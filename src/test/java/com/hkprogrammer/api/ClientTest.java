package com.hkprogrammer.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hkprogrammer.api.model.Client;
import com.hkprogrammer.api.service.ClientService;

@SpringBootTest
public class ClientTest {

	@Autowired
	private ClientService service;

	@Test
	public void contextLoads() {

		Client obj = create();
		obj = update(obj);
		delete(obj);

	}

	public Client create() {
		Client obj = new Client();
		obj.setName("Aurora Flávia Rocha");

		Client objSaved = service.create(obj);
		obj.setId(objSaved.getId());

		assertThat(obj).isEqualTo(objSaved);

		return objSaved;
	}

	public Client update(Client obj) {
		obj.setName("Nair Tânia Raimunda Nascimento");

		Client objSaved = service.update(obj);
		
		assertThat(obj).isEqualTo(objSaved);

		return objSaved;
	}
	
	public void delete(Client obj) {
		service.delete(obj.getId());
	}
}
