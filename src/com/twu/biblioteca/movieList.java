package com.twu.biblioteca;

import java.util.Hashtable;

/**
 * Created by qnxu on 4/29/15.
 */
public class MovieList {
    public static Hashtable availableMovies;
    public static Hashtable lentMovies;

    MovieList(Hashtable available, Hashtable lent){
        availableMovies = available;
        lentMovies = lent;
        initializeMovieList();
    }
    
    private void initializeMovieList(){
        Movie movie1 = new Movie("Fast & Furious 7", "2015", "Justin Lin", 8);
        Movie movie2 = new Movie("The Legend of 1900", "1998", "Giuseppe Tornatore", 10);
        Movie movie3 = new Movie("The Shawshank Redemption", "1994", "Frank Darabont", 9);

        availableMovies.put(movie1.name, movie1);
        availableMovies.put(movie2.name, movie2);
        availableMovies.put(movie3.name, movie3);
    }
}
