package com.twu.biblioteca;

/**
 * Created by qnxu on 4/29/15.
 */
public class Movie {
    private String name, year, director;
    private int rating;

    Movie(String movieName, String movieYear, String movieDirector, int movieRating){
        name = movieName;
        year = movieYear;
        director = movieDirector;
        rating = movieRating;
    }

    public String getMovieName(){
        return name;
    }

    public String getYear(){
        return year;
    }

    public String getDirector(){
        return director;
    }

    public int getRating(){
        return rating;
    }
}
