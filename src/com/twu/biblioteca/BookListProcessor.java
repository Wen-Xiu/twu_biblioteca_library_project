package com.twu.biblioteca;
//import java.util.Scanner;
import java.io.IOException;
import java.util.*;

/**
 * Created by qnxu on 4/20/15.
 */
public class BookListProcessor extends ListProcessor {

//    public static Hashtable availableList;
//    public static Hashtable lentList;

    private List availableBookList;
    private List lentBookList;


    private List initializeBookList(){
        Book book1 = new Book("Jane Eyre", "author 1", "1880-01-02");
        Book book2 = new Book("Lord of the Ring", "author 2", "1880-03-09");
        Book book3 = new Book("Pride and Prejudice", "author 3", "1880-04-20");
        Book book4 = new Book("the kiter runner", "author 4", "1866-03-09");

        availableBookList.addToList(book1);
        availableBookList.addToList(book2);
        availableBookList.addToList(book3);
        availableBookList.addToList(book4);

        return availableBookList;
    }



    BookListProcessor(Hashtable availableList, Hashtable lentList){
        availableBookList = new List(availableList);
        lentBookList = new List(lentList);
        initializeBookList();
    }

    private void printListTitle(){
        System.out.println("       Name                Author    Year Published");
    }

    public void printBookList(){
        printListTitle();
        Enumeration keys = availableBookList.getNamesFromList();
        while (keys.hasMoreElements()) {
            Book book = (Book)availableBookList.getList().get(keys.nextElement());
            System.out.println(book.getBookName() + "    " + book.getAuthor() + "    " + book.getPublishYear());
        }
    }

    public String checkoutOrReturnBook(String operation, String name)throws IOException {
       return checkoutOrReturn(operation, name, availableBookList, lentBookList);



    }



}
