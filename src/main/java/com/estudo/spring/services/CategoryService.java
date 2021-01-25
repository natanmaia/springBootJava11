package com.estudo.spring.services;

import com.estudo.spring.models.Category;
import com.estudo.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        Optional<Category>  category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id:" + id ));
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
