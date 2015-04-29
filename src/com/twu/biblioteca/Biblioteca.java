package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;

public class Biblioteca {


    public static void main(String[] args) throws IOException {
        Hashtable availableBooks = new Hashtable();
        Hashtable lentBooks = new Hashtable();
        BookList bookList = new BookList(availableBooks,lentBooks);
        BookListProcessor bookListProcessor = new BookListProcessor(bookList);

        Hashtable availableMovies = new Hashtable();
        Hashtable lentMovies = new Hashtable();
        MovieList movieList = new MovieList(availableMovies, lentMovies);
        MovieListProcessor movieListProcessor = new MovieListProcessor(movieList);

        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.printWelcomeMessage();

        bookListProcessor.printBookList();
        MainProcessor mainProcessor = new MainProcessor(bookListProcessor, movieListProcessor);
        mainProcessor.operateMenu();
    }

}
