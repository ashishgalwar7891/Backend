package com.example.c2.s3.mc1.service;

import com.example.c2.s3.mc1.domain.Track;
import com.example.c2.s3.mc1.exception.TrackAlreadyexistException;
import com.example.c2.s3.mc1.exception.TrackArtistNotFoundException;
import com.example.c2.s3.mc1.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track addTracks(Track track) throws TrackAlreadyexistException;
    public List<Track> getAllTracks();
    public boolean deleteTrackById(String trackId) throws TrackNotFoundException;
    public List<Track> getTracksByRatingGreaterThan4();
    public List<Track> getTrackByTrackArtist(String artistName) throws TrackArtistNotFoundException;
}
