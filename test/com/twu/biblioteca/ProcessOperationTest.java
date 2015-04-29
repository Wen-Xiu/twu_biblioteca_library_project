package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;

import static org.mockito.Matchers.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by qnxu on 4/25/15.
 */
public class ProcessOperationTest {
    public void testOperateMenu() throws IOException{

        Hashtable books = new Hashtable();
        Hashtable lentBooks = new Hashtable();
        BookList bookList = new BookList(books,lentBooks);
        BookListProcessor bookListProcessorForTest = new BookListProcessor(bookList);

        Hashtable movies = new Hashtable();
        Hashtable lentMovies = new Hashtable();
        MovieList moveList = new MovieList(books,lentBooks);
        MovieListProcessor movieListProcessorForTest = new MovieListProcessor(moveList);

        MainProcessor mainProcessor = new MainProcessor(bookListProcessorForTest, movieListProcessorForTest);

        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.inputWithConsole()).thenReturn("0");
        verify(bookListProcessorForTest, atLeastOnce()).printBookList();
        when(mockUserInput.inputWithConsole()).thenReturn("1");
        verify(mainProcessor, atLeastOnce()).operateBookList(anyString());
        when(mockUserInput.inputWithConsole()).thenReturn("2");
        verify(mainProcessor, atLeastOnce()).operateBookList(anyString());
        when(mockUserInput.inputWithConsole()).thenReturn("e");
        verify(mainProcessor, atLeastOnce()).jumpToMenu();
        when(mockUserInput.inputWithConsole()).thenReturn("any wrong input");
        verify(mainProcessor, atLeastOnce()).operateMenu();
    }



    public void testOperateBookList() throws IOException {
        Hashtable books = new Hashtable();
        Hashtable lentBooks = new Hashtable();
        UserInput mockUserInput = mock(UserInput.class);

        String bookName = "<Jane Eyre>";
        books.put(bookName, "author, publish data");
        BookList bookList = new BookList(books,lentBooks);
        BookListProcessor bookListProcessorForTest = new BookListProcessor(bookList);
        BookListProcessor mockBookListProcessor = mock(BookListProcessor.class);

        Hashtable movies = new Hashtable();
        Hashtable lentMovies = new Hashtable();
        MovieList moveList = new MovieList(books,lentBooks);
        MovieListProcessor movieListProcessorForTest = new MovieListProcessor(moveList);


        MainProcessor mainProcessor = new MainProcessor(bookListProcessorForTest, movieListProcessorForTest);


        when(mockUserInput.inputWithConsole()).thenReturn("e");
        verify(mainProcessor, atLeastOnce()).exitOrNot("e");
        when(mockUserInput.inputWithConsole()).thenReturn("q");
        verify(mainProcessor, atLeastOnce()).terminateSystemOrNot("q");
        when(mockUserInput.inputWithConsole()).thenReturn("<Jane Eyre>");
        verify(bookListProcessorForTest, atLeastOnce()).checkoutOrReturnBook("checkout", "<Jane Eyre>");
        mainProcessor.operateBookList("checkout");

    }
}
