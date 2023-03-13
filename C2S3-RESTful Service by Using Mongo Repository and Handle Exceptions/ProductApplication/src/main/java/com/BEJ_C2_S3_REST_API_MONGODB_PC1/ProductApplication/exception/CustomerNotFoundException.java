package com.BEJ_C2_S3_REST_API_MONGODB_PC1.ProductApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer with this id is not available")
public class CustomerNotFoundException extends Exception{
}
