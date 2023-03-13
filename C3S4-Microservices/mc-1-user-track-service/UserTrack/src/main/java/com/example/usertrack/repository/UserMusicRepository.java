package com.example.usertrack.repository;

import com.example.usertrack.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMusicRepository extends MongoRepository<Music, String> {


}
