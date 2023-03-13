package com.example.MongoCRUDdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Customer with this id is already present")
public class CustomerAlreadyExistsException extends Exception{
}
