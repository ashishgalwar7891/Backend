package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Track with this id is not available")
public class TrackNotFoundException extends Exception{
}
