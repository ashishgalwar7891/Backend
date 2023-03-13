package com.MusicApplication.UserTrackServices.controller;

import com.MusicApplication.UserTrackServices.domain.Track;
import com.MusicApplication.UserTrackServices.domain.User;
import com.MusicApplication.UserTrackServices.exception.TrackNotFoundException;
import com.MusicApplication.UserTrackServices.exception.UserAlreadyExistsException;
import com.MusicApplication.UserTrackServices.exception.UserNotFoundException;
import com.MusicApplication.UserTrackServices.services.UserTrackServices;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserTrackController {
    private UserTrackServices userTrackServices;
    private ResponseEntity<?> responseEntity;
    @Autowired
    public UserTrackController(UserTrackServices userTrackServices) {

        this.userTrackServices = userTrackServices;
    }
    //http://localhost:777/api/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(userTrackServices.registerUser(user), HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e)
        {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }
    //http://localhost:777/api/v1/user/movie
    @PostMapping("/user/movie")
    public ResponseEntity<?> saveUserTrackToList(@RequestBody Track movie, HttpServletRequest request) throws UserNotFoundException {
        try {
            System.out.println("header" +request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);
            responseEntity = new ResponseEntity<>(userTrackServices.saveUserTrackToList(movie, email), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
    //http://localhost:777/api/v1/user/movies
    @GetMapping("/user/movies")
    public ResponseEntity<?> getAllUserTracksFromList(HttpServletRequest request) throws UserNotFoundException {
        try{
            System.out.println("header" +request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);
            responseEntity = new ResponseEntity<>(userTrackServices.getAllUserTracks(email), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
    //http://localhost:777/api/v1/user/XXX
    @DeleteMapping("/user/{movieId}")
    public ResponseEntity<?> deleteUserTrackFromList(@PathVariable String movieId, HttpServletRequest request)
            throws UserNotFoundException, TrackNotFoundException
    {
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);
        try {
            responseEntity = new ResponseEntity<>(userTrackServices.deleteUserTrackFromList(email, movieId), HttpStatus.OK);
        } catch (UserNotFoundException | TrackNotFoundException m) {
            throw new TrackNotFoundException();
        }
        return responseEntity;
    }
}



