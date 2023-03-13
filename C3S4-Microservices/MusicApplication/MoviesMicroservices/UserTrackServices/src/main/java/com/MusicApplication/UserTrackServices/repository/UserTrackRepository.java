package com.MusicApplication.UserTrackServices.repository;

import com.MusicApplication.UserTrackServices.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTrackRepository extends MongoRepository<User,String> {
    User findByUserId(String userId);
}
