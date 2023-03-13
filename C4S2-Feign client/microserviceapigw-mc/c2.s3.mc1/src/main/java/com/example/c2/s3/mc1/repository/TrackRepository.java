package com.example.c2.s3.mc1.repository;

import com.example.c2.s3.mc1.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,String> {
    @Query("{'trackRating':{$lt:4}}")
    public List<Track> getTrackRatingGreaterThan4();

    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    public List<Track> getTrackByArtist(String trackArtist);
}
