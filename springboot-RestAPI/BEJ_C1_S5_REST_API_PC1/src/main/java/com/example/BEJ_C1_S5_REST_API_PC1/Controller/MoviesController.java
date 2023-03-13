package com.example.BEJ_C1_S5_REST_API_PC1.Controller;

import com.example.BEJ_C1_S5_REST_API_PC1.Domain.Movies;
import com.example.BEJ_C1_S5_REST_API_PC1.Services.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie")
public class MoviesController {
    @Autowired
    private MoviesServices moviesServices;

    //http://localhost:9000/api/movies/save     [post]
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Movies movies)
    {
        return new ResponseEntity<>(moviesServices.save(movies), HttpStatus.CREATED);
    }
}
