package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CategoryModel;
import com.example.demo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ArrayList<CategoryModel> obtenerCategoria() {
        return (ArrayList<CategoryModel>) categoryRepository.findAll();
    }

    public CategoryModel guardarCategoria(CategoryModel category) {
        return categoryRepository.save(category);
    }

    public Optional<CategoryModel> obtenerPorId(Long id) {
        return categoryRepository.findById(id);
    }
}
