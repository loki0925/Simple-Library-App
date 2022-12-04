package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;
import com.masai.service.BooksService;

@RestController
@RequestMapping("/bookservice")
public class BookController {


	@Autowired
	private BooksService bookSer;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() throws BookNotFoundException {

		List<Book> books = bookSer.getAllBooks();

		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) throws BookNotFoundException {

		return new ResponseEntity<Book>(bookSer.getBookById(id), HttpStatus.OK);

	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {

		return new ResponseEntity<Book>(bookSer.createBook(book), HttpStatus.OK);

	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id) throws BookNotFoundException {

		return new ResponseEntity<String>(bookSer.deleteBook(id), HttpStatus.OK);

	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Integer id) throws BookNotFoundException {

		return new ResponseEntity<Book>(bookSer.updateBook(book, id), HttpStatus.OK);
	}
	
}
