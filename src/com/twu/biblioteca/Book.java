package com.twu.biblioteca;

/**
 * Created by qnxu on 4/29/15.
 */
public class Book {
    private String name, author, publishYear;

    Book(String bookName, String bookAuthor, String bookPublishYear){
        name = bookName;
        author = bookAuthor;
        publishYear = bookPublishYear;
    }

    public String getBookName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public String getPublishYear(){
        return publishYear;
    }
}
