package com.example.c2.s3.mc1.service;

import com.example.c2.s3.mc1.domain.Track;
import com.example.c2.s3.mc1.exception.TrackAlreadyexistException;
import com.example.c2.s3.mc1.exception.TrackArtistNotFoundException;
import com.example.c2.s3.mc1.exception.TrackNotFoundException;
import com.example.c2.s3.mc1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track addTracks(Track track) throws TrackAlreadyexistException {
     if(trackRepository.findById(track.getTrackId()).isEmpty())
     {
         return trackRepository.insert(track);
     }
     else {
         throw new TrackAlreadyexistException();
     }
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrackById(String trackId) throws TrackNotFoundException {
        if(trackRepository.findById(trackId).isPresent())
        {
            trackRepository.deleteById(trackId);
            return true;
        }
        else {
            throw new TrackNotFoundException();
        }
    }

    @Override
    public List<Track> getTracksByRatingGreaterThan4() {
        return trackRepository.getTrackRatingGreaterThan4();
    }

    @Override
    public List<Track> getTrackByTrackArtist(String artistName)throws TrackArtistNotFoundException {
      List<Track> list1=new ArrayList<>();
       list1=  trackRepository.getTrackByArtist(artistName);
       if(list1.isEmpty())
       {
           throw  new TrackArtistNotFoundException();
       }
       else return list1;
    }
}
