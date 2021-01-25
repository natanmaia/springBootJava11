package com.estudo.spring.resources;

import com.estudo.spring.dtos.CategoryDTO;
import com.estudo.spring.models.Category;
import com.estudo.spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        category = categoryService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.update(id, categoryDTO);

        return ResponseEntity.ok().body(new CategoryDTO(category));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoryService.delete(id);

        return ResponseEntity.noContent().build();

    }
}
