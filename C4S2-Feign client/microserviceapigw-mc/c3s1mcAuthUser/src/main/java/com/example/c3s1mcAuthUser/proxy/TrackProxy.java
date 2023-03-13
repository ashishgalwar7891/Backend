package com.example.c3s1mcAuthUser.proxy;

import com.example.c3s1mcAuthUser.domain.TrackDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "TrackApp",url = "localhost:8075")
public interface TrackProxy {
    @PostMapping("/api/v1/add")
    public ResponseEntity<?> sendDataToTrack(TrackDTO trackDTO);
}
