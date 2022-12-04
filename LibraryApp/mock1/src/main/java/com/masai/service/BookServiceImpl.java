package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;
import com.masai.repository.BookDAO;

@Service
public class BookServiceImpl implements BooksService {

	@Autowired
	private BookDAO bookDao;
	
	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		// TODO Auto-generated method stub
		List<Book> books = bookDao.findAll();

		if (books.isEmpty())
			throw new BookNotFoundException("No book records found");

		return books;

	}

	@Override
	public Book getBookById(Integer bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub

		Optional<Book> book = bookDao.findById(bookId);

		return book.orElseThrow(() -> new BookNotFoundException("No book records found"));
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
	}

	@Override
	public String deleteBook(Integer bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		Optional<Book> book = bookDao.findById(bookId);

		if (!book.isPresent()) throw new BookNotFoundException("No book records found");

		bookDao.delete(book.get());

		return "Book deleted succefully with ID" + bookId;

	}

	@Override
	public Book updateBook(Book book, Integer bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		Optional<Book> o_book = bookDao.findById(bookId);

		if (!o_book.isPresent()) throw new BookNotFoundException("No book records found");

		Book eBook = o_book.get();
		eBook.setName(book.getName());
		eBook.setAuthor(book.getAuthor());
		eBook.setCategory(book.getCategory());
		eBook.setPublication(book.getPublication());
		eBook.setPages(book.getPages());
		eBook.setPrice(book.getPrice());
		
		return bookDao.save(eBook);
	}

}
