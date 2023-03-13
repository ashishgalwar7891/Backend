package com.example.BEJ_C1_S5_REST_API_PC1.Services;

import com.example.BEJ_C1_S5_REST_API_PC1.Domain.Movies;
import com.example.BEJ_C1_S5_REST_API_PC1.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesServicesImpl implements MoviesServices {
    @Autowired
    private MoviesRepository moviesRepository;
    @Override
    public Movies save(Movies movies){
        return moviesRepository.save(movies);   //use it only for insert not for update.
    }
}
