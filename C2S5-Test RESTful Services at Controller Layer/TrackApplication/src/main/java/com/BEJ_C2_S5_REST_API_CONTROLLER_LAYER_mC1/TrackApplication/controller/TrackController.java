package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.controller;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Track;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/track/v1")
public class TrackController {
    @Autowired
    private TrackService trackService;
    //http://localhost:7899/api/track/v1/addTrack
    @PostMapping("/addTrack")
    public ResponseEntity<?> addTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        try{
            return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.OK);
        }
        catch (TrackAlreadyExistsException trackAlreadyExistsException)
        {
            throw trackAlreadyExistsException;
        }
    }
    //http://localhost:7899/api/track/v1/deleteTrack/XXX
    @DeleteMapping("/deleteTrack/{tid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String tid) throws TrackNotFoundException
    {
        try {
            return new ResponseEntity<>(trackService.deleteTrack(tid), HttpStatus.OK);
        }
        catch (TrackNotFoundException trackNotFoundException){
            throw trackNotFoundException;
        }
    }
    //http://localhost:7899/api/track/v1/getTrack
    @GetMapping("/getTrack")
    public ResponseEntity<?> getAllTrack()
    {
        return new ResponseEntity<>(trackService.getAllTrack(), HttpStatus.OK);
    }
    //http://localhost:7899/api/track/v1/trackRating/XXX
    @GetMapping("/trackRating/{tr}")
    public ResponseEntity<?> getTrackByTrackRating(@PathVariable int tr) throws TrackNotFoundException
    {
        return new ResponseEntity<>(trackService.getTrackWhereTrackRatingGreaterThanFour(tr),HttpStatus.OK);

    }
    //http://localhost:7899/api/track/v1/artistName/XXX
    @GetMapping("/artistName/{an}")
    public ResponseEntity<?> getTrackByArtistName(@PathVariable String an) throws TrackNotFoundException{
        return new ResponseEntity<>(trackService.getTrackByArtistName(an),HttpStatus.OK);
    }
}
