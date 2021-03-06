package com.example.demo.repositories;

import com.example.demo.models.CategoryModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {
    
}
