package com.estudo.spring.resource;

import com.estudo.spring.dto.CategoryDTO;
import com.estudo.spring.model.Category;
import com.estudo.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(CategoryDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(categoryDTOS);
    }
}
