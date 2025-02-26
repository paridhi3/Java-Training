package com.onlinebookshop.shop.service;

import java.util.List;

import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.repository.BookRepository;

public class BookService {
	private BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	// add new book
	public void addBook(Book book) {
		bookRepo.save(book);
	}
	
	// find all books
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	// find book by id
	public Book getBookById(int id) {
		return bookRepo.findById(id);
	}
	
	// update book
	public void updateBookDetails(Book book) {
		bookRepo.update(book);
	}
	
	// delete book
	public void deleteBook(int id) {
		bookRepo.delete(id);
	}
	
	
}

