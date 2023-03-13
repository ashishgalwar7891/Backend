package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer with this id is not available")
public class CustomerNotFoundException extends Exception{
}
