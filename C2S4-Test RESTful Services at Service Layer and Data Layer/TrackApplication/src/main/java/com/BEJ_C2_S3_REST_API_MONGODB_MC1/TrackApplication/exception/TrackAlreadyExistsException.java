package com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Track with this id is already present")
public class TrackAlreadyExistsException extends Exception{
}
