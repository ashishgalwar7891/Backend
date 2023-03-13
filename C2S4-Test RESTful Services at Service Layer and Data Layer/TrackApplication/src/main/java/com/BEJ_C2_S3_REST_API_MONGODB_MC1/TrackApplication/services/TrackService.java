package com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.services;

import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.domain.Track;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.exception.TrackAlreadyExistsException;
import com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track addTrack(Track track) throws TrackAlreadyExistsException;
    public boolean deleteTrack(String trackId) throws TrackNotFoundException;
    public List<Track> getAllTrack();
    public List<Track> getTrackWhereTrackRatingGreaterThanFour(int trackRating) throws TrackNotFoundException;
    public List<Track> getTrackByArtistName(String artistName) throws TrackNotFoundException;
}
