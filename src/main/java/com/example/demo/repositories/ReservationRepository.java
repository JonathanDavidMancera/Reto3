package com.example.demo.repositories;

import com.example.demo.models.ReservationModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Long> {
    
}
