package com.BEJ_C2_S3_REST_API_MONGODB_PC1.ProductApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product {
    private String productId;
    private  String productName;
    private  String productDescription;
}
