package com.twu.biblioteca;

import java.util.Hashtable;

/**
 * Created by qnxu on 4/25/15.
 */
public class BookList {
    public static Hashtable availableBooks ;
    public static Hashtable lentBooks;
    BookList(Hashtable available, Hashtable lent){
        availableBooks = available;
        lentBooks = lent;
        initializeBookList();
    }



    private void initializeBookList(){
        Book book1 = new Book("Jane Eyre", "author 1", "1880-01-02");
        Book book2 = new Book("Lord of the Ring", "author 2", "1880-03-09");
        Book book3 = new Book("Pride and Prejudice", "author 3", "1880-04-20");
        Book book4 = new Book("the kiter runner", "author 4", "1866-03-09");

        availableBooks.put(book1.name, book1);
        availableBooks.put(book2.name, book2);
        availableBooks.put(book3.name, book3);
        availableBooks.put(book4.name, book4);

    }
}
