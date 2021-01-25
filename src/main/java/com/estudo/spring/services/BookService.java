package com.estudo.spring.services;

import com.estudo.spring.models.Book;
import com.estudo.spring.models.Book;
import com.estudo.spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findById(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id));
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book create(Book book){
        book.setId(null);
        return bookRepository.save(book);
    }
}
