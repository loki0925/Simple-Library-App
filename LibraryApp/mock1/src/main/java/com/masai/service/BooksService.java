package com.masai.service;
import java.util.*;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;

public interface BooksService {

    public List<Book> getAllBooks()  throws BookNotFoundException;
	
	public Book getBookById(Integer bookId) throws BookNotFoundException;

	public Book createBook(Book book);
	
	public String deleteBook(Integer bookId) throws BookNotFoundException;
	
	public Book updateBook(Book book, Integer bookId) throws BookNotFoundException; 
}
