package com.example.usertrack.controller;

import com.example.usertrack.domain.Music;
import com.example.usertrack.service.UserMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserMusicController {
    private UserMusicService userMusicService;
    @Autowired
    public UserMusicController(UserMusicService userMusicService) {
        this.userMusicService = userMusicService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> adduser(@RequestBody Music music){
        return ResponseEntity.ok(userMusicService.addUser(music));
    }
    @GetMapping("/get")
    public ResponseEntity<?> getMusic(){
        return ResponseEntity.ok(userMusicService.getMusic());
    }
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteMusic(@PathVariable String username){
        return ResponseEntity.ok(userMusicService.deleteMusic(username));
    }
}
