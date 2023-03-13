package com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication;

import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.domain.Artist;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.domain.Track;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.exception.TrackAlreadyExistsException;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.exception.TrackNotFoundException;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.repository.TrackRepository;

import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.services.TrackServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class TrackServicesTest {
    @Mock
    private TrackRepository trackRepository;
    @InjectMocks
    TrackServiceImpl trackService;
    public List<Track> mytracks ;
    private Track track1 ;
    @BeforeEach
    public void setup()
    {
        mytracks = new ArrayList<Track>();
        mytracks.add(new Track("a001","track1",7,new Artist("a001","Atif Aslam")));
        mytracks.add(new Track("a002","track2",5,new Artist("a002","Arijit Singh")));
        mytracks.add(new Track("a003","track3",6,new Artist("a003","Atif Aslam")));
        mytracks.add(new Track("a004","track4",8,new Artist("a004","Arijit Singh")));
    }

    @Test
    @Order(1)
    public void test_getAlltracks()
    {
        when(trackRepository.findAll()).thenReturn(mytracks);
        List<Track> l1 = trackService.getAllTrack();
        assertEquals(4,trackService.getAllTrack().size());
        assertEquals("track1",l1.get(0).getTrackName());
    }
    @Test
    @Order(2)
    public void test_addtrack() throws TrackAlreadyExistsException
    {
        track1 = new Track("a003","track5",5,new Artist("a001","amit"));
        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(null));
        when(trackRepository.insert(track1)).thenReturn(track1);
        assertEquals("track5",trackService.addTrack(track1).getTrackName());

    }

    @Test
    @Order(3)
    public void test_addtrackfailure() throws TrackAlreadyExistsException
    {
        track1 = new Track("a003","track5",5,new Artist("a001","amit"));
        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(track1));
        assertThrows(TrackAlreadyExistsException.class,()->trackService.addTrack((track1)));
    }

    @Test
    @Order(4)
    public void test_deletetrack() throws TrackNotFoundException
    {
        track1 = new Track("a003","track5",5,new Artist("a001","amit"));
        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(track1));
        boolean flag = trackService.deleteTrack(track1.getTrackId());
        assertEquals(true,flag);

    }

    @Test
    @Order(5)
    public void test_deletetrackfailure() throws TrackNotFoundException
    {
        track1 = new Track("a003","track5",5,new Artist("a001","amit"));
        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(null));
        assertThrows(TrackNotFoundException.class,()->trackService.deleteTrack(track1.getTrackId()));

    }
    @Test
    @Order(6)
    public void test_gettrackbyartistNamesuccess() throws TrackNotFoundException
    {
        String artistname = "Atif Aslam" ;
        when(trackRepository.getTrackByArtistName(artistname)).thenReturn(mytracks);
        assertEquals(artistname,trackService.getTrackByArtistName(artistname).get(0).getTrackArtist().getArtistName());

    }
    @Test
    @Order(7)
    public void test_gettrackbyartistNamefailure() throws Exception
    {
        track1 = new Track("a003","track5",5,new Artist("a001","amit"));
        when(trackRepository.getTrackByArtistName(track1.getTrackArtist().getArtistName())).thenReturn(mytracks);
        assertThrows(Exception.class,()->trackService.getTrackByArtistName("ab"));

    }
    @Test
    @Order(8)
    public void test_gettrackratinggreaterthan4success() throws Exception
    {
        int trackRating=5;
        when(trackRepository.findAllTrackRatingGreaterThan4(anyInt())).thenReturn(mytracks);
        assertEquals(4,trackService.getTrackWhereTrackRatingGreaterThanFour(trackRating).size());

    }
    @Test
    @Order(9)
    public void test_gettrackratinggreaterthan4failure() throws Exception
    {
        int trackRating=11;
        when(trackRepository.findAllTrackRatingGreaterThan4(anyInt())).thenReturn(mytracks);
        assertNotEquals(0,trackService.getTrackWhereTrackRatingGreaterThanFour(trackRating).size());

    }



}
