package com.amit.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.amit.library.common.Book;
import com.amit.library.entity.SubscriptionEntity;
import com.amit.library.entity.SubscriptionReturn;
import com.amit.library.repository.SubscriptionRepository;
import com.amit.library.service.SubscriptionService;
import com.fasterxml.jackson.core.JsonProcessingException;

import ch.qos.logback.core.boolex.Matcher;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class TestService {

	@InjectMocks
	SubscriptionService service;
	
	

	@Mock
	SubscriptionRepository repository;

	@Mock
	private RestTemplate restTemplate;

	

	@BeforeEach
	public void init() {
		MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	@DisplayName("Test findAll Sunscriptios")
	void testAllSubscriptions() {
		// LocalDate date = LocalDate.parse("2020-08-22");

		// Setup our mock repository
		SubscriptionEntity subscriber1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				LocalDate.of(2020, 8, 25), 101);
		SubscriptionEntity subscriber2 = new SubscriptionEntity(2, "Dilip", LocalDate.of(2020, 8, 22), null, 102);

		doReturn(Arrays.asList(subscriber1, subscriber2)).when(repository).findAll();

		// Execute the service call
		List<SubscriptionEntity> subscriptions = service.getSubscription();

		// Assert the response
		Assertions.assertEquals(2, subscriptions.size(), "findAll should return 2 subscriptions");
	}

	@Test
	@DisplayName("Test findSubscriptionById Success")
	void testSubscriptionById() throws Exception {
		// Setup our mock repository
		SubscriptionEntity subscriber1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				LocalDate.of(2020, 8, 25), 101);
		doReturn(Optional.of(subscriber1)).when(repository).findById(101);

		// Execute the service call
		Optional<SubscriptionEntity> subentity = service.getSubscriberByID(101);

		// Assert the response
		Assertions.assertTrue(subentity.isPresent(), "subscriber was not found");
		Assertions.assertSame(subentity.get(), subscriber1, "The subscriber returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test Book Subscription")
	void testSubscriptionSave() throws RestClientException, URISyntaxException, JsonProcessingException {
		// Setup our mock repository
		SubscriptionEntity subscription1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				null, 101);
		
		SubscriptionEntity subscriptionSaved = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				null, 101);
		Book book1 = new Book();
		book1.setCopiesAvailable(5);
		book1.setBookId(101);

		ResponseEntity<Object> reponseEntity = new ResponseEntity(book1, HttpStatus.OK);
		//Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any())).thenReturn(reponseEntity);
		
		Mockito.when(restTemplate.exchange(
		         Mockito.anyString(), 
		         Mockito.any(HttpMethod.class),
		         Mockito.any(),
		         Mockito.any(Class.class)))
		     .thenReturn(reponseEntity);
		
		
		Mockito.when(repository.save(Mockito.any())).thenReturn(subscriptionSaved);
		
		SubscriptionEntity s1=service.saveSubscription(subscription1);
		Assertions.assertEquals(101, s1.getBookId());
	}
	
	@Test
	@DisplayName("Test Book Return ")
	void testSubscriptionReturn() throws RestClientException, URISyntaxException, JsonProcessingException {
		// Setup our mock repository
		SubscriptionReturn subscription3 = new SubscriptionReturn(LocalDate.of(2020, 8, 22));
		SubscriptionEntity subscription2 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				LocalDate.of(2020, 8, 25), 101);
		
		
		SubscriptionEntity subscriptionSaved = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				LocalDate.of(2020, 8, 22), 101);
		
		Book book1 = new Book();
		book1.setCopiesAvailable(5);
		book1.setBookId(101);
		
		
		ResponseEntity<Object> reponseEntity = new ResponseEntity(book1, HttpStatus.OK);
		
		Mockito.when(restTemplate.exchange(
		         Mockito.anyString(), 
		         Mockito.eq(HttpMethod.GET),
		         Mockito.<HttpEntity<?>> any(),
		         Mockito.any(Class.class)))
		     .thenReturn(reponseEntity);
			

		
		doReturn(Optional.of(subscription2)).when(repository).findById(1);
		Mockito.when(repository.save(Mockito.any())).thenReturn(subscriptionSaved);
		
		SubscriptionEntity s1=service.returnSubscription(1,subscription3);	
	
		
		
		Assertions.assertEquals(101, s1.getBookId());
		
		Mockito.verify(restTemplate, times(1)).exchange(
		         Mockito.anyString(), 
		         Mockito.eq(HttpMethod.GET),
		         Mockito.<HttpEntity<?>> any(),
		         Mockito.any(Class.class));
		
		Mockito.verify(restTemplate, times(1)).exchange(
		         Mockito.anyString(), 
		         Mockito.eq(HttpMethod.POST),
		         Mockito.<HttpEntity<?>> any(),
		         Mockito.any(Class.class));

	}
	
	
	/*@Test
	@DisplayName("Test Book Return ")
	void testSubscriptionReturn() throws RestClientException, URISyntaxException, JsonProcessingException {
		// Setup our mock repository
		SubscriptionEntity subscription2 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				LocalDate.of(2020, 8, 25), 101);
		
		SubscriptionEntity subscriptionSaved = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				LocalDate.of(2020, 8, 25), 101);
		
		Book book1 = new Book();
		book1.setCopiesAvailable(5);
		book1.setBookId(101);
		
	

		ResponseEntity<Object> reponseEntity = new ResponseEntity(book1, HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any())).thenReturn(reponseEntity);
		
		doReturn(Arrays.asList(subscription2)).when(repository).findAll(); 
		Mockito.when(repository.save(Mockito.any())).thenReturn(subscriptionSaved);

		SubscriptionEntity s1=service.saveSubscription(subscription2);
		
		
		Assertions.assertEquals(101, s1.getBookId());

	}
	
	*/

}
