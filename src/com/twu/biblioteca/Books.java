package com.twu.biblioteca;

import java.util.Hashtable;

/**
 * Created by qnxu on 4/25/15.
 */
public class Books {
    public static Hashtable availableBooks = new Hashtable();
    public static Hashtable lentBooks = new Hashtable();
    public Books(){
        availableBooks.put("<Jane Eyre>", "author 1,   1880-01-02");
        availableBooks.put("<Lord of the Ring>", "author 2,   1880-03-09");
        availableBooks.put("<Pride and Prejudice>", "author 3,   1880-04-03");
        availableBooks.put("<the kiter runner>", "author 4,   1864-02-03");
    }

}
