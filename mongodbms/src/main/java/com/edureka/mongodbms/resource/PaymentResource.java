package com.edureka.mongodbms.resource;

import com.edureka.mongodbms.model.Payment;
import com.edureka.mongodbms.repository.PaymentRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentRespository paymentRespository;

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
       return paymentRespository.findAll();
    }

    @PostMapping(path = "/payments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newPayment(@RequestBody Payment payment) throws URISyntaxException {
        Payment newPayment = paymentRespository.save(payment);
        return ResponseEntity.created(new URI(newPayment.getId())).build();
    }
}
