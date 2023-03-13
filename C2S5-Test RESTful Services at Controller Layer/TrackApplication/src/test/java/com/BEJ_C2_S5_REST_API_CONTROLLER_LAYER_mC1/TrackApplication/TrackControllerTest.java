package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.controller.TrackController;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Artist;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Track;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.service.TrackServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import java.util.Arrays;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private TrackServiceImpl trackService;
    @InjectMocks
    private TrackController trackController;

    private Track track1,track2;
    private Artist artist1,artist2;
    private List<Track> trackList;
    @BeforeEach
    void setUp(){
        artist1=new Artist("a001","Atif Aslam");
        track1=new Track("t001","track1",8,artist1);
        artist2=new Artist("a002","Arijit Singh");
        track2=new Track("t002","track2",7,artist2);
        trackList = Arrays.asList(track1,track2);
        mockMvc= MockMvcBuilders.standaloneSetup(trackController).build();
    }
    @AfterEach
    void tearDown(){
        track1=null;
        track2=null;
    }
    @Test
    @Order(1)
    public void test_postTracksuccess() throws Exception{
        when(trackService.addTrack(any())).thenReturn(track1);
        mockMvc.perform(post("/api/track/v1/addTrack").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).addTrack(track1);
    }
    @Test
    @Order(2)
    public void test_postTrackFails() throws Exception{
        when(trackService.addTrack(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(post("/api/track/v1/addTrack").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                        .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).addTrack(track1);
    }
    @Test
    @Order(3)
    public void test_deleteTrackSuccess() throws Exception{
        when(trackService.deleteTrack(any())).thenReturn(true);
        mockMvc.perform(delete("/api/track/v1/deleteTrack/t001").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).deleteTrack(any());
    }
    @Test
    @Order(4)
    public void test_deleteTrackFails() throws Exception{
        when(trackService.deleteTrack(any())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(delete("/api/track/v1/deleteTrack/t001").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).deleteTrack(any());
    }
    @Test
    @Order(5)
    public void test_getTrackSuccess() throws Exception{
        when(trackService.getAllTrack()).thenReturn(trackList);
        mockMvc.perform(get("/api/track/v1/getTrack").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).getAllTrack();
    }
    @Test
    @Order(6)
    public void test_getTrackByTrackRating() throws Exception{
        int trackRating=8;
        when(trackService.getTrackWhereTrackRatingGreaterThanFour(trackRating)).thenReturn(trackList);
        mockMvc.perform(get("/api/track/v1/trackRating/8").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).getTrackWhereTrackRatingGreaterThanFour(trackRating);
    }
    @Test
    @Order(7)
    public void test_getTrackByArtistName() throws Exception{
        String artistName="Atif Aslam";
        when(trackService.getTrackByArtistName(artistName)).thenReturn(trackList);
        mockMvc.perform(get("/api/track/v1/artistName/Atif Aslam").contentType(MediaType.APPLICATION_JSON).content(jsonToString(track1)))
                        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(trackService,times(1)).getTrackByArtistName(artistName);
    }

    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch(JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }

}
