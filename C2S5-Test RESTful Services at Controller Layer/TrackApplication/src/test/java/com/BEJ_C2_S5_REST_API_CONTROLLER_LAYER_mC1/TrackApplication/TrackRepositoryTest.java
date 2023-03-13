package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Artist;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Track;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.repository.TrackRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;
    private Artist artist;
    private Track track;

    @BeforeEach
    void setUp() {
        artist = new Artist("a001", "asdf");
        track = new Track("t001", "Jonny", 5,artist);
    }

    @AfterEach
    void tearDown() {
        artist = null;
        track = null;
        trackRepository.deleteAll();

    }
    @Test
    @DisplayName("Test case for saving track object")
    void givenCustomerToSaveShouldReturnCustomer() {
        trackRepository.save(track);
        Track track1 = trackRepository.findById(track.getTrackId()).get();
        assertNotNull(track1);
        assertEquals(track.getTrackId(), track1.getTrackId());
    }


    @Test
    @DisplayName("Test case for deleting track object")
    public void givenTrackToDeleteShouldDeleteTrack() {
        trackRepository.insert(track);
        Track track1 = trackRepository.findById(track.getTrackId()).get();
        trackRepository.delete(track1);
        assertEquals(Optional.empty(), trackRepository.findById(track.getTrackId()));

    }

    @Test
    @DisplayName("Test case for retrieving all the  customer object")
    public void givenTrackReturnGetAllTrack() {

        trackRepository.insert(track);
        Artist artist2= new Artist("a002", "Florida ");
        Track track1 = new Track("t002", "Harry", 6,artist);
        trackRepository.insert(track1);

        List<Track> list = trackRepository.findAll();
        assertEquals(2, list.size());
        assertEquals("Harry", list.get(1).getTrackName());

    }

}
