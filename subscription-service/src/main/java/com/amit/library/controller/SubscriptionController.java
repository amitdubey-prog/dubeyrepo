package com.amit.library.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.amit.library.entity.SubscriptionEntity;
import com.amit.library.entity.SubscriptionReturn;
import com.amit.library.exception.UserServiceException;
import com.amit.library.service.SubscriptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/subscription")
@Api(tags = "Subscription Controller", value = "Subscription Service", description ="subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subservice;

	
	@PostMapping(path= "", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "subscribe/Return Book Api")
	public ResponseEntity<SubscriptionEntity> SubscriptionRecord(@RequestBody SubscriptionEntity request)
			throws RestClientException, URISyntaxException {
		SubscriptionEntity se = subservice.saveSubscription(request);
		if (se==null) throw new UserServiceException("This Book is not available now. please try later.");
		/*if (null == se) {
			return new ResponseEntity<SubscriptionEntity>(HttpStatus.UNPROCESSABLE_ENTITY);
		}*/
		return new ResponseEntity<>(se, HttpStatus.CREATED);

	}

	
	@PatchMapping(path= "/{subscriptionid}", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Return Book Api")
	public ResponseEntity<SubscriptionEntity> SubscriptionRecordReturn(@PathVariable("subscriptionid")  int Subscriptionid,
			@RequestBody SubscriptionReturn request)
			throws RestClientException, URISyntaxException {
		SubscriptionEntity se1 = subservice.returnSubscription(Subscriptionid,request);
		
		return new ResponseEntity<>(se1, HttpStatus.CREATED);

	}
	
	@GetMapping(path="", produces = "application/json")
	@ApiOperation(value = "Searh all Subscribed Book  Api")
	public List<SubscriptionEntity> getSubscriber() {
		return subservice.getSubscription();
	}
	
	


	@GetMapping(path= "/{subscriptionid}" , produces = "application/json" )
	@ApiOperation(value = "Search  Subscribed Book  By ID Api")
	public SubscriptionEntity  getSubscriberByID(
			@PathVariable("subscriptionid") int Subscriptionid) {
		return subservice.getSubscriberByID(Subscriptionid).get();
	}
	/*@GetMapping(path="", produces = "application/json")
	public ResponseEntity<List<SubscriptionEntity>> getSubscriber() {
		return new ResponseEntity<>(subservice.getSubscription(), HttpStatus.OK);
	}
	
	


	@GetMapping(path= "/{subscriptionid}" , produces = "application/json" )
	public ResponseEntity<Optional<SubscriptionEntity>> getSubscriberByID(
			@PathVariable("subscriptionid") int Subscriptionid) {
		return new ResponseEntity<>(subservice.getSubscriberByID(Subscriptionid), HttpStatus.OK);
	} */
	

}
