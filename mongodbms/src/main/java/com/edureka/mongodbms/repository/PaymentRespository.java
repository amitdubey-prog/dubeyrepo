package com.edureka.mongodbms.repository;

import com.edureka.mongodbms.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRespository extends MongoRepository<Payment, String> {
}
