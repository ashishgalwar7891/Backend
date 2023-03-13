package com.example.c3s1mcAuthUser.service;

import com.example.c3s1mcAuthUser.domain.SignUpData;
import com.example.c3s1mcAuthUser.domain.TrackDTO;
import com.example.c3s1mcAuthUser.domain.User;
import com.example.c3s1mcAuthUser.exception.UserAlredyExistException;
import com.example.c3s1mcAuthUser.exception.UserNotFoundException;
import com.example.c3s1mcAuthUser.proxy.TrackProxy;
import com.example.c3s1mcAuthUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrackProxy trackProxy;

    @Override
    public User register(SignUpData signUpData) throws UserAlredyExistException {
        TrackDTO trackDTO=new TrackDTO(signUpData.getUserName(), signUpData.getTrackName(),signUpData.getTrackId(),signUpData.getTrackRating());
        ResponseEntity<?> responseEntity=trackProxy.sendDataToTrack(trackDTO);

        User user=new User(signUpData.getUserName(),signUpData.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User registerUsers(User user) throws UserAlredyExistException {
       if(userRepository.findById(user.getUserName()).isEmpty())
       {
         return userRepository.save(user);
       }
     else {
         throw new UserAlredyExistException();
       }
    }

    @Override
    public User logInUser(User user) throws UserNotFoundException {
        if(userRepository.findById(user.getUserName()).isPresent())
        {
            User user1=userRepository.findById(user.getUserName()).get();
            if(user1.getPassword().equals(user.getPassword()))
            {
                return user1;
            }
            else {
                return null;
            }
        }
        else {
            throw new UserNotFoundException();
        }
    }
}
