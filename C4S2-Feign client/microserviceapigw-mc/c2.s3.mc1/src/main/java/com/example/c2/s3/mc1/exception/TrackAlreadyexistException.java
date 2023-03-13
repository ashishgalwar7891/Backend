package com.example.c2.s3.mc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "This Track Id is alredy exist")
public class TrackAlreadyexistException extends Exception{
}
