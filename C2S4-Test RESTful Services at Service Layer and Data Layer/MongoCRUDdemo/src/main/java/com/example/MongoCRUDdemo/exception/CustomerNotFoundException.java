package com.example.MongoCRUDdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer with this id is not available")
public class CustomerNotFoundException extends Exception{
}
