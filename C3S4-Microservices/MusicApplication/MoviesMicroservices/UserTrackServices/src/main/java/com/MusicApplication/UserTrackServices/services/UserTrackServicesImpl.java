package com.MusicApplication.UserTrackServices.services;

import com.MusicApplication.UserTrackServices.domain.Track;
import com.MusicApplication.UserTrackServices.domain.User;
import com.MusicApplication.UserTrackServices.exception.TrackNotFoundException;
import com.MusicApplication.UserTrackServices.exception.UserAlreadyExistsException;
import com.MusicApplication.UserTrackServices.exception.UserNotFoundException;
import com.MusicApplication.UserTrackServices.repository.UserTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserTrackServicesImpl implements UserTrackServices{
    private UserTrackRepository userTrackRepository;
    @Autowired
    public UserTrackServicesImpl(UserTrackRepository userTrackRepository) {
        this.userTrackRepository = userTrackRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if(userTrackRepository.findById(user.getUserId()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        return userTrackRepository.save(user);
    }

    @Override
    public User saveUserTrackToList(Track movie, String userId) throws UserNotFoundException {
        if(userTrackRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userTrackRepository.findByUserId(userId);
        if(user.getTrackList() == null)
        {
            user.setTrackList(Arrays.asList(movie));
        }
        else {
            List<Track> movies = user.getTrackList();
            movies.add(movie);
            user.setTrackList(movies);
        }
        return userTrackRepository.save(user);
    }

    @Override
    public User deleteUserTrackFromList(String email, String movieId) throws UserNotFoundException, TrackNotFoundException {
        boolean movieIdIsPresent = false;
        if(userTrackRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userTrackRepository.findById(email).get();
        List<Track> movies = user.getTrackList();
        movieIdIsPresent = movies.removeIf(x->x.getTrackId().equals(movieId));
        if(!movieIdIsPresent)
        {
            throw new TrackNotFoundException();
        }
        user.setTrackList(movies);
        return userTrackRepository.save(user);
    }

    @Override
    public List<Track> getAllUserTracks(String email) throws UserNotFoundException {
        if(userTrackRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userTrackRepository.findById(email).get().getTrackList();
    }

    @Override
    public List<Track> getAllTracksByGenre(String genre) {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

}
