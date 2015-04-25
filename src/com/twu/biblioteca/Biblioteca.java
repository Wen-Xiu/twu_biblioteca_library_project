package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;

public class Biblioteca {


    public static void main(String[] args) throws IOException {
        Books books = new Books();
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.printWelcomeMessage();
        BookList booklist = new BookList(books.availableBooks, books.lentBooks);
        booklist.printBookList();
        ProcessOperation processOperation = new ProcessOperation(booklist);
        processOperation.operateMenu();
    }

}
