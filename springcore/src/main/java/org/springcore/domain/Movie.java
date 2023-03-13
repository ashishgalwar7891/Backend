package org.springcore.domain;

public class Movie {     // by default extends Object class
    // Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.
    private int MovieId;
    private String MovieName;
    private String password;

    public Movie(){
        System.out.println("bean are created using default constructor");
    }
    public Movie(int MovieId, String MovieName, String password) {
        this.MovieId = MovieId;
        this.MovieName = MovieName;
        this.password = password;
        System.out.println("bean are created using pera constructor");
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }

    public String getMoviename() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "MovieId=" + MovieId +
                ", Moviename='" + MovieName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
