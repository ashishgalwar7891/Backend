package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String customerPhoneNo;
    private Product customerProduct;
}

