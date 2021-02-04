package com.estudo.spring.resources;

import com.estudo.spring.dtos.BookDTO;
import com.estudo.spring.models.Book;
import com.estudo.spring.services.BookService;
import com.estudo.spring.services.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Integer id) {
        BookDTO book = new BookDTO(bookService.findById(id));
        return ResponseEntity.ok().body(book);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        List<Book> books = bookService.findAll();
        List<BookDTO> bookDTOS = books.stream().map(BookDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(bookDTOS);
    }

    @GetMapping(value = "/id_categoria/{id_category}")
    public ResponseEntity<List<BookDTO>> findByCategory(@PathVariable Integer id_category) {
        List<Book> books = bookService.findByCategory(id_category);
        List<BookDTO> bookDTOS = books.stream().map(BookDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(bookDTOS);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO bookDTO) {

        Book book = new Book();
        book.setText(bookDTO.getText());
        book.setAuthor(bookDTO.getAuthor());
        book.setTittle(bookDTO.getTittle());
        book.setCategory(categoryService.findById(bookDTO.getId_category()));

        book = bookService.create(book);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(book);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
        Book editBook = bookService.update(id, book);

        return ResponseEntity.ok().body(editBook);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book book) {
        Book editBook = bookService.update(id, book);

        return ResponseEntity.ok().body(editBook);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);

        return ResponseEntity.noContent().build();

    }
}
