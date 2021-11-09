package com.example.demo.repositories;

import com.example.demo.models.ClientModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Long> {
    
}
