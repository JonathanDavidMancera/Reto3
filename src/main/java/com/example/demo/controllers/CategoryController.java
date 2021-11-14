package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CategoryModel;
import com.example.demo.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public ArrayList<CategoryModel> obtenerUsuarios() {
        return categoryService.obtenerCategoria();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel guardarCategoria(@RequestBody CategoryModel category) {
        return this.categoryService.guardarCategoria(category);
    }

    @GetMapping( path = "/{id}")
    public Optional<CategoryModel> obtenerCategoriaPorId(@PathVariable("id") Long id) {
        return this.categoryService.obtenerPorId(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel actualizarCateogoria(@RequestBody CategoryModel category) {
        return this.categoryService.guardarCategoria(category);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String eliminarPorId(@PathVariable("id")Long id) {
        boolean ok = this.categoryService.eliminarUsuario(id);

        if(ok) {
            return "";
        } else {
            return "";
        }
    }
}
