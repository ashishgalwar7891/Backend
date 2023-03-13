package com.example.BEJ_C2_S1_REST_MYSQL_MC1.controller;

import com.example.BEJ_C2_S1_REST_MYSQL_MC1.domain.Track;
import com.example.BEJ_C2_S1_REST_MYSQL_MC1.services.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TrackController {
    private final TrackServices trackServices;
    @Autowired
    public TrackController(TrackServices trackServices) {
        this.trackServices = trackServices;
    }
    @PostMapping("/track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackServices.saveTrack(track), HttpStatus.OK);
    }
    @GetMapping("/track")
    public ResponseEntity<?> getTrack(){
        return new ResponseEntity<>(trackServices.getAllTracks(),HttpStatus.FOUND);
    }
    @GetMapping("/track/{lastname}")
    public ResponseEntity<?> getTrackByTrackId(@PathVariable String trackId){
        return new ResponseEntity<>(trackServices.getTrackByTrackId(trackId),HttpStatus.FOUND);
    }
    @DeleteMapping("/track/{email}")
    public ResponseEntity<?> deleteTrack(@PathVariable String trackId){
        return new ResponseEntity<>(trackServices.deleteTrackByTrackId(trackId),HttpStatus.ACCEPTED);

    }
    @PutMapping("/track/{email}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable String trackId){
        return new ResponseEntity<>(trackServices.updateTrack(track,trackId),HttpStatus.GONE);
    }
}
