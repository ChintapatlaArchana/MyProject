package com.cts.controller;

import com.cts.exception.BookException;
import com.cts.model.Book;
import com.cts.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book b) {
        try {
            return new ResponseEntity<Book>(bookService.addBook(b), HttpStatus.CREATED);
        } catch (BookException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get http://localhost:8082/book/1
    @RequestMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        try {
            return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book1")
    public ResponseEntity<Book> getBookById1(@RequestParam long id) {
        try {
            return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/book")
    public ResponseEntity<List<Book>> getAllBook() {
        try {
            return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.FOUND);
        } catch (BookException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable long id) {
        try {
            return new ResponseEntity<Book>(bookService.deleteBookById(id), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book b) {
        try {
            return new ResponseEntity<Book>(bookService.updateBook(b), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
