package com.example.AuthApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private String email,name,address,shippingAddress,phno;


}
