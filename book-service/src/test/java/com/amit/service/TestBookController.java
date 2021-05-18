package com.amit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.amit.library.controller.BookController;
import com.amit.library.entity.Book;
import com.amit.library.repository.BookRepository;
import com.amit.library.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TestBookController {

	@InjectMocks
	BookController bookController;

	@Mock
	BookService service;

	protected MockMvc mvc;

	@BeforeEach
	protected void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(bookController).build();

	}

	@Test
	 @DisplayName("Test Add Book controller")
	public void testAddBook() throws Exception {
//	        MockHttpServletRequest request = new MockHttpServletRequest();
//	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//	         
		// Book book = new Book(101, "The white Tiger", "Arvind Addiga", 10, 10);
//	        when(service.saveBook(any(Book.class))).thenReturn(book);
//	         
//	        
//	        ResponseEntity<Book> responseEntity = employeeController.saveBook(book);
//	         
//	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		ObjectMapper objectMapper = new ObjectMapper();
		Book book1 = new Book(101, "The white Tiger", "Arvind Addiga", 10, 10);

		String uri = "/book";
		RequestBuilder rqb = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(book1));

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	 @DisplayName("Test Find all Book Controller ")
	public void testFindAll() throws Exception {

		// ObjectMapper objectMapper = new ObjectMapper();
		Book book1 = new Book(101, "The white Tiger", "Arvind Addiga", 10, 10);
		doReturn(Arrays.asList(book1)).when(service).getBook();

		String uri = "/book";
		RequestBuilder rqb = MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE);

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists());

	}

	@Test
	 @DisplayName("Test book By ID Controller ")
	public void testFindById() throws Exception {

		Book book1 = new Book(101, "The white Tiger", "Arvind Addiga", 10, 10);
		doReturn(Optional.of(book1)).when(service).getBookByIdService(101);

		// Mockito.when(service.getBookByIdService(Mockito.eq(101))).thenReturn(Optional.ofNullable(book1));
		String uri = "/book/101";
		RequestBuilder rqb = MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE);

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists());

	}

}
