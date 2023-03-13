package com.example.BEJ_C2_S1_REST_MYSQL_MC1.services;

import com.example.BEJ_C2_S1_REST_MYSQL_MC1.domain.Track;
import com.example.BEJ_C2_S1_REST_MYSQL_MC1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServicesImpl implements TrackServices{
    private final TrackRepository trackRepository;
    @Autowired
    public TrackServicesImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }


    @Override
    public List<Track> getTrackByTrackId(String trackId) {
        return (List<Track>) trackRepository.findByTrackId(trackId);
    }
    @Override
    public boolean deleteTrackByTrackId(String trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }
    @Override
    public List<Track> getTrackByTrackArtist(String trackArtist) {
        return (List<Track>) trackRepository.findByTrackArtist(trackArtist);
    }
    @Override
    public Track updateTrack(Track track, String trackId) {
        Optional<Track> optrack=trackRepository.findById(trackId);
        if(optrack.isEmpty()){
            return null;
        }
        Track existingtrack=optrack.get();
        if(track.getTrackName()!=null){
            existingtrack.setTrackName(track.getTrackName());
        }
        if(track.getTrackComments()!=null){
            existingtrack.setTrackComments(track.getTrackComments());
        }
        if(track.getTrackRating()!=null){
            existingtrack.setTrackRating(track.getTrackRating());
        }
        if(track.getTrackArtist()!=null){
            existingtrack.setTrackArtist(track.getTrackArtist());
        }
        return trackRepository.save(existingtrack);
    }

}
