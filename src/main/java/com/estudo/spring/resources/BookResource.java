package com.estudo.spring.resources;

import com.estudo.spring.dtos.BookDTO;
import com.estudo.spring.models.Book;
import com.estudo.spring.models.Book;
import com.estudo.spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        book = bookService.create(book);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(book);
    }
}
