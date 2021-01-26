package com.estudo.spring.services;

import com.estudo.spring.dtos.BookDTO;
import com.estudo.spring.models.Book;
import com.estudo.spring.repositories.BookRepository;
import com.estudo.spring.repositories.CategoryRepository;
import com.estudo.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id));
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> findByCategory(Integer id_category){
        categoryService.findById(id_category);
        return bookRepository.findByCategory(id_category);
    }

    public Book create(Book book){
        book.setId(null);
        return bookRepository.save(book);
    }

    public Book update(Integer id, Book book) {
        Book editBook = findById(id);
        updateData(editBook, book);
        return bookRepository.save(editBook);
    }

    private void updateData(Book editBook, Book book) {
        editBook.setTittle(book.getTittle());
        editBook.setAuthor(book.getAuthor());
        editBook.setText(book.getText());
    }

    public void delete(Integer id) {
        findById(id);
        bookRepository.deleteById(id);
    }
}
