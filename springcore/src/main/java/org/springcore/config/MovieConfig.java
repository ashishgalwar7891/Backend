package org.springcore.config;

import org.springcore.domain.Movie;
import org.springframework.context.annotation.Bean;

public class MovieConfig {
    @Bean("MovieBean1")
    public Movie getMovie1(){
        Movie m1=new Movie();
        m1.setMovieId(101);
        m1.setMovieName("xxx");
        m1.setPassword("xxx@123");
        return m1;
    }

    @Bean("MovieBean2")
    public Movie getMovie2(){
        return new Movie(102,"yyy","yyy@123");
    }
}
