package com.example.BEJ_C2_S1_REST_MYSQL_PC1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    String productId;
    String productName;
    String productDescription;
    String amountInStock;
}
