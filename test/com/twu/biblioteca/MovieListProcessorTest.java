package com.twu.biblioteca;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Hashtable;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;

/**
 * Created by qnxu on 4/29/15.
 */
public class MovieListProcessorTest extends TestCase {

    public void testCheckoutOrReturnMovie() throws IOException {

        MovieListProcessor mockMovieListProcessor = mock(MovieListProcessor.class);
        UserInput mockUserInput = mock(UserInput.class);

        Hashtable availableList = new Hashtable();
        Hashtable lentList = new Hashtable();
        Movie movie = new Movie("Happiness", "1990", "derector", 8);
        availableList.put(movie.name, movie);
        MovieList movieList = new MovieList(availableList,lentList);
        MovieListProcessor movieListProcessorForTest = new MovieListProcessor(movieList);
        movieListProcessorForTest.printOperationMessage("return", "movie");
        assertEquals("unsuccessful", movieListProcessorForTest.checkoutOrReturnMovie("return to library", "Happiness"));
        assertEquals("successful", movieListProcessorForTest.checkoutOrReturnMovie("checkout", "Happiness"));
        assertFalse(availableList.containsKey("Happiness"));
        assertTrue(lentList.containsKey("Happiness"));
        assertEquals("unsuccessful", movieListProcessorForTest.checkoutOrReturnMovie("checkout", "unavailable movie"));
        assertEquals("successful", movieListProcessorForTest.checkoutOrReturnMovie("return to library", "Happiness"));
        assertFalse(lentList.containsKey("Happiness"));
        assertTrue(availableList.containsKey("Happiness"));
    }
}
