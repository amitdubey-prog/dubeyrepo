package com.amit.service;

import static org.mockito.Mockito.doReturn;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.amit.library.entity.Book;
import com.amit.library.repository.BookRepository;
import com.amit.library.service.BookService;

@ExtendWith(MockitoExtension.class)
public class TestBook {

	@InjectMocks
	BookService service;
	
	@Mock
	BookRepository repository;
	
	
	
	  @Test
	    @DisplayName("Test findAll Books")
	    void testFindAll() {
	        // Setup our mock repository
	        Book book1 = new Book(101, "The white Tiger", "Arvind Addiga", 10,10);
	        Book book2 = new Book(102, "Ramayan", "Tulshidash", 6,10);
	        Book book3 = new Book(103, "Ramayan", "Tulshidash", 6,10);
	        doReturn(Arrays.asList(book1, book2, book3)).when(repository).findAll();

	        // Execute the service call
	        List<Book> books = service.getBook();

	        // Assert the response
	        Assertions.assertEquals(3, books.size(), "findAll should return 2 Books");
	    }
	
	  @Test
	    @DisplayName("Test find Book ById Success")
	    void testFindById() {
	        // Setup our mock repository
		  Book book = new Book(101, "The white Tiger", "Arvind Addiga", 10,10);
	        doReturn(Optional.of(book)).when(repository).findById(101);

	        // Execute the service call
	        Optional<Book> returnedBook = service.getBookByIdService(101);

	        // Assert the response
	        Assertions.assertTrue(returnedBook.isPresent(), "book was not found");
	        Assertions.assertSame(returnedBook.get(), book, "The book returned was not the same as the mock");
	    }
	
	  @Test
	    @DisplayName("Test book save ")
	    void testSave() {
	        // Setup our mock repository
	        Book book = new Book(101, "The white Tiger", "Arvind Addiga", 10,10);
	        
	
	        
	        doReturn(book).when(repository).save(book);

	        // Execute the service call
	        Book returnedBook = service.saveBook(book);

	        // Assert the response
	        Assertions.assertNotNull(returnedBook, "The saved book should not be null");
	        Assertions.assertEquals(101, returnedBook.getBookId(), "The BookID should be same");
	    }
}
