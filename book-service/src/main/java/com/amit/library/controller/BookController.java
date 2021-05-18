package com.amit.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.library.entity.Book;
import com.amit.library.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/book")
@Api(tags = "Book Controller", value = "Book Service", description ="Books")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Save Book Api")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(service.saveBook(book), HttpStatus.CREATED);
	}

	
	@GetMapping(path = "", produces = "application/json")
	@ApiOperation(value = "Get Book Api")
	public List<Book> getBook() {
		return service.getBook();
	}

	@GetMapping(path= "/{id}" , produces = "application/json" )
	@ApiOperation(value = "Get Book Api By ID")
	public Book getBookByID(@PathVariable("id") int Bookid) {
		return service.getBookByIdService(Bookid).get();
	}
	
	/*@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<List<Book>> getBook() {
		return new ResponseEntity<>(service.getBook(), HttpStatus.OK);
	}

	@GetMapping(path= "/{id}" , produces = "application/json" )
	public ResponseEntity<Optional<Book>> getBookByID(@PathVariable("id") int Bookid) {
		return new ResponseEntity<>(service.getBookByIdService(Bookid), HttpStatus.OK);
	} */
	
}
