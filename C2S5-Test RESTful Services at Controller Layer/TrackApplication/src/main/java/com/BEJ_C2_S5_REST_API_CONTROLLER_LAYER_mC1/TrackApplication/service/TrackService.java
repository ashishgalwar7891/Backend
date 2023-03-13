package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.service;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Track;

import java.util.List;

public interface TrackService {
    public Track addTrack(Track track) throws TrackAlreadyExistsException;
    public boolean deleteTrack(String trackId) throws TrackNotFoundException;
    public List<Track> getAllTrack();
    public List<Track> getTrackWhereTrackRatingGreaterThanFour(int trackRating) throws TrackNotFoundException;
    public List<Track> getTrackByArtistName(String artistName) throws TrackNotFoundException;
}
