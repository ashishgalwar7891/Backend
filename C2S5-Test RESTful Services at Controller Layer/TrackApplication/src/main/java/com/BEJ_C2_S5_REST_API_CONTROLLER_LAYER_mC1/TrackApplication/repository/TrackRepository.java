package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.repository;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track,String> {
    @Query("{'trackRating':{$gte:4}}")
    List<Track> findAllTrackRatingGreaterThan4(int trackRating);
    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> getTrackByArtistName(String an);
}

