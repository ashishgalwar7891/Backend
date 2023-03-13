package com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication;

import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.domain.Artist;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.domain.Track;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.repository.TrackRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TrackRepositortTest {
    @Autowired
    private TrackRepository trackRepository;
    private Artist artist;
    private Track track;

    @BeforeEach
    void setUp(){
        artist = new Artist("a0011","monu");
        track = new Track("t0011","omom",7,artist);
    }
    @AfterEach
    void tearDown(){
        artist=null;
        track=null;
        trackRepository.deleteAll();
    }
    @Test
    @DisplayName("Test case for saving track object")   //it's check --> post operation
    void Test1(){
        trackRepository.save(track);
        Track track1=trackRepository.findById(track.getTrackId()).get();
        assertNotNull(track1);
        assertEquals(track.getTrackId(),track1.getTrackId());
        assertEquals(track.getTrackName(),track1.getTrackName());
        assertEquals(track.getTrackArtist(),track1.getTrackArtist());
        assertEquals(track.getTrackRating(),track1.getTrackRating());
        assertEquals(track,track1);
    }
    @Test
    @DisplayName("Test Case for delete track Success ")
    public void test2()
    {
        trackRepository.save(track);
        trackRepository.deleteById(track.getTrackId());
        //Track track1 = trackRepository.findById(track.getTrackId());
        assertEquals(Optional.empty(), trackRepository.findById(track.getTrackId()));
    }

    @Test
    @DisplayName("Test Case for delete track failure ")
    public void test3()
    {
        trackRepository.insert(track);
        Track track1 = trackRepository.findById(track.getTrackId()).get();
        trackRepository.deleteById(track.getTrackId());
        assertNotEquals(track1, trackRepository.findById(track.getTrackId()));
    }

}
