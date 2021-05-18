package com.edureka.mongodbms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
@Getter
@Setter
public class Payment {
    @Id
    private String id;
    private String amount;

}
