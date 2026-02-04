package com.cts.service;

import com.cts.dao.AuthorRepository;
import com.cts.dao.BookRepository;
import com.cts.exception.BookException;
import com.cts.model.Author;
import com.cts.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

//    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book b) {
        Author author = b.getAuthor();
        authorRepository.save(author);
        return bookRepository.save(b);
    }

    public List<Book> getAllBook() {
        if(bookRepository.findAll().size() == 0) {
            throw new BookException("Book list is empty");
        } else {
            return bookRepository.findAll();
        }
    }

    public Book getBookById(long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isPresent()) {
            return bookRepository.findById(id).get();
        } else {
            throw new BookException("Book not present with isbn -> "+ id);
        }
    }

    public Book updateBook(Book b) {
        Optional<Book> byId = bookRepository.findById(b.getIsbn());
        if(byId.isPresent()) {
            return bookRepository.save(b);
        } else {
            throw new BookException("Book not present with isbn -> "+ b.getIsbn());
        }
    }

    public Book deleteBookById(long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isPresent()) {
            Book b1 = byId.get();
            bookRepository.deleteById(id);
            return b1;
        } else {
            throw new BookException("Book not present with isbn -> "+ id);
        }

    }
}
