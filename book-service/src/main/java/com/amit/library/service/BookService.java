package com.amit.library.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.library.entity.Book;
import com.amit.library.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@org.springframework.transaction.annotation.Transactional
	public Book saveBook(Book book)
	{
		return repository.save(book);
	}

	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Optional<Book> getBookByIdService(int bookid) {
		// TODO Auto-generated method stub
		return repository.findById(bookid);
	}

}
