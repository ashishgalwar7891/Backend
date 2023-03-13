package com.example.c2.s3.mc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "This Track Id is not available")
public class TrackNotFoundException extends Exception{
}
