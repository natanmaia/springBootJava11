package com.estudo.spring.service;

import com.estudo.spring.model.Book;
import com.estudo.spring.model.Category;
import com.estudo.spring.repository.BookRepository;
import com.estudo.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public void criarBase(){
        Category category = new Category(null, "informática", "Livros de TI");
        Category category2 = new Category(null, "Ciências", "Livros de Ficção Científica");
        Category category3 = new Category(null, "Biografias", "Livros de biografias");

        Book book = new Book(null, "Clean Code", "Robert Martin", "Lorem ipsum", category);
        Book book2 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", category);
        Book book3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", category2);
        Book book4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", category2);
        Book book5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", category2);

        category.getBooks().addAll(Arrays.asList(book, book2));
        category2.getBooks().addAll(Arrays.asList(book3, book4, book5));

        this.categoryRepository.saveAll(Arrays.asList(category, category2, category3));
        this.bookRepository.saveAll(Arrays.asList(book, book2, book3, book4, book5));
    }
}
