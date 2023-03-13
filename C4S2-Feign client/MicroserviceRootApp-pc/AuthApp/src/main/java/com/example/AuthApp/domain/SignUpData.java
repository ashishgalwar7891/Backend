package com.example.AuthApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpData {
    private String email,password,name,address,shippingAddress,phno,role;
}
