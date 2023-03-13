package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.service;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.Exception.TrackNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain.Track;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track addTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.findById(track.getTrackId()).isEmpty()) {
            return trackRepository.insert(track);
        } else {
            throw new TrackAlreadyExistsException();
        }
    }

    @Override
    public boolean deleteTrack(String trackId) throws TrackNotFoundException {
        if (trackRepository.findById(trackId).isPresent()) {
            trackRepository.deleteById(trackId);
            return true;
        } else {
            throw new TrackNotFoundException();
        }
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> getTrackWhereTrackRatingGreaterThanFour(int trackRating) throws TrackNotFoundException {
        if (trackRepository.findAllTrackRatingGreaterThan4(trackRating).isEmpty()) {
            throw new TrackNotFoundException();
        }
        return trackRepository.findAllTrackRatingGreaterThan4(trackRating);
    }

    @Override
    public List<Track> getTrackByArtistName(String artistName) throws TrackNotFoundException {
        return trackRepository.getTrackByArtistName(artistName);
    }
}
