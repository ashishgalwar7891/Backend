package com.example.BEJ_C2_S1_REST_MYSQL_MC1.repository;

import com.example.BEJ_C2_S1_REST_MYSQL_MC1.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,String> {

    List<Track> findByTrackId(String trackId);
    List<Track> findByTrackArtist(String trackArtist);

}
