package com.example.c2.s3.mc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "This Artist Is not present")
public class TrackArtistNotFoundException extends Exception{
}
