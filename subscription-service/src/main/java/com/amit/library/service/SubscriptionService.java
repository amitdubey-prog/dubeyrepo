package com.amit.library.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.amit.library.common.Book;
import com.amit.library.entity.SubscriptionEntity;
import com.amit.library.entity.SubscriptionReturn;
import com.amit.library.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository subrepo;

	@Autowired
	private RestTemplate template;

	private Book book;

	@org.springframework.transaction.annotation.Transactional
	public SubscriptionEntity saveSubscription(SubscriptionEntity request)
			throws RestClientException, URISyntaxException {
		SubscriptionEntity var = null;

		int sid = request.getBookId();
//		Optional<LocalDate> dr=Optional.of(request.getDateReturned());
//		Optional<LocalDate> ds=Optional.of(request.getDateSubscribed());
		// int subid=request.getSubscriptionid();
		// Basic YWRtaW46Ym9uZA==
		// HttpHeaders headers= new HttpHeaders();
		// ResponseEntity<Book> reponseEntity =
		// template.getForEntity("http://localhost:9192/book/" + sid, Book.class);

		// create
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWRtaW46Ym9uZA==");
		// create request
		HttpEntity request1 = new HttpEntity(headers);

		ResponseEntity<Book> response = template.exchange("http://localhost:9192/book/" + sid, HttpMethod.GET, request1,
				Book.class);
		Book book = response.getBody();

		HttpEntity<Book> request2 = new HttpEntity<>(book, headers);

//		//rest call
//		ResponseEntity<List<Book>> reponseEntity = template.exchange("http://localhost:9192/getbook", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Book>>() {
//                });
//		
		// List<Book> books =template.getForObject(new
		// URI("http://localhost:9192/getbook"),);

		// List<Book> books=reponseEntity.getBody();
//		Optional<Book> b1= book.stream()
//		.filter(p -> p.getBookId() == request.getBookId() && p.getCopiesAvailable() >0)
//		.findFirst();

//		if (ds.isPresent())
//		{
//			

		if (book.getCopiesAvailable() > 0 && book != null) {

			if (request.getDateSubscribed() != null && request.getDateReturned() == null) {

				// int a=0;
				// int b=4;

				// if (b1.isPresent())
				var = subrepo.save(request);
				// b=b/a;
				// ResponseEntity<Book> reponseEntity1 =
				// template.exchange("http://localhost:9191/savebook", HttpMethod.POST, null,
				// new ParameterizedTypeReference<Book>() {
				// });
				book.setCopiesAvailable(book.getCopiesAvailable() - 1);
				// template.postForObject("http://localhost:9192/book/", book, Book.class);

				template.exchange("http://localhost:9192/book/", HttpMethod.POST, request2, Book.class);
				// }

			}
		}

		/*
		 * if (request.getDateReturned() != null && request.getDateSubscribed() != null
		 * ) {
		 * 
		 * List<SubscriptionEntity> subscriptionobjs=getSubscription(); for
		 * (SubscriptionEntity obj:subscriptionobjs) {
		 * 
		 * if (obj.getSubscriberName().equalsIgnoreCase(request.getSubscriberName()) &&
		 * obj.getBookId()==request.getBookId()) { var = subrepo.save(request);
		 * book.setCopiesAvailable(book.getCopiesAvailable() + 1);
		 * template.postForObject("http://localhost:9192/book/", book, Book.class);
		 * break; }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 */
		return var;

	}

	public List<SubscriptionEntity> getSubscription() {
		// TODO Auto-generated method stub
		return subrepo.findAll();
	}

	public Optional<SubscriptionEntity> getSubscriberByID(int Subscriptionid) {
		// TODO Auto-generated method stub
		return subrepo.findById(Subscriptionid);
	}

	public SubscriptionEntity returnSubscription(int subscriptionid, SubscriptionReturn request) {
		// TODO Auto-generated method stub
		SubscriptionEntity var2 = null;
		// create
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWRtaW46Ym9uZA==");
		// create request
		HttpEntity request1 = new HttpEntity(headers);

		SubscriptionEntity var1 = getSubscriberByID(subscriptionid).get();
		var1.setDateReturned(request.getDateReturned());
		var2 = subrepo.save(var1);
		int sid = var1.getBookId();

		ResponseEntity<Book> response = template.exchange("http://localhost:9192/book/" + sid, HttpMethod.GET, request1,
				Book.class);
		Book book = response.getBody();

		HttpEntity<Book> request2 = new HttpEntity<>(book, headers);
		book.setCopiesAvailable(book.getCopiesAvailable() + 1);

		ResponseEntity<Book> response1 = template.exchange("http://localhost:9192/book/", HttpMethod.POST, request2,
				Book.class);

		return var2;
	}

}
