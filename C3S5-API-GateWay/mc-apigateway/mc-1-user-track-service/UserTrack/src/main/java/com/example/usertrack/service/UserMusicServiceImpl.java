package com.example.usertrack.service;

import com.example.usertrack.domain.Music;
import com.example.usertrack.repository.UserMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMusicServiceImpl implements UserMusicService{

@Autowired
private UserMusicRepository userMusicRepository;


    @Override
    public Music addUser(Music music) {
        return userMusicRepository.insert(music);
    }

    @Override
    public boolean deleteMusic(String username) {
        boolean flag = false;
        if(userMusicRepository.findById(username).isPresent()){
            userMusicRepository.deleteById(username);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Music> getMusic() {
        return userMusicRepository.findAll();
    }
}
