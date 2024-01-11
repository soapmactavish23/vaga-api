package com.hkprogrammer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
