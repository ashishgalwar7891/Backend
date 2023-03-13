package com.example.c2.s3.mc1.controller;

import com.example.c2.s3.mc1.domain.Track;
import com.example.c2.s3.mc1.exception.TrackAlreadyexistException;
import com.example.c2.s3.mc1.exception.TrackArtistNotFoundException;
import com.example.c2.s3.mc1.exception.TrackNotFoundException;
import com.example.c2.s3.mc1.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService=trackService;
    }
    //http://localhost:8075/api/v1/add
    @PostMapping("/add")
    public ResponseEntity<?> addAllTracks(@RequestBody Track track)throws TrackAlreadyexistException
    {
        try
        {
            return new ResponseEntity<>(trackService.addTracks(track), HttpStatus.CREATED);
        }
        catch (TrackAlreadyexistException trackAlreadyexistException)
        {
            throw trackAlreadyexistException;
        }
    }
    //http://localhost:8075/api/v1/get
    @GetMapping("/get")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<>(trackService.getAllTracks(),HttpStatus.FOUND);
    }
    //http://localhost:8075/api/v1/delete/*
    @DeleteMapping("/delete/{trackId}")
    public ResponseEntity<?> deleteTrackById(@PathVariable String trackId) throws TrackNotFoundException
    {
        try
        {
            return new ResponseEntity<>(trackService.deleteTrackById(trackId),HttpStatus.OK);
        }
        catch (TrackNotFoundException trackNotFoundException)
        {
            throw trackNotFoundException;
        }
    }
    //http://localhost:8075/api/v1/rating
    @GetMapping("/rating")
    public ResponseEntity<?> getTrackByRatingGreaterThan4()
    {
        return new ResponseEntity<>(trackService.getTracksByRatingGreaterThan4(),HttpStatus.FOUND);
    }
    //http://localhost:8075/api/v1/artist
    @GetMapping("/artist/{artistName}")
    public ResponseEntity<?> getTrackByArtist(@PathVariable String artistName)throws TrackArtistNotFoundException
    {
        return new ResponseEntity<>(trackService.getTrackByTrackArtist(artistName),HttpStatus.FOUND);
    }
}
