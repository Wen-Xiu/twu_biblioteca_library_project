package com.twu.biblioteca;

/**
 * Created by qnxu on 4/29/15.
 */
public class Movie {
    public String name, year, director;
    public int rating;

    Movie(String movieName, String movieYear, String movieDirector, int movieRating){
        name = movieName;
        year = movieYear;
        director = movieDirector;
        rating = movieRating;
    }

}
