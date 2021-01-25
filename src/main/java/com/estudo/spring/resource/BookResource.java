package com.estudo.spring.resource;

import com.estudo.spring.dto.BookDTO;
import com.estudo.spring.model.Book;
import com.estudo.spring.model.Book;
import com.estudo.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        Book book = bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(){
        List<Book> books = bookService.findAll();
        List<BookDTO> bookDTOS = books.stream().map(BookDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(bookDTOS);
    }
}
