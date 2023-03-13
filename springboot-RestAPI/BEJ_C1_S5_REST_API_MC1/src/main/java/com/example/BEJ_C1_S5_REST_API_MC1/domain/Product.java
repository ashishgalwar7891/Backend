package com.example.BEJ_C1_S5_REST_API_MC1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    String productName;
    @Id
    String ProductId;
    String manufacturer;
}
