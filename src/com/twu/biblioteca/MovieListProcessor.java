package com.twu.biblioteca;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by qnxu on 4/29/15.
 */
public class MovieListProcessor extends ListProcessor {

    public static Hashtable availableMovieList;
    public static Hashtable lentMovieList;

    MovieListProcessor(MovieList list) {
        availableMovieList = list.availableMovies;
        lentMovieList = list.lentMovies;
    }

    private void printListTitle() {
        System.out.println("       Name                Author    Year Published    Rating");
    }

    public void printMovieList() {
        printListTitle();
        Enumeration keys = availableMovieList.keys();
        while (keys.hasMoreElements()) {
            Movie movie = (Movie) availableMovieList.get(keys.nextElement());
            System.out.println(movie.name + "    " + movie.year + "    " + movie.year + "   " + movie.rating);
        }
    }

    public String checkoutOrReturnMovie(String operation, String name)throws IOException{
       return checkoutOrReturn(operation, name, availableMovieList, lentMovieList);
    }

}
