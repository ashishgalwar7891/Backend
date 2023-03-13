package com.example.usertrack.service;

import com.example.usertrack.domain.Music;

import java.util.List;

public interface UserMusicService {
    public Music addUser(Music music);
    public boolean deleteMusic(String username);
    public List<Music> getMusic();

}