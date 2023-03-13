package com.example.MongoCRUDdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {
    @Id //this property will become identifier so '_id' property of mongo will not be created
    private String customerId;
    private String customerName;
    private String phoneNo;
    private Address address;
}
