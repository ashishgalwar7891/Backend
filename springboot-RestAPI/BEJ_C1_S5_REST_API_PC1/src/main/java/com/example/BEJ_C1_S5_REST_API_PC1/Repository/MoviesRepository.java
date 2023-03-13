package com.example.BEJ_C1_S5_REST_API_PC1.Repository;

import com.example.BEJ_C1_S5_REST_API_PC1.Domain.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movies,String> {
    Movies save();  //For insert and delete
}
