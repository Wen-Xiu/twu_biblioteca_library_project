package com.twu.biblioteca;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by qnxu on 4/29/15.
 */
public class MovieListProcessor extends ListProcessor {


    private List availableMovieList, lentMovieList;

    MovieListProcessor(Hashtable availableList, Hashtable lentList) {
        availableMovieList = new List(availableList);
        lentMovieList = new List(lentList);
        initializeMovieList();
    }

    private void initializeMovieList(){
        Movie movie1 = new Movie("Fast & Furious 7", "2015", "Justin Lin", 8);
        Movie movie2 = new Movie("The Legend of 1900", "1998", "Giuseppe Tornatore", 10);
        Movie movie3 = new Movie("The Shawshank Redemption", "1994", "Frank Darabont", 9);

        availableMovieList.addToList(movie1);
        availableMovieList.addToList(movie2);
        availableMovieList.addToList(movie3);
    }


    private void printListTitle() {
        System.out.println("       Name                Author    Year Published    Rating");
    }

    public void printMovieList() {
        printListTitle();
        Enumeration keys = availableMovieList.getNamesFromList();
        while (keys.hasMoreElements()) {
            Movie movie = (Movie) availableMovieList.getList().get(keys.nextElement());
            System.out.println(movie.getMovieName() + "    " + movie.getDirector() + "    " + movie.getYear() + "   " + movie.getRating());
        }
    }

    public String checkoutOrReturnMovie(String operation, String name)throws IOException{
       return checkoutOrReturn(operation, name, availableMovieList, lentMovieList);
    }

}
