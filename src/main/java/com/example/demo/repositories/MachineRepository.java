package com.example.demo.repositories;

import com.example.demo.models.MachineModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends CrudRepository<MachineModel, Long> {
    
}
