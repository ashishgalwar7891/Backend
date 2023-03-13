package com.example.BEJ_C2_S1_REST_MYSQL_MC1.services;

import com.example.BEJ_C2_S1_REST_MYSQL_MC1.domain.Track;

import java.util.List;

public interface TrackServices {
    Track saveTrack(Track track);
    List<Track> getAllTracks();
    List<Track> getTrackByTrackId(String trackId);
    boolean deleteTrackByTrackId(String trackId);
    List<Track> getTrackByTrackArtist(String trackArtist);
    Track updateTrack(Track track,String trackId);
}
