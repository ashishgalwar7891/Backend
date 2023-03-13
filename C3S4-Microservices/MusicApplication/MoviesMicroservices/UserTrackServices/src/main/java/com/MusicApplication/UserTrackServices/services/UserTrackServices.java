package com.MusicApplication.UserTrackServices.services;

import com.MusicApplication.UserTrackServices.domain.User;
import com.MusicApplication.UserTrackServices.domain.Track;

import com.MusicApplication.UserTrackServices.exception.TrackNotFoundException;
import com.MusicApplication.UserTrackServices.exception.UserAlreadyExistsException;
import com.MusicApplication.UserTrackServices.exception.UserNotFoundException;

import java.util.List;

public interface UserTrackServices {
    User registerUser(User user) throws UserAlreadyExistsException;
    User saveUserTrackToList(Track track, String userId) throws UserNotFoundException;
    User deleteUserTrackFromList(String userId,String trackId) throws UserNotFoundException, TrackNotFoundException;
    List<Track> getAllUserTracks(String userId) throws UserNotFoundException;
    List<Track> getAllTracksByGenre(String genre);
    List<Track> getAllTracks();

}
