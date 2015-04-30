package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;

public class Biblioteca {


    public static void main(String[] args) throws IOException {
        Hashtable availableBooks = new Hashtable();
        Hashtable lentBooks = new Hashtable();
        BookListProcessor bookListProcessor = new BookListProcessor(availableBooks,lentBooks);

        Hashtable availableMovies = new Hashtable();
        Hashtable lentMovies = new Hashtable();
        MovieListProcessor movieListProcessor = new MovieListProcessor(availableMovies,lentMovies);

        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.printWelcomeMessage();

        bookListProcessor.printBookList();
        MainProcessor mainProcessor = new MainProcessor(bookListProcessor, movieListProcessor);
        mainProcessor.operateMenu();
    }

}
