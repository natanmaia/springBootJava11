package com.estudo.spring;

import com.estudo.spring.model.Book;
import com.estudo.spring.model.Category;
import com.estudo.spring.repository.BookRepository;
import com.estudo.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null, "informática", "Livros de TI");

        Book book = new Book(null, "Clean Code", "Robert Martin", "Lorem ipsum", category);

        category.getBooks().addAll(Arrays.asList(book));

        this.categoryRepository.saveAll(Arrays.asList(category));
        this.bookRepository.saveAll(Arrays.asList(book));
    }
}
