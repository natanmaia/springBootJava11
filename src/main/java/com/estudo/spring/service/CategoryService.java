package com.estudo.spring.service;

import com.estudo.spring.model.Category;
import com.estudo.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        Optional<Category>  category = categoryRepository.findById(id);
        return category.orElse(null);
    }
}
