package com.amit.controller;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.amit.library.controller.SubscriptionController;

import com.amit.library.entity.SubscriptionEntity;
import com.amit.library.exception.AppExceptionsHandler;
import com.amit.library.exception.UserServiceException;
import com.amit.library.service.SubscriptionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@ExtendWith(MockitoExtension.class)
public class TestController {

	
	@InjectMocks
	SubscriptionController subscriptionController;

	@Mock
	SubscriptionService service;

	@Autowired
	protected MockMvc mvc;

	@BeforeEach
	protected void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(subscriptionController).setControllerAdvice(new AppExceptionsHandler()).build();

	}
	
	@Test
	@DisplayName("Test Book Subscribed  Controller ")
	public void testSaveSubscriptioncontroller() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		SubscriptionEntity subscription1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				null, 101);
		Mockito.when(service.saveSubscription(Mockito.any())).thenReturn(subscription1);

		String uri = "/subscription";
		RequestBuilder rqb = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(subscription1).toString());

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isCreated());


	}
	
	@Test
	@DisplayName("Test  Subscription when No book available ")
	public void testSubscriptionReturnController() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		SubscriptionEntity subscription1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				null, 101);
		Mockito.when(service.saveSubscription(Mockito.any())).thenReturn(null);

		String uri = "/subscription";
		RequestBuilder rqb = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(subscription1).toString());

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
		                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("This Book is not available now. please try later."));
	
		
	}
	
	@Test
	@DisplayName("Test  All Subscription available Controller ")
	public void testFindAllSubscriptionController() throws Exception {

		// ObjectMapper objectMapper = new ObjectMapper();
		SubscriptionEntity subscription1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				null, 101);
		//doReturn(Arrays.asList(subscription1)).when(service).getSubscription();
		Mockito.when(service.getSubscription()).thenReturn(Arrays.asList(subscription1));

		String uri = "/subscription";
		RequestBuilder rqb = MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE);

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists());

	}
	
	@Test
	@DisplayName("Test  Subscription By ID  Controller ")
	public void testFindSubscriptionById() throws Exception {

		SubscriptionEntity subscription1 = new SubscriptionEntity(1, "Amit", LocalDate.of(2020, 8, 22),
				null, 101);
		

		 Mockito.when(service.getSubscriberByID(Mockito.eq(101))).thenReturn(Optional.ofNullable(subscription1));
		String uri = "/subscription/101";
		RequestBuilder rqb = MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE);

		mvc.perform(rqb).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists());

	}

}
